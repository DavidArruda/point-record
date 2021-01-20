/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.david.testeinsight.service.impl;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.service.EntryAndDepartureService;
import java.time.LocalTime;

/**
 *
 * @author David Arruda
 */
public class EntryAndDepartureServiceImpl implements EntryAndDepartureService {

    @Override
    public void verifyEntryAndDeparture(MarkingMade markingMade, int resultEntrys, int resultDepartures) {
        if (resultEntrys >= 24) { // SE MAIOR QUE 24 A ENTRADA FOI REALIZA NO DIA POSTERIOR A ENTRADA ESPERADA
            markingMade.setEntryTime(markingMade.getEntryTime().plusDays(1));
            markingMade.setDepartureTime(markingMade.getDepartureTime().plusDays(1));

        } else if (resultDepartures >= 24) { // SE MAIOR QUE 24 A SAÍDA FOI REALIZA NO DIA POSTERIOR A SAÍDA ESPERADA
            markingMade.setDepartureTime(markingMade.getDepartureTime().plusDays(1));
        }
    }

    @Override
    public int nextDayEntry(MarkingMade markingMade, LocalTime entryTime) {
        // PEGA A DIFERENÇA DO HORARIO DE ENTRADA (HORARIOS DE TRABALHO) COM O HORARIO
        // DE ENTRADA (MARCAÇÃO)
        int subtracteEntry = markingMade.getWorkingHours().getEntryTime().getHour() - entryTime.getHour();

        // SOMA ENTRADA (HORARIOS DE TRABALHO) COM A SUBTRACT_ENTRY
        return markingMade.getWorkingHours().getEntryTime().getHour() + subtracteEntry;
    }

    @Override
    public int nextDayDeparture(MarkingMade markingMade, LocalTime departureTime) {
        // PEGA A DIFERENÇA DO HORARIO DE ENTRADA (HORARIOS DE TRABALHO) COM O HORARIO
        // DE SAÍDA (MARCAÇÃO)
        int subtractDepartures = markingMade.getWorkingHours().getEntryTime().getHour() - departureTime.getHour();

        // SOMA ENTRADA (HORARIOS DE TRABALHO) COM A SUBTRACT_DEPARTURES
        return markingMade.getWorkingHours().getEntryTime().getHour() + subtractDepartures;
    }

}
