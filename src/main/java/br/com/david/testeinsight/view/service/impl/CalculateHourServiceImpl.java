package br.com.david.testeinsight.view.service.impl;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableObject;
import br.com.david.testeinsight.view.service.CalculateHoursService;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public abstract class CalculateHourServiceImpl implements CalculateHoursService {

    @Override
    public abstract void subtractBetweenHours(JTable workingHours, JTable markingMade, JTable jTable) throws Exception;

    @Override // modificar método recever JTable
    public int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade) {
        //  Subtrai saida - entrada
        int programmedHours = workingHours.getDepartureTime().getHour() - workingHours.getEntryTime().getHour();

        // Subtrai saida - entrada
        int hoursWorked = markingMade.getDepartureTime().getHour() - markingMade.getEntryTime().getHour();

        return hoursWorked - programmedHours;
    }

    @Override
    public abstract LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade);


    @Override
    public LinkedList getList(JTable workingHours) throws Exception {
        Class tableModel = workingHours.getModel().getClass(); // Obtem o tipo da classe
        Method method = tableModel.getMethod("getList"); // Obtem o método através de sua assinatura
        LinkedList list = (LinkedList) method.invoke(workingHours.getModel()); // Invoca o método passando de qual classe ele será chamado
        return list;
    }


    @Override
    public void addRowTable(JTable jTable, TableObject object) throws Exception {
        Class tableModel = jTable.getModel().getClass(); // Obtem o tipo da classe
        Method method = tableModel.getMethod("addRow", object.getClass()); // Obtem o método através de sua assinatura
        method.invoke(jTable.getModel(), object); // Invoca o método passando de qual classe ele será chamado e seus parametros, respectivamente
    }

}
