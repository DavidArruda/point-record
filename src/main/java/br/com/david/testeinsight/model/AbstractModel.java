package br.com.david.testeinsight.model;

import br.com.david.testeinsight.table.TableObject;
import java.time.LocalTime;

/**
 * Classe abstrata para as models
 *
 * @author David Arruda
 */
public abstract class AbstractModel implements TableObject{

    protected LocalTime entryTime;

    protected LocalTime departureTime;

    @Override
    public Object value(int column) {   
        switch (column) {
            case 0:
                return entryTime.toString();
            case 1:
                return departureTime.toString();
            default: 
                return" - ";
        }
    }
    
    /**
     * Retorna um array com os nomes das colunas que serão apresentadas
     * @return Object[]
     */
    static public Object[] getColumns() {
        return new String[]{"Entrada","Saída"};
    }
    
    
    // Getters e Setters
    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    //ToString
    @Override
    public String toString() {
        return entryTime + "," + departureTime;
    }
   
    
}
