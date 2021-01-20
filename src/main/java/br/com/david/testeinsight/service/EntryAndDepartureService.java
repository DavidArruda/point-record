package br.com.david.testeinsight.service;

import br.com.david.testeinsight.model.MarkingMade;
import java.time.LocalTime;

/**
 *
 * @author David Arruda
 */
public interface EntryAndDepartureService {

    /**
     * Calcula se a marcação referente a saída foi realizada no mesmo dia.
     *
     * @param markingMade
     * @param departureTime
     * @return int
     */
    int nextDayDeparture(MarkingMade markingMade, LocalTime departureTime);

    /**
     * Calcula se a marcação referente a entrada foi realizada no mesmo dia.
     *
     * @param markingMade
     * @param entryTime
     * @return int
     */
    int nextDayEntry(MarkingMade markingMade, LocalTime entryTime);

    /**
     * Verifica se a entrada ou saída foi realizada no mesmo dia. Caso não seja
     * no mesmo dia adiciona um dia a mais.
     *
     * @param markingMade
     * @param resultEntrys
     * @param resultDepartures
     */
    void verifyEntryAndDeparture(MarkingMade markingMade, int resultEntrys, int resultDepartures);
    
}
