package br.com.david.testeinsight.view.service.impl;

import br.com.david.testeinsight.model.HoursDelay;
import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.view.service.HoursDelayService;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public class HoursDelayServiceImpl extends CalculateHourServiceImpl implements HoursDelayService {

    @Override
    public void subtractBetweenHours(JTable workingHours, JTable markingMade, JTable tbHoursDelay) throws Exception {
        LinkedList<WorkingHours> listWorkingHours = getList(workingHours);
        LinkedList<MarkingMade> listMKMades = getList(markingMade);

        var jornadaTrabalho = listWorkingHours.get(0);
        var marcacaoFeita = listMKMades.get(0);

        LocalTime[] entryAndDeparture = getPeriod(jornadaTrabalho, marcacaoFeita);

        HoursDelay hoursDelay = new HoursDelay();
        hoursDelay.setEntryTime(entryAndDeparture[0]);
        hoursDelay.setDepartureTime(entryAndDeparture[1]);

        addRowTable(tbHoursDelay, hoursDelay);
    }

    @Override
    public LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade) {
        if (markingMade.getEntryTime().isAfter(workingHours.getEntryTime())) {
            LocalTime entry = LocalTime.of(workingHours.getEntryTime().getHour(), workingHours.getEntryTime().getMinute());
            LocalTime departure = LocalTime.of(markingMade.getEntryTime().getHour(), markingMade.getEntryTime().getMinute());

            LocalTime[] period = {entry, departure};

            return period;

        } else {
            LocalTime entry = LocalTime.of(markingMade.getEntryTime().getHour(), markingMade.getEntryTime().getMinute());
            LocalTime departure = LocalTime.of(workingHours.getEntryTime().getHour(), workingHours.getEntryTime().getMinute());

            LocalTime[] period = {entry, departure};

            return period;
        }
    }

    @Override
    public void subtractBetweenJtable(JTable tbWorkingHours, JTable tbMarkingMade) {
        
    }

}
