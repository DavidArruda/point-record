package br.com.david.testeinsight.service.impl;

import java.time.LocalTime;
import java.util.LinkedList;

import javax.swing.JTable;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.OverTime;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.service.OverTimeServiceTest;
import br.com.david.testeinsight.table.TableModel;

/**
 *
 * @author David Arruda
 */
public class OverTimeServiceImplTest extends CalculateHourServiceImpl implements OverTimeServiceTest {

	@Override
	public void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tbOverTime) throws Exception {
		LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
		LinkedList<MarkingMade> listMKMades = getList(markingMade);

		// Pega os objetos na lista (jornada e marcação feita)
		var jornadaTrabalho = listWorkingHours.getLast();
		var marcacaoFeita = listMKMades.getLast();

		// Pega o periodo para ser inserido no jTable de hora extra
		LocalTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

		// Cria um novo Overtime
		OverTime overTime = new OverTime();
		overTime.setEntryTime(entryAndDeparture[0]);
		overTime.setDepartureTime(entryAndDeparture[1]);

		// Insere no jTable
		tbOverTime.addRow(overTime);

		if (entryAndDeparture.length == 4) {
			OverTime overTime2 = new OverTime();
			overTime2.setEntryTime(entryAndDeparture[2]);
			overTime2.setDepartureTime(entryAndDeparture[3]);

			// Insere no JTable
			tbOverTime.addRow(overTime2);
		}

	}

	@Override
	public LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {

		LinkedList<LocalTime> oversTime = new LinkedList<>();

		if (markingMade.getEntryTime().isBefore(workingHours.getEntryTime())) {
			LocalTime entry = LocalTime.of(markingMade.getEntryTime().getHour(),
					markingMade.getEntryTime().getMinute());
			LocalTime departure = LocalTime.of(workingHours.getEntryTime().getHour(),
					workingHours.getEntryTime().getMinute());

			oversTime.add(entry);
			oversTime.add(departure);
		}

		if (markingMade.getDepartureTime().isAfter(workingHours.getDepartureTime())) {
			LocalTime entry = LocalTime.of(workingHours.getDepartureTime().getHour(),
					workingHours.getDepartureTime().getMinute());

			LocalTime departure = LocalTime.of(markingMade.getDepartureTime().getHour(),
					markingMade.getDepartureTime().getMinute());

			oversTime.add(entry);
			oversTime.add(departure);
		}

		return oversTime.toArray(new LocalTime[oversTime.size()]);
	}

}
