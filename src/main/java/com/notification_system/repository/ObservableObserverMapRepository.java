package com.notification_system.repository;

import com.notification_system.model.ObservableObserverMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Ye repository ObservableObserverMap entity ke liye database access provide karti hai.
 *
 * Iska main kaam hai ye track karna ki:
 * - Kaunsa observable kis-kis observer ke sath attached hai
 * - Jab observable trigger ho to observer list fetch kar sakein
 *
 * Ye repository Observer Pattern ke linking logic ko support karti hai.
 */
public interface ObservableObserverMapRepository extends JpaRepository<ObservableObserverMap, Long> {

    /**
     * Ye method ek specific observable ID ke liye
     * uske saare linked observers ko return karti hai.
     *
     * @param findByObservableId Observable ki ID
     * @return List of ObservableObserverMap (jo observable-observer pairs hain)
     */
    List<ObservableObserverMap> findByObservableId(Long findByObservableId);
}
