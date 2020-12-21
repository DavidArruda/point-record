package br.com.david.testeinsight.controller;

import java.time.LocalTime;

import javax.swing.JTable;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.service.HoursDelayService;
import br.com.david.testeinsight.service.OverTimeServiceTest;
import br.com.david.testeinsight.service.impl.HoursDelayServiceImpl;
import br.com.david.testeinsight.service.impl.OverTimeServiceImplTest;
import br.com.david.testeinsight.table.TableModel;

/**
 * 
 * @author David Arruda
 *
 */
public class MarkingMadeController {
	
    private HoursDelayService delayService = new HoursDelayServiceImpl();
    private OverTimeServiceTest overTimeService = new OverTimeServiceImplTest();
    
    /**
     * Adiciona as horas pendentes no devido JTable
     * 
     * @param markingMade
     * @param workingHours
     * @param tableWorkingHours
     * @param tbMKMade
     * @param tbModelHRDelay
     * @param tbModelOverTime
     * @throws Exception
     */
	public void addPendingHours(MarkingMade markingMade, WorkingHours workingHours, JTable tableWorkingHours, JTable tbMKMade, TableModel tbModelHRDelay, TableModel tbModelOverTime) throws Exception {
		//VERIFICA SE ENTRADA FOI DEPOIS DA ENTRADA PROGRAMADA OU SE A SAIDA FOI ANTES DA SAIDA PROGRAMADA (HORARIO DE TRABALHO)
		if (markingMade.getEntryTime().isAfter(workingHours.getEntryTime()) 
				|| markingMade.getDepartureTime().isBefore(workingHours.getDepartureTime())) {
			delayService.subtractBetweenHours(tableWorkingHours, tbMKMade, tbModelHRDelay);

		}
		
		// VERIFICA SE A ENTRADA FOI ANTES OU SE A SAIDA FOI DEPOIS DA ENTRADA PROGRAMADA
		if (markingMade.getEntryTime().isBefore(workingHours.getEntryTime()) 
				|| markingMade.getDepartureTime().isAfter(workingHours.getDepartureTime())) {
		    overTimeService.subtractBetweenHours(tableWorkingHours, tbMKMade, tbModelOverTime);
		}
	}

	/**
	 * Verifica se a entrada ou saída foi realizada no mesmo dia. Caso não seja no
	 * mesmo dia adiciona um dia a mais.
	 * 
	 * @param markingMade
	 * @param resultEntrys
	 * @param resultDepartures
	 */
	public void verifyEntryAndDeparture(MarkingMade markingMade, int resultEntrys, int resultDepartures) {
		if (resultEntrys >= 24) { // SE MAIOR QUE 24 A ENTRADA FOI REALIZA NO DIA POSTERIOR A ENTRADA ESPERADA
			markingMade.setEntryTime(markingMade.getEntryTime().plusDays(1));
			markingMade.setDepartureTime(markingMade.getDepartureTime().plusDays(1));

		} else if (resultDepartures >= 24) { // SE MAIOR QUE 24 A SAÍDA FOI REALIZA NO DIA POSTERIOR A SAÍDA ESPERADA
			markingMade.setDepartureTime(markingMade.getDepartureTime().plusDays(1));
		}
	}

	/**
	 * Calcula se a marcação referente a entrada foi realizada no mesmo dia.
	 * 
	 * @param markingMade
	 * @param entryTime
	 * @return int
	 */
	public int nextDayEntry(MarkingMade markingMade, LocalTime entryTime) {
		// PEGA A DIFERENÇA DO HORARIO DE ENTRADA (HORARIOS DE TRABALHO) COM O HORARIO
		// DE ENTRADA (MARCAÇÃO)
		int subtracteEntry = markingMade.getWorkingHours().getEntryTime().getHour() - entryTime.getHour();

		// SOMA ENTRADA (HORARIOS DE TRABALHO) COM A SUBTRACT_ENTRY
		return markingMade.getWorkingHours().getEntryTime().getHour() + subtracteEntry;
	}

	/**
	 * Calcula se a marcação referente a saída foi realizada no mesmo dia.
	 * 
	 * @param markingMade
	 * @param departureTime
	 * @return int
	 */
	public int nextDayDeparture(MarkingMade markingMade, LocalTime departureTime) {
		// PEGA A DIFERENÇA DO HORARIO DE ENTRADA (HORARIOS DE TRABALHO) COM O HORARIO
		// DE SAÍDA (MARCAÇÃO)
		int subtractDepartures = markingMade.getWorkingHours().getEntryTime().getHour() - departureTime.getHour();

		// SOMA ENTRADA (HORARIOS DE TRABALHO) COM A SUBTRACT_DEPARTURES
		return markingMade.getWorkingHours().getEntryTime().getHour() + subtractDepartures;
	}

}
