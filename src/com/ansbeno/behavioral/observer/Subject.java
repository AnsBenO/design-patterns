package com.ansbeno.behavioral.observer;

import java.util.List;

/**
 * OBSERVER PATTERN - Subject Class
 * 
 * The Observer pattern defines a one-to-many dependency between objects
 * so that when one object changes state, all dependent objects are notified automatically.
 * 
 * In this pattern:
 * - Subject: This class (maintains list of observers/subscribers)
 * - Observer: Subscriber class (objects that want to be notified)
 * 
 * Real-world examples:
 * - News channel (Subject) and Subscribers (Observers)
 * - Email list (Subject) and Email addresses (Observers)
 * - Stock ticker (Subject) and Traders (Observers)
 * 
 * Benefits:
 * - Loose coupling: Subject doesn't need to know observer details
 * - Dynamic subscriptions: Observers can subscribe/unsubscribe at runtime
 * - Event-driven architecture
 * - Automatic notifications
 * 
 * Flow:
 * 1. Subscribers register with the subject
 * 2. Subject maintains a list of subscribers
 * 3. When state changes, subject calls update() on all subscribers
 * 4. Subscribers react to the notification
 */
public class Subject {

      // List of subscribers to be notified
      private List<Subscriber> subscribers;

      // Constructor initializes with subscribers list
      public Subject(List<Subscriber> subscribers) {
            this.subscribers = subscribers;
      }

      // Notify all subscribers about content change
      public void notifySubscribers(String content) {
            for (Subscriber subscriber : subscribers) {
                  subscriber.update(content);
            }
      }

      // Add a new subscriber
      public void registerSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber);
      }

      // Remove a subscriber
      public void unregisterSubscriber(Subscriber subscriber) {
            subscribers.remove(subscriber);
      }

      // Getters and setters
      public List<Subscriber> getSubscribers() {
            return subscribers;
      }

      public void setSubscribers(List<Subscriber> subscribers) {
            this.subscribers = subscribers;
      }

}
