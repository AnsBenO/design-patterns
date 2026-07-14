package com.ansbeno.creational.factory;

/**
 * FACTORY PATTERN - Factory Class
 * 
 * Factory pattern encapsulates object creation logic in a single place.
 * 
 * Key responsibilities:
 * - Static factory method createNotification() creates appropriate notification type
 * - Client code doesn't need to know about EmailNotification, SmsNotification, etc.
 * - Central place to add new notification types
 * - Encapsulates "if-else" or "switch" logic for object creation
 * 
 * Benefits:
 * - Client code remains unchanged when new notification types are added
 * - Object creation logic is centralized
 * - Reduces tight coupling between client and concrete classes
 * - Easier to maintain and extend
 * 
 * Without Factory Pattern:
 * Notification notification = new EmailNotification();  // Tight coupling
 * 
 * With Factory Pattern:
 * Notification notification = NotificationFactory.createNotification(EMAIL);  // Loose coupling
 */
public class NotificationFactory {

      /**
       * Factory method that creates and returns appropriate Notification implementation
       * 
       * @param type The type of notification to create (EMAIL, SMS, PUSH)
       * @return A Notification instance of the specified type
       * @throws IllegalArgumentException if type is not recognized
       */
      public static Notification createNotification(NotificationType type) {
            switch (type) {
                  case EMAIL:
                        return new EmailNotification();
                  case SMS:
                        return new SmsNotification();
                  case PUSH:
                        return new PushNotification();
                  default:
                        throw new IllegalArgumentException("Unknown notification type: " + type);
            }
      }

}
