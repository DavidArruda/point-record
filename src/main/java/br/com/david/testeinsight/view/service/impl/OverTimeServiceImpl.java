package br.com.david.testeinsight.view.service.impl;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.OverTime;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableObject;
import br.com.david.testeinsight.view.service.OverTimeService;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public class OverTimeServiceImpl implements OverTimeService {

    @Override
    public void subtractBetweenHours(JTable workingHours, JTable markingMade, JTable tbOverTime) throws Exception {
        LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
        LinkedList<MarkingMade> listMKMades = getList(markingMade);

        //Pega os objetos na lista (jornada e marcação feita)
        var jornadaTrabalho = listWorkingHours.get(0);
        var marcacaoFeita = listMKMades.get(0);

        // Pega o periodo para ser inserido no jTable de hora extra
        LocalTime[] entryAndDeparture = getPeriodOverTime(jornadaTrabalho, marcacaoFeita);
        
        // Cria o novo overTime
        OverTime overTime = new OverTime();
        overTime.setEntryTime(entryAndDeparture[1]);
        overTime.setDepartureTime(entryAndDeparture[2]);
        
        // Insere no jTable
        
        addRowTable(tbOverTime, overTime);
        

    }

    private int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade) {
        //  Subtrai saida - entrada
        int programmedHours = workingHours.getDepartureTime().getHour() - workingHours.getEntryTime().getHour();

        // Subtrai saida - entrada
        int hoursWorked = markingMade.getDepartureTime().getHour() - markingMade.getEntryTime().getHour();

        return hoursWorked - programmedHours;
    }

    private LocalTime[] getPeriodOverTime(WorkingHours workingHours, MarkingMade markingMade) {
        if (markingMade.getEntryTime().isBefore(workingHours.getEntryTime())) {
            LocalTime entry = LocalTime.of(markingMade.getEntryTime().getHour(), markingMade.getEntryTime().getMinute());
            LocalTime departure = LocalTime.of(workingHours.getEntryTime().getHour(), workingHours.getEntryTime().getMinute());

            LocalTime[] period = {entry, departure};

            return period;

        } else {
            LocalTime entry = LocalTime.of(workingHours.getEntryTime().getHour(), workingHours.getEntryTime().getMinute());
            LocalTime departure = LocalTime.of(markingMade.getEntryTime().getHour(), markingMade.getEntryTime().getMinute());

            LocalTime[] period = {entry, departure};

            return period;
        }
    }


    private LinkedList getList(JTable workingHours) throws Exception {
        Class tableModel = workingHours.getModel().getClass(); // Obtem o tipo da classe
        Method method = tableModel.getMethod("getList"); // Obtem o método através de sua assinatura
        LinkedList list = (LinkedList) method.invoke(workingHours.getModel()); // Invoca o método passando de qual classe ele será chamado
        return list;
    }


    private void addRowTable(JTable jTable, TableObject object) throws Exception {
        Class tableModel = jTable.getModel().getClass(); // Obtem o tipo da classe
        Method method = tableModel.getMethod("addRow", object.getClass()); // Obtem o método através de sua assinatura
        method.invoke(jTable.getModel(), object); // Invoca o método passando de qual classe ele será chamado e seus parametros, respectivamente
    }

}
