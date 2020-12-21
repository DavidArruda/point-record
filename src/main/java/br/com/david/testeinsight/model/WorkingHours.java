package br.com.david.testeinsight.model;

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
            	return entryTime.toLocalTime().toString();
            case 1:
                return departureTime.toLocalTime().toString();
                case 2:
                return this.id.toString();
            default: 
                return" - ";
        }
    }

    public static Object[] getColumnsWorkingHours() {
        return new String[]{"Entrada", "Saída", "ID"};
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
