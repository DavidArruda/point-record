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
                return entryTime.toString();
            case 1:
                return departureTime.toString();
            case 2:
                return workingHours.getId().toString();
            default: 
                return" - ";
        }
    }

    static public Object[] getColumnsMarkingMade() {
        return new String[]{"Entrada","Saída", "Jornada de Trabalho"};
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

}
