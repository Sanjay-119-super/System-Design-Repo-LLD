package com.notification_system.controller;

import com.notification_system.model.Notification;
import com.notification_system.model.NotificationDecoratorMeta;
import com.notification_system.repository.NotificationDecoratorMetaRepository;
import com.notification_system.repository.NotificationRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Ye controller notification system ka main entry point hai.
 *
 * Ye teen kaam karta hai:
 * 1. Nayi notification create karna
 * 2. Saari notifications fetch karna
 * 3. Kisi ek notification ke upar decorator (jaise emoji, timestamp) lagana
 */
@RestController // Spring ko batata hai ki ye class REST API banayegi (JSON return karegi)
@RequestMapping("/api/notifications") // Is controller ke saare API endpoints is path se start honge
@CrossOrigin("*") // Frontend alag port/domain pe ho to CORS allow karta hai
public class NotificationController {

    // Notification ke data ko database me save/fetch karne ke liye
    private final NotificationRepository notificationRepository;

    // Decorator data ko database me save karne ke liye
    private final NotificationDecoratorMetaRepository decoratorMetaRepository;

    /**
     * Constructor ke through dono repositories inject ho rahi hain.
     * Spring automatically isko handle karega.
     *
     * @param notificationRepository notification ke liye DB access
     * @param decoratorMetaRepository decorator ke liye DB access
     */
    public NotificationController(NotificationRepository notificationRepository,
                                  NotificationDecoratorMetaRepository decoratorMetaRepository) {
        this.notificationRepository = notificationRepository;
        this.decoratorMetaRepository = decoratorMetaRepository;
    }

    /**
     * Ye method ek nayi notification create karta hai.
     *
     * @param body Request body me jo data frontend se aayega (JSON format me)
     *             Expected key: "content"
     * @return ResponseEntity ke through saved Notification return hoti hai
     */
    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Map<String, String> body) {
        Notification notification = new Notification();

        // "content" value ko body se nikal kar set kar rahe hain
        notification.setContent(body.get("content"));

        // Notification ko database me save karke return kar rahe hain
        return ResponseEntity.ok(notificationRepository.save(notification));
    }

    /**
     * Ye method saari notifications ko fetch karta hai jo database me saved hain.
     *
     * Mostly frontend me notification list dikhane ke liye use hota hai.
     *
     * @return Saari notifications ka list
     */
    @GetMapping
    public List<Notification> all() {
        return notificationRepository.findAll();
    }

    /**
     * Ye method ek specific notification ke upar decorator add karta hai.
     *
     * Decorator ka matlab hota hai: extra cheezein jodna — jaise emoji, timestamp, sms flag, etc.
     *
     * @param id Notification ka ID jisme decorator lagana hai
     * @param body JSON format me data aata hai frontend se:
     *             - "type": decorator ka type (enum value hona chahiye, jaise Timestamp, Emoji)
     *             - "value": us decorator ka actual value (true/false, 😄, etc.)
     * @return Success message agar decorator successfully save ho gaya
     */
    @PostMapping("/{id}/decorators")
    public ResponseEntity<String> addDecorator(@PathVariable Long id,
                                               @RequestBody Map<String, String> body) {
        // Pehle ye check kar rahe hain ki notification exist karti hai ya nahi
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        // Ek naya decorator object bana rahe hain
        NotificationDecoratorMeta decoratorMeta = new NotificationDecoratorMeta();

        // Usme notification attach kar rahe hain jisme ye decorator lagega
        decoratorMeta.setNotification(notification);

        // Type set kar rahe hain (enum se convert karna zaroori hai)
        decoratorMeta.setDecoratorType(
                NotificationDecoratorMeta.DecoratorType.valueOf(body.get("type"))
        );

        // Value set kar rahe hain (true/false ya koi emoji string)
        decoratorMeta.setDecoratorValue(body.get("value"));

        // Ab decorator database me save kar rahe hain
        decoratorMetaRepository.save(decoratorMeta);

        // Return me simple success message bhej rahe hain
        return ResponseEntity.ok("Decorator added successfully");
    }
}
