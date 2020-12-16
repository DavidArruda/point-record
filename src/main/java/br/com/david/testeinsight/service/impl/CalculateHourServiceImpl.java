package br.com.david.testeinsight.service.impl;

import java.lang.reflect.Method;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableObject;
import br.com.david.testeinsight.service.CalculateHoursService;

/**
 *
 * @author David Arruda
 */
public abstract class CalculateHourServiceImpl implements CalculateHoursService {

    @Override // modificar método recever JTable
    public int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade) {
        //  Subtrai saida - entrada
        int programmedHours = workingHours.getDepartureTime().getHour() - workingHours.getEntryTime().getHour();

        // Subtrai saida - entrada
        int hoursWorked = markingMade.getDepartureTime().getHour() - markingMade.getEntryTime().getHour();

        return hoursWorked - programmedHours;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public LinkedList getList(JTable workingHours) throws Exception {
        Class<? extends TableModel> tableModel = workingHours.getModel().getClass(); // Obtem o tipo da classe
        Method method = tableModel.getMethod("getList"); // Obtem o método através de sua assinatura
        LinkedList list = (LinkedList) method.invoke(workingHours.getModel()); // Invoca o método passando de qual classe ele será chamado
        return list;
    }


    //Corrigir método
    @Override
    public void addRowTable(JTable jTable, TableObject object) throws Exception {
        Class tableModel = jTable.getModel().getClass(); // Obtem o tipo da classe
		Method method = tableModel.getMethod("addRowTest", new Class[] {object.getClass()}); // Obtem o método através de sua assinatura
        method.setAccessible(true);
		method.invoke(jTable.getModel(), new TableObject[] {object}); // Invoca o método passando de qual classe ele será chamado e seus parametros, respectivamente
    }

}
