package br.com.david.testeinsight.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JTable;

import br.com.david.testeinsight.model.HoursDelay;
import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.service.HoursDelayService;
import br.com.david.testeinsight.table.TableModel;

/**
 *
 * @author David Arruda
 */
public class HoursDelayServiceImpl extends CalculateHourServiceImpl implements HoursDelayService {

	@SuppressWarnings("unchecked")
	@Override
	public void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tbHoursDelay, int indexCombox)
			throws Exception {
		LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
		LinkedList<MarkingMade> listMKMades = getList(markingMade);

		var jornadaTrabalho = listWorkingHours.get(indexCombox);
		var marcacaoFeita = listMKMades.getLast();

		LocalDateTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

		HoursDelay hoursDelay = new HoursDelay();
		hoursDelay.setEntryTime(entryAndDeparture[0]);
		hoursDelay.setDepartureTime(entryAndDeparture[1]);

		// ADICIONA NO JTABLE DE HORAS DE ATRASO
		tbHoursDelay.addRow(hoursDelay);

		// VERIFICA SE EXISTE MAIS HORAS DE ATRASO
		if (entryAndDeparture.length == 4) {
			HoursDelay hoursDelay2 = new HoursDelay();
			hoursDelay2.setEntryTime(entryAndDeparture[2]);
			hoursDelay2.setDepartureTime(entryAndDeparture[3]);

			tbHoursDelay.addRow(hoursDelay2);
		}

	}

	@Override
	public LocalDateTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {
		ArrayList<LocalDateTime> delays = new ArrayList<>();

		if (markingMade.getEntryTime().isAfter(workingHours.getEntryTime())) {
			LocalDateTime entry = workingHours.getEntryTime();
			LocalDateTime departure = markingMade.getEntryTime();

			delays.add(entry);
			delays.add(departure);

		}

		if (markingMade.getDepartureTime().isBefore(workingHours.getDepartureTime())) {
			LocalDateTime entry = markingMade.getDepartureTime();
			LocalDateTime departure = workingHours.getDepartureTime();

			delays.add(entry);
			delays.add(departure);
		}

		return delays.toArray(new LocalDateTime[delays.size()]);
	}

}
