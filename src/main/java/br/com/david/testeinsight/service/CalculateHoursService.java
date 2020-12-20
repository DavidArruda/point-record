package br.com.david.testeinsight.service;

import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JTable;

import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableModel;

/**
 *
 * @author David Arruda
 */
public interface CalculateHoursService {

	/**
	 * Calcula as horas extra ou horas em atraso com base na jornada de trabalho e
	 * as marcações feitas. Retorna o objeto que será adicionado jTable de atraso ou
	 * hora extra
	 *
	 * @param workingHours
	 * @param markingMade
	 * @param hoursDelay
	 * @throws Exception
	 * 
	 * @return void
	 */
	void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tableModel) throws Exception;

	/**
	 * Se return == 0 então não existe horas pedentes. Se return >0 então existe
	 * horas extra. se return <0 então existe horas de atraso.
	 *
	 * @param workingHours
	 * @param markingMade
	 * @return int hours
	 */
	int subtractPeriods(WorkingHours workingHours, MarkingMade markingMade);

	/**
	 * Calcula os períodos a ser adicionado no JTable de Atrasos ou HorasExtra
	 *
	 * @param workingHours
	 * @param markingMade
	 * @return LocalTime[]
	 */
	LocalDateTime[] getPeriod(WorkingHours workingHours, MarkingMade markingMade);

	/**
	 * Retorna a lista do model de um Jtable qualquer. A lista é recuperada via API
	 * de Reflection
	 *
	 * @param workingHours
	 * @return LinkedList list
	 * @throws Exception
	 */
	LinkedList<?> getList(JTable workingHours) throws Exception;

	/**
	 * Calcula as horas pendentes. se == 0 então não possui horas pendentes.
	 * 
	 * @param workingHours
	 * @param markingMade
	 * @return int
	 */
	int calcPendingHoursEntry(WorkingHours workingHours, MarkingMade markingMade);
	
	/**
	 * Calcula as horas pendentes. se == 0 então não possui horas pendentes.
	 * 
	 * @param workingHours
	 * @param markingMade
	 * @return int
	 */
	int calcPendingHoursDeparture(WorkingHours workingHours, MarkingMade markingMade);

}