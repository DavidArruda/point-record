package br.com.david.testeinsight.service.impl;

import java.time.LocalDateTime;
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
	public void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tbOverTime, int indexComboBox) throws Exception {
		LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
		LinkedList<MarkingMade> listMKMades = getList(markingMade);

		// Pega os objetos na lista (jornada e marcação feita)
		var jornadaTrabalho = listWorkingHours.get(indexComboBox);
		var marcacaoFeita = listMKMades.getLast();

		// Pega o periodo para ser inserido no jTable de hora extra
		LocalDateTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

		// Cria um novo Overtime
		OverTime overTime = new OverTime();
		overTime.setEntryTime(entryAndDeparture[0]);
		overTime.setDepartureTime(entryAndDeparture[1]);

		// Insere no jTable
		tbOverTime.addRow(overTime);
		overTime = null;

		if (entryAndDeparture.length == 4) {
			OverTime overTime2 = new OverTime();
			overTime2.setEntryTime(entryAndDeparture[2]);
			overTime2.setDepartureTime(entryAndDeparture[3]);

			// Insere no JTable
			tbOverTime.addRow(overTime2);
			
			overTime2 = null;
		}

	}

	@Override
	public LocalDateTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {

		LinkedList<LocalDateTime> oversTime = new LinkedList<>();

		if (markingMade.getEntryTime().isBefore(workingHours.getEntryTime())) {
			LocalDateTime entry = markingMade.getEntryTime();
			LocalDateTime departure = workingHours.getEntryTime();

			oversTime.add(entry);
			oversTime.add(departure);
		}

		if (markingMade.getDepartureTime().isAfter(workingHours.getDepartureTime())) {
			LocalDateTime entry = workingHours.getDepartureTime();

			LocalDateTime departure = markingMade.getDepartureTime();

			oversTime.add(entry);
			oversTime.add(departure);
		}

		return oversTime.toArray(new LocalDateTime[oversTime.size()]);
	}

}
