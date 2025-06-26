package com.notification_system.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ye entity represent karti hai ek notification strategy ko —
 * matlab message kis channel ke through bhejna hai: Email, SMS, ya Popup.
 *
 * Strategy Pattern ke base par ye entity kaafi flexible hoti hai:
 * - Easily naye channels add kar sakte hain (WhatsApp, Slack, Telegram, etc.)
 * - Execution ko dynamically engine ke sath map kar sakte hain
 */
@Entity
public class NotificationStrategyEntity {

    /**
     * Auto-generated primary key for each strategy
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Strategy ka type (Enum) — Email, SMS, ya Popup
     * Future me aur bhi values add ki ja sakti hain
     */
    @Enumerated(EnumType.STRING)
    private StrategyType strategyType;

    /**
     * Ye strategy kaun-kaunse engines ke sath mapped hai.
     *
     * One-to-many: ek strategy multiple engine ke sath use ho sakti hai.
     * CascadeType.ALL: agar strategy delete hoti hai to mappings bhi delete ho jaayein.
     */
    @OneToMany(mappedBy = "strategy", cascade = CascadeType.ALL)
    private List<EngineStrategyMap> strategyMappings = new ArrayList<>();

    /**
     * Enum of available strategies.
     * Ye runtime ke behavior ko modular banata hai.
     */
    public enum StrategyType {
        Email, SMS, popup
    }

    // ---------------- Constructors ----------------

    public NotificationStrategyEntity() {
        // Default constructor for JPA
    }

    public NotificationStrategyEntity(long id, StrategyType strategyType) {
        this.id = id;
        this.strategyType = strategyType;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StrategyType getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    public List<EngineStrategyMap> getStrategyMappings() {
        return strategyMappings;
    }

    public void setStrategyMappings(List<EngineStrategyMap> strategyMappings) {
        this.strategyMappings = strategyMappings;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "NotificationStrategyEntity{" +
                "id=" + id +
                ", strategyType=" + strategyType +
                '}';
    }
}
