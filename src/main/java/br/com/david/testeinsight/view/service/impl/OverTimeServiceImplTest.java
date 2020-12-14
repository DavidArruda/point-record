package br.com.david.testeinsight.view.service.impl;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.OverTime;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.view.service.OverTimeServiceTest;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public class OverTimeServiceImplTest extends CalculateHourServiceImpl implements OverTimeServiceTest {

    @Override
    public void subtractBetweenHours(JTable workingHours, JTable markingMade, JTable tbOverTime) throws Exception {
        LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
        LinkedList<MarkingMade> listMKMades = getList(markingMade);

        //Pega os objetos na lista (jornada e marcação feita)
        var jornadaTrabalho = listWorkingHours.get(0);
        var marcacaoFeita = listMKMades.get(0);

        // Pega o periodo para ser inserido no jTable de hora extra
        LocalTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

        // Cria o novo overTime
        OverTime overTime = new OverTime();
        overTime.setEntryTime(entryAndDeparture[1]);
        overTime.setDepartureTime(entryAndDeparture[2]);

        // Insere no jTable
        addRowTable(tbOverTime, overTime);

    }

    @Override
    public LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {
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

}
