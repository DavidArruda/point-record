package br.com.david.testeinsight.view.service;

import javax.swing.JTable;

/**
 * Service para responsável pelas horas de atraso
 * @author David Arruda
 */
public interface HoursDelayService {

    /**
     * Calcula as horas de atraso com base na jornada de trabalho e as marcações
     * feitas.
     *
     * @param workingHours
     * @param markingMade
     * @param hoursDelay
     * @return Jtable
     * @throws Exception
     */
    JTable delayHours(JTable workingHours, JTable markingMade, JTable hoursDelay) throws Exception;

}
