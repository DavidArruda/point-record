package br.com.david.testeinsight.model;

import java.time.LocalTime;

/**
 *Classe abstrata para as models
 * @author David Arruda
 */
public abstract class AbstractModel {
    
    protected LocalTime entryTime;
    
    protected LocalTime departureTime;

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
    
}
