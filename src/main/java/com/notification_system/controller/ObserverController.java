package com.notification_system.controller;

import com.notification_system.model.ObserverEntity;
import com.notification_system.repository.ObserverRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Ye controller "Observer" entities ka data manage karta hai.
 *
 * Observer ka matlab hota hai: wo component jo kisi notification ke changes ko observe karta hai,
 * jaise Email Observer, SMS Observer, WhatsApp Observer etc.
 *
 * Is controller ka main kaam:
 * - Naya observer create karna
 * - Saare available observers list karna
 */
@RestController // Batata hai ki ye REST API controller hai (JSON data return karega)
@RequestMapping("/api/observers") // Is controller ke sabhi APIs /api/observers se start honge
@CrossOrigin("*") // Frontend (React, Angular) ke CORS issue ko avoid karta hai
public class ObserverController {

    // Repository jo database ke saath observer ka CRUD kaam handle karti hai
    private final ObserverRepository observerRepository;

    /**
     * Constructor-based dependency injection
     *
     * @param observerRepository Observer data ko DB me save/fetch karne ke liye
     */
    public ObserverController(ObserverRepository observerRepository) {
        this.observerRepository = observerRepository;
    }

    /**
     * Ye API ek naya observer create karti hai.
     *
     * Use-case: Admin chahta hai ki naya communication channel add ho — e.g., "Telegram Observer"
     *
     * @param body JSON format me request aata hai — jisme "name" key expected hoti hai
     * @return Saved observer entity (with ID and name)
     */
    @PostMapping
    public ResponseEntity<ObserverEntity> create(@RequestBody Map<String, String> body) {
        // Naya observer entity banate hain
        ObserverEntity observerEntity = new ObserverEntity();

        // Observer ka naam set karte hain (jaise: "EmailObserver", "SMSObserver")
        observerEntity.setName(body.get("name"));

        // DB me save karke return kar dete hain
        return ResponseEntity.ok(observerRepository.save(observerEntity));
    }

    /**
     * Ye API saare observers ko list karta hai jo system me available hain.
     *
     * Ye mostly frontend dropdowns ya table me observers dikhane ke liye use hota hai.
     *
     * @return JSON array of all observers
     */
    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(observerRepository.findAll());
    }
}
