package br.com.david.testeinsight.view.service;

import javax.swing.JTable;

/**
 * Service para responsável pelas horas extra
 *
 * @author David Arruda
 */
public interface OverTimeService {

    /**
     * Calcula as horas extra com base na jornada de trabalho e as marcações
     * feitas.
     *
     * @param workingHours
     * @param markingMade
     * @param hoursDelay
     * @throws Exception
     */
    void subtractBetweenHours(JTable workingHours, JTable markingMade, JTable tbOverTime) throws Exception;

}
