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
	 * @param indexCombox 
	 * @param hoursDelay
	 * @throws Exception
	 * 
	 * @return void
	 */
	void subtractBetweenHours(JTable workingHours, JTable markingMade, TableModel tableModel, int indexCombox) throws Exception;

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

}