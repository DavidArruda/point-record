package br.com.david.testeinsight.model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author David Arruda
 */
public class MarkingMade extends AbstractModel {

    private WorkingHours workingHours = new WorkingHours();

    @Override
    public Object value(int column) {   
        switch (column) {
            case 0:
                return entryTime.format(DateTimeFormatter.ofPattern("hh:mm"));
            case 1:
                return departureTime.format(DateTimeFormatter.ofPattern("hh:mm"));
            case 2:
                return workingHours.getId().toString();
            default: 
                return" - ";
        }
    }

    public static Object[] getColumnsMarkingMade() {
        return new String[]{"Entrada","Saída", "Jornada de Trabalho"};
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

}
