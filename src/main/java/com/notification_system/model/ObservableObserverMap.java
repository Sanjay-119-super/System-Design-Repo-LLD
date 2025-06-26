package com.notification_system.model;

import javax.persistence.*;

/**
 * Ye entity ek bridge banati hai Observable aur Observer ke beech,
 * jiska kaam hai track karna ki kaunse observer kis observable ke sath linked hai.
 *
 * Ye table observer pattern ka mapping point hai:
 * Jab bhi observable trigger hota hai → is mapping se observers milte hain → notify kiya jaata hai.
 */
@Entity
public class ObservableObserverMap {

    /**
     * Primary key (auto-generated)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ye field represent karti hai kis Observable ke liye mapping hai
     */
    @ManyToOne
    private NotificationObservableEntity observable;

    /**
     * Ye field represent karti hai ki kaunsa Observer us Observable se linked hai
     */
    @ManyToOne
    private ObserverEntity observerEntity;

    // ---------------- Constructors ----------------

    public ObservableObserverMap() {
        // JPA default constructor
    }

    public ObservableObserverMap(long id, NotificationObservableEntity observable, ObserverEntity observerEntity) {
        this.id = id;
        this.observable = observable;
        this.observerEntity = observerEntity;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NotificationObservableEntity getObservable() {
        return observable;
    }

    public void setObservable(NotificationObservableEntity observable) {
        this.observable = observable;
    }

    public ObserverEntity getObserverEntity() {
        return observerEntity;
    }

    public void setObserverEntity(ObserverEntity observerEntity) {
        this.observerEntity = observerEntity;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "ObservableObserverMap{" +
                "id=" + id +
                ", observable=" + observable +
                ", observerEntity=" + observerEntity +
                '}';
    }
}
