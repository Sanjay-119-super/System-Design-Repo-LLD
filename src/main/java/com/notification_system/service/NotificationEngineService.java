package com.notification_system.service;

import com.notification_system.decorator.INotification;
import com.notification_system.decorator.SignatureDecorator;
import com.notification_system.decorator.SimpleNotification;
import com.notification_system.decorator.TimeStampDecorator;
import com.notification_system.model.Notification;
import com.notification_system.model.NotificationDecoratorMeta;
import com.notification_system.model.NotificationObservableEntity;
import com.notification_system.observer.LoggerObserver;
import com.notification_system.repository.NotificationDecoratorMetaRepository;
import com.notification_system.repository.NotificationObservableRepository;
import com.notification_system.repository.NotificationRepository;
import com.notification_system.repository.ObservableObserverMapRepository;
import com.notification_system.strategy.EmailStrategy;
import com.notification_system.strategy.POPUPStrategy;
import com.notification_system.strategy.SMSStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NotificationEngineService poore notification system ka execution handle karta hai.
 *
 * Ye service 3 main kaam karti hai:
 *
 * 1. Notification content pe decorators apply karta hai (Decorator Pattern)
 * 2. Observers ko notify karta hai (Observer Pattern)
 * 3. Notification ko different channels pe bhejta hai (Strategy Pattern: Email, SMS, Popup)
 */
@Service
public class NotificationEngineService {

    // Repositories and strategies required for engine execution
    private final NotificationRepository notificationRepo;
    private final NotificationDecoratorMetaRepository decoratorRepo;
    private final LoggerObserver loggerObserver;
    private final EmailStrategy emailStrategy;
    private final SMSStrategy smsStrategy;
    private final POPUPStrategy popupStrategy;
    private final NotificationObservableRepository observableRepo;
    private final ObservableObserverMapRepository mapRepo;

    /**
     * Constructor – All dependencies injected via Spring (Autowired implicitly)
     */
    public NotificationEngineService(
            NotificationRepository notificationRepo,
            NotificationDecoratorMetaRepository decoratorRepo,
            LoggerObserver loggerObserver,
            EmailStrategy emailStrategy,
            SMSStrategy smsStrategy,
            POPUPStrategy popupStrategy,
            NotificationObservableRepository observableRepo,
            ObservableObserverMapRepository mapRepo) {

        this.notificationRepo = notificationRepo;
        this.decoratorRepo = decoratorRepo;
        this.loggerObserver = loggerObserver;
        this.emailStrategy = emailStrategy;
        this.smsStrategy = smsStrategy;
        this.popupStrategy = popupStrategy;
        this.observableRepo = observableRepo;
        this.mapRepo = mapRepo;
    }

    /**
     * Ye method ek specific notification ko trigger karta hai.
     *
     * Steps:
     * 1. Notification content fetch karta hai
     * 2. Decorators apply karta hai (timestamp, signature etc.)
     * 3. Observers notify karta hai (e.g., LoggerObserver)
     * 4. Har strategy (Email, SMS, Popup) ke through notification bhejta hai
     *
     * @param notificationId Ye wo notification hai jise trigger karna hai
     */
    public void triggerNotification(Long notificationId) {

        // Step 1: Notification fetch karo database se
        Notification notification = notificationRepo.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        // Step 2: Base notification object create karo
        INotification notificationContent = new SimpleNotification(notification.getContent());

        // Step 3: Is notification ke liye decorators fetch karo
        List<NotificationDecoratorMeta> decoratorMetas = decoratorRepo.findByNotificationId(notificationId);

        // Step 4: Apply each decorator dynamically
        for (NotificationDecoratorMeta d : decoratorMetas) {
            switch (d.getDecoratorType()) {
                case TIMESTAMP:
                    notificationContent = new TimeStampDecorator(notificationContent);
                    break;
                case SIGNATURE:
                    notificationContent = new SignatureDecorator(notificationContent);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown decorator: " + d.getDecoratorType());
            }
        }

        // Final decorated content ready (timestamp, signature, etc.)
        String finalContent = notificationContent.getContent();

        // Step 5: Notify observers attached to this notification
        List<NotificationObservableEntity> all = observableRepo.findAll();
        for (NotificationObservableEntity observable : all) {
            if (observable.getNotification().getId() == notificationId) {
                loggerObserver.update(finalContent);  // Example observer: Logger
            }
        }

        // Step 6: Use different strategies to send the notification
        emailStrategy.sendNotification(finalContent);
        smsStrategy.sendNotification(finalContent);
        popupStrategy.sendNotification(finalContent);
    }
}
