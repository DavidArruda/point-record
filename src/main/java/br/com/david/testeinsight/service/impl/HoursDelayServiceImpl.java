package br.com.david.testeinsight.service.impl;

import br.com.david.testeinsight.model.HoursDelay;
import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.service.HoursDelayService;
import br.com.david.testeinsight.table.TableModel;
import br.com.david.testeinsight.table.TableObject;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public class HoursDelayServiceImpl extends CalculateHourServiceImpl implements HoursDelayService {

	@SuppressWarnings("unchecked")
	@Override
	public void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tbHoursDelay)
			throws Exception {
		LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
		LinkedList<MarkingMade> listMKMades = getList(markingMade);

		var jornadaTrabalho = listWorkingHours.getLast();
		var marcacaoFeita = listMKMades.getLast();

		LocalTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

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
	public LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {
		ArrayList<LocalTime> delays = new ArrayList<>();

		if (markingMade.getEntryTime().isAfter(workingHours.getEntryTime())) {
			LocalTime entry = LocalTime.of(workingHours.getEntryTime().getHour(),
					workingHours.getEntryTime().getMinute());
			LocalTime departure = LocalTime.of(markingMade.getEntryTime().getHour(),
					markingMade.getEntryTime().getMinute());

			delays.add(entry);
			delays.add(departure);

			/*
			 * if (markingMade.getDepartureTime().isBefore(workingHours.getDepartureTime()))
			 * { LocalTime entry2 = LocalTime.of(markingMade.getDepartureTime().getHour(),
			 * markingMade.getDepartureTime().getMinute()); LocalTime departure2 =
			 * LocalTime.of(workingHours.getDepartureTime().getHour(),
			 * workingHours.getDepartureTime().getMinute());
			 * 
			 * LocalTime[] period = { entry, departure, entry2, departure2 }; return period;
			 * }
			 * 
			 * LocalTime[] period = { entry, departure }; return period;
			 */
		}

		if (markingMade.getDepartureTime().isBefore(workingHours.getDepartureTime())) {

			LocalTime entry = LocalTime.of(markingMade.getDepartureTime().getHour(),
					markingMade.getDepartureTime().getMinute());
			LocalTime departure = LocalTime.of(workingHours.getDepartureTime().getHour(),
					workingHours.getDepartureTime().getMinute());

			delays.add(entry);
			delays.add(departure);
		}

		return delays.toArray(new LocalTime[delays.size()]);
	}

}
