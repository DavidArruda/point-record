package br.com.david.testeinsight.model;

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
                return entryTime.toLocalTime().toString();
            case 1:
                return departureTime.toLocalTime().toString();
            case 2:
                return workingHours.getEntryTime().toLocalTime() + " as " + workingHours.getDepartureTime().toLocalTime();
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
