package com.notification_system.controller;

import com.notification_system.model.Notification;
import com.notification_system.model.NotificationObservableEntity;
import com.notification_system.model.ObservableObserverMap;
import com.notification_system.model.ObserverEntity;
import com.notification_system.repository.NotificationObservableRepository;
import com.notification_system.repository.NotificationRepository;
import com.notification_system.repository.ObservableObserverMapRepository;
import com.notification_system.repository.ObserverRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Ye controller "Observable" system ko manage karta hai.
 *
 * Observable ka matlab hai: koi notification event jise multiple observers (like SMS, Email) sunte hain.
 *
 * Main kaam:
 * - Observable create karna (ek specific notification ke liye)
 * - Us observable me observer (listener) ko attach karna
 */
@RestController
@RequestMapping("/api/observable") // Saare endpoints is base URI se start honge
@CrossOrigin("*") // Frontend se CORS allow karta hai (localhost, etc. ke liye)
public class ObservableController {

    private final NotificationRepository notificationRepository;
    private final NotificationObservableRepository observableRepository;
    private final ObserverRepository observerRepository;
    private final ObservableObserverMapRepository observableObserverMapRepository;

    /**
     * Constructor-based dependency injection (clean aur testable code ke liye)
     *
     * @param notificationRepository Notification data access
     * @param observableRepository Observable entity ka data access
     * @param observerRepository Observer entity ka data access
     * @param observableObserverMapRepository Mapping table ka data access
     */
    public ObservableController(NotificationRepository notificationRepository,
                                NotificationObservableRepository observableRepository,
                                ObserverRepository observerRepository,
                                ObservableObserverMapRepository observableObserverMapRepository) {
        this.notificationRepository = notificationRepository;
        this.observableRepository = observableRepository;
        this.observerRepository = observerRepository;
        this.observableObserverMapRepository = observableObserverMapRepository;
    }

    /**
     * Ye API ek observable create karta hai, kisi ek notification ke liye.
     *
     * Example: Tumhare paas ek "meeting notification" hai, jisko multiple observers sunenge (SMS, WhatsApp).
     *
     * @param body JSON format me request body aayegi jisme "notificationId" hoga
     * @return Created NotificationObservableEntity
     *
     * @throws RuntimeException agar notificationId invalid hai (DB me nahi mila)
     */
    @PostMapping("/create")
    public ResponseEntity<NotificationObservableEntity> create(@RequestBody Map<String, Long> body) {

        Long notifId = body.get("notificationId");

        // Notification fetch karo — agar nahi mila toh error throw karo
        Notification notification = notificationRepository.findById(notifId)
                .orElseThrow(() -> new RuntimeException("Notification not found for Observable."));

        // Observable entity create karo aur notification set karo
        NotificationObservableEntity observable = new NotificationObservableEntity();
        observable.setNotification(notification);

        // Observable ko save karke return karo
        return ResponseEntity.ok(observableRepository.save(observable));
    }

    /**
     * Ye API ek observer ko kisi observable ke saath attach karti hai.
     *
     * Use-case: Humne ek notification observable banaya hai, ab usme WhatsApp/SMS/email observer attach karna hai.
     *
     * @param observableId Observable entity ka ID
     * @param observerId Observer entity ka ID
     * @return Success message agar attach ho gaya
     *
     * @throws RuntimeException agar observable ya observer invalid ho
     */
    @PostMapping("/{observableId}/attach/{observerId}")
    public ResponseEntity<String> attach(@PathVariable Long observableId,
                                         @PathVariable Long observerId) {

        // Observable fetch karo
        NotificationObservableEntity observable = observableRepository.findById(observableId)
                .orElseThrow(() -> new RuntimeException("Observable not found"));

        // Observer fetch karo
        ObserverEntity observer = observerRepository.findById(observerId)
                .orElseThrow(() -> new RuntimeException("Observer not found"));

        // Mapping entity create karo jisme observable aur observer link ho
        ObservableObserverMap map = new ObservableObserverMap();
        map.setObservable(observable);
        map.setObserverEntity(observer);

        // Mapping DB me save karo
        observableObserverMapRepository.save(map);

        // Response return karo
        return ResponseEntity.ok("Observer successfully attached to observable.");
    }
}
