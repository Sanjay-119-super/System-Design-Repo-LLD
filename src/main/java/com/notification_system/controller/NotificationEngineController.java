package com.notification_system.controller;

import com.notification_system.service.NotificationEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Ye controller ka kaam hai:
 * - Notification Engine ko manually trigger karna jab koi notification execute karni ho.
 *
 * Example: Notification ready hai database me, ab hume use SMS ya Email me bhejna hai.
 */
@RestController // Spring ko batata hai ki ye REST API controller hai (JSON response return karega)
@RequestMapping("/api/engine") // Is controller ke sabhi endpoints "/api/engine" se start honge
@CrossOrigin("*") // Frontend application se CORS allow karta hai (React/Angular se direct call ho sake)
public class NotificationEngineController {

    // Service layer jisme pura engine ka business logic likha hota hai
    private final NotificationEngineService service;

    /**
     * Constructor-based injection: Engine service inject ho rahi hai
     *
     * @param service NotificationEngineService jo backend ka main logic chalata hai
     */
    public NotificationEngineController(NotificationEngineService service) {
        this.service = service;
    }

    /**
     * Ye endpoint ek notification ko manually trigger karta hai.
     *
     * Real world example: Admin ya system ne decide kiya ki notification "run" karni hai.
     *
     * @param notificationId Ye us notification ka ID hai jise trigger karna hai
     * @return Success message agar notification process kar li gayi
     *
     * Future me yahan service call me actual logic jaayega jo SMS, Email ya WhatsApp bhejega.
     */
    @PostMapping("/trigger/{notificationId}")
    public ResponseEntity<String> trigger(@PathVariable Long notificationId) {
        // Service layer ko call karte hain (abhi actual execution ka logic missing hai)
        service.triggerNotification(notificationId); // Future ready service call
        return ResponseEntity.ok("Notification triggered.");
    }
}
