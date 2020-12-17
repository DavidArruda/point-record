package br.com.david.testeinsight.service;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableObject;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public interface CalculateHoursService {
    
    /**
     * Calcula as horas extra ou horas em atraso com base na jornada de trabalho e as marcações
     * feitas. Retorna o objeto que será adicionado jTable de atraso ou hora extra
     *
     * @param workingHours
     * @param markingMade
     * @param hoursDelay
     * @throws Exception
     * 
     * @return TableObject
     */
    TableObject subtractBetweenHours(JTable workingHours, JTable markingMade, JTable jTable) throws Exception;

    /**
     * Se return == 0 então não existe horas pedentes.
     * Se return >0 então existe horas extra.
     * se return <0 então existe horas de atraso.
     *
     * @param workingHours
     * @param markingMade
     * @return int hours
     */
    int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade);

    /**
     * Calcula o periodo a ser adicionado no JTable de Atrasos ou HorasExtra
     *
     * @param workingHours
     * @param markingMade
     * @return
     */
    LocalTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade); // Falta terminar refinar implementação para pegar todos os periodos Corretemente

    /**
     * Retorna a lista do model de um Jtable qualquer. A lista é recuperada via
     * API de Reflection
     *
     * @param workingHours
     * @return LinkedList list
     * @throws Exception
     */
    LinkedList getList(JTable workingHours) throws Exception;

    /**
     * Insere uma nova linha em um JTable qualquer. A inserção é feita via api
     * Reflection
     *
     * @param jTable
     * @param object
     * @throws Exception
     */
    void addRowTable(JTable jTable, TableObject object) throws Exception; //Falta corrigir implementação. Deu ruim.

}