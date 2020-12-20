package br.com.david.testeinsight.service.impl;

import java.lang.reflect.Method;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.service.CalculateHoursService;

/**
 *
 * @author David Arruda
 */
public abstract class CalculateHourServiceImpl implements CalculateHoursService {

	@Override // modificar método recever JTable
	public int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade) {
		// Subtrai saida - entrada
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
		LinkedList list = (LinkedList) method.invoke(workingHours.getModel()); // Invoca o método passando de qual
																				// classe ele será chamado
		return list;
	}
	
	@Override
	public int calcPendingHoursDeparture(WorkingHours workingHours, MarkingMade markingMade) {
		int hoursPending;
		
		// SE A SAIDA DA MARCAÇÃO FOR ANTES DA SAIDA DO HORÁRIO DE TRABALHO
		if (markingMade.getDepartureTime().isBefore(workingHours.getDepartureTime())) {
			hoursPending = markingMade.getDepartureTime().getHour() - workingHours.getDepartureTime().getHour();
		
		} else {
			hoursPending = workingHours.getDepartureTime().getHour() - markingMade.getDepartureTime().getHour();
		}
		
		return hoursPending;
	}
	
	@Override
	public int calcPendingHoursEntry(WorkingHours workingHours, MarkingMade markingMade) {
		int hoursPending;

		// SE A ENTRADA DA MARCAÇÃO FOR APÓS A ENTRADA DO HORÁRIO DE TRABALHO
		if (markingMade.getEntryTime().isAfter(workingHours.getEntryTime())) {
			hoursPending = markingMade.getEntryTime().getHour() - workingHours.getEntryTime().getHour();
		
		} else {
			hoursPending = workingHours.getEntryTime().getHour() - markingMade.getEntryTime().getHour();
		}

		return hoursPending;
	}
	
	

}
