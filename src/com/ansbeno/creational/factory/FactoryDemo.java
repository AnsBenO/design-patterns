package com.ansbeno.creational.factory;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * FACTORY PATTERN DEMO
 * 
 * Purpose: Provides an interface for creating objects without specifying
 * their exact classes. Encapsulates object creation logic.
 * 
 * Key Characteristics:
 * - Factory method creates appropriate object based on parameters
 * - Client code doesn't know about concrete implementations
 * - Central place to add new types
 * - Encapsulates if-else or switch logic
 * 
 * Use Cases: GUI element creation, notification systems, database drivers,
 * payment processors
 * 
 * Benefits: Loose coupling, easy to add new types, centralized creation logic
 * Drawbacks: More classes, potential over-engineering for simple cases
 */
public class FactoryDemo {
    
    private static SingletonLogger log = SingletonLogger.getInstance();
    
    public static void main(String[] args) {
        System.out.println("\n========== FACTORY PATTERN DEMO ==========\n");
        
        // Without Factory Pattern (tight coupling):
        // Notification emailNotif = new EmailNotification();
        
        // With Factory Pattern (loose coupling):
        System.out.println("Creating different notification types using Factory:");
        
        // Email Notification
        System.out.println("\n1. Email Notification:");
        Notification emailNotif = NotificationFactory.createNotification(NotificationType.EMAIL);
        emailNotif.send("Hello via Email");
        
        // SMS Notification
        System.out.println("\n2. SMS Notification:");
        Notification smsNotif = NotificationFactory.createNotification(NotificationType.SMS);
        smsNotif.send("Hello via SMS");
        
        // Push Notification
        System.out.println("\n2. Push Notification:");
        Notification pushNotif = NotificationFactory.createNotification(NotificationType.PUSH);
        pushNotif.send("Hello via Push");
        
        System.out.println("\n\nKey Points:");
        log.info("✓ Factory method hides concrete class creation");
        log.info("✓ Client code only depends on Notification interface");
        log.info("✓ Easy to add new notification types (email, SMS, push, etc.)");
        log.info("✓ All creation logic centralized in NotificationFactory");
        log.info("✓ Polymorphism allows treating all notifications the same way");
    }
}
