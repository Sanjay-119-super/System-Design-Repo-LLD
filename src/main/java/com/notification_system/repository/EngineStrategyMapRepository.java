package com.notification_system.repository;

import com.notification_system.model.EngineStrategyMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Ye interface EngineStrategyMap entity ke liye database operations handle karta hai.
 *
 * Is repository ka use karke hum jaan sakte hain ki:
 * - Kis notification engine ke sath kaun-kaun si strategies mapped hain.
 *
 * Spring Data JPA automatically is interface ke liye implementation generate karta hai.
 */
public interface EngineStrategyMapRepository extends JpaRepository<EngineStrategyMap, Long> {

    /**
     * Ye method return karta hai saare mappings (EngineStrategyMap)
     * jo kisi specific engineId ke liye present hain.
     *
     * @param engineId Notification Engine ka ID
     * @return List of EngineStrategyMap (jo strategies engine se linked hain)
     */
    List<EngineStrategyMap> findByEngineId(Long engineId);
}
