package br.com.david.testeinsight.model;

import java.time.LocalDateTime;

import br.com.david.testeinsight.table.TableObject;

/**
 * Classe abstrata para as models
 *
 * @author David Arruda
 */
public abstract class AbstractModel implements TableObject {

	protected LocalDateTime entryTime;

	protected LocalDateTime departureTime;

	@Override
	public Object value(int column) {
		switch (column) {
		case 0:
			return entryTime.toString();
		case 1:
			return departureTime.toString();
		default:
			return " - ";
		}
	}

	/**
	 * Retorna um array com os nomes das colunas que serão apresentadas
	 * 
	 * @return Object[]
	 */
	static public Object[] getColumns() {
		return new String[] { "Entrada", "Saída" };
	}

	// Getters e Setters
	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	// ToString
	@Override
	public String toString() {
		return entryTime + "," + departureTime;
	}

}
