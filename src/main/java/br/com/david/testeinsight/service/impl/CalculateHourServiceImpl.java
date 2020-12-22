package br.com.david.testeinsight.service.impl;

import java.lang.reflect.Method;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.com.david.testeinsight.service.CalculateHoursService;

/**
 *
 * @author David Arruda
 */
public abstract class CalculateHourServiceImpl implements CalculateHoursService {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public LinkedList getList(JTable workingHours) throws Exception {
		Class<? extends TableModel> tableModel = workingHours.getModel().getClass(); // Obtem o tipo da classe
		Method method = tableModel.getMethod("getList"); // Obtem o método através de sua assinatura
		LinkedList list = (LinkedList) method.invoke(workingHours.getModel()); // Invoca o método passando de qual classe ele será chamado
		return list;
	}

}
