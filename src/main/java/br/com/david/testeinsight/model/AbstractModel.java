package br.com.david.testeinsight.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.david.testeinsight.table.TableObject;

/**
 * Classe abstrata para as models
 *
 * @author David Arruda
 */
public abstract class AbstractModel implements TableObject, Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer id;

	protected LocalDateTime entryTime;

	protected LocalDateTime departureTime;

	@Override
	public Object value(int column) {
		switch (column) {
		case 0:
			return entryTime.toLocalTime().toString();
		case 1:
			return departureTime.toLocalTime().toString();
		default:
			return " - ";
		}
	}

	/**
	 * Retorna um array com os nomes das colunas que serão apresentadas
	 * 
	 * @return Object[]
	 */
	public static Object[] getColumns() {
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
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	// ToString
	@Override
	public String toString() {
		return entryTime.toLocalTime() + " as " + departureTime.toLocalTime();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractModel other = (AbstractModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
