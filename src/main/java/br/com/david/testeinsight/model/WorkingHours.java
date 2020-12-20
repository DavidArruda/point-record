package br.com.david.testeinsight.model;

import java.time.format.DateTimeFormatter;

/**
 * Classe modelo para representar Horário de trabalho
 *
 * @author David Arruda
 */
public class WorkingHours extends AbstractModel {
    
    private Integer id;
    
    @Override
    public Object value(int column) {   
        switch (column) {
            case 0:
                return entryTime.format(DateTimeFormatter.ofPattern("hh:mm"));
            case 1:
                return departureTime.format(DateTimeFormatter.ofPattern("hh:mm"));
                case 2:
                return this.id.toString();
            default: 
                return" - ";
        }
    }

    static public Object[] getColumnsWorkingHours() {
        return new String[]{"Entrada", "Saída", "ID"};
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
