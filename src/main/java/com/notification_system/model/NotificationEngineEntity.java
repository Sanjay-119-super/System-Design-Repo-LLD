package com.notification_system.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ye entity ek NotificationEngine ko represent karti hai
 * jo kisi specific Observable ke liye configured hota hai.
 *
 * Engine ka kaam hai:
 * - Observable trigger hone par notification send karna
 * - Strategies ke through customize karna (retry, log, filter, etc.)
 */
@Entity
public class NotificationEngineEntity {

    /**
     * Auto-generated primary key for engine
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ye engine kis Observable ke liye trigger hoga
     *
     * One-to-one mapping: har observable ke liye ek engine
     */
    @OneToOne
    private NotificationObservableEntity observableEntity;

    /**
     * Engine ke sath kaun-kaunse strategies judi hui hain
     *
     * One-to-many mapping: ek engine multiple strategy mappings rakh sakta hai
     * Cascade = ALL: agar engine delete ho to strategies bhi delete ho jaayein
     */
    @OneToMany(mappedBy = "engine", cascade = CascadeType.ALL)
    private List<EngineStrategyMap> strategyMappings = new ArrayList<>();

    // ------------- Constructors -------------

    public NotificationEngineEntity() {
        // JPA default constructor
    }

    public NotificationEngineEntity(long id, NotificationObservableEntity observableEntity) {
        this.id = id;
        this.observableEntity = observableEntity;
    }

    // ------------- Getters and Setters -------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NotificationObservableEntity getObservableEntity() {
        return observableEntity;
    }

    public void setObservableEntity(NotificationObservableEntity observableEntity) {
        this.observableEntity = observableEntity;
    }

    public List<EngineStrategyMap> getStrategyMappings() {
        return strategyMappings;
    }

    public void setStrategyMappings(List<EngineStrategyMap> strategyMappings) {
        this.strategyMappings = strategyMappings;
    }

    // ------------- toString -------------

    @Override
    public String toString() {
        return "NotificationEngineEntity{" +
                "id=" + id +
                ", observableEntity=" + observableEntity +
                '}';
    }
}
