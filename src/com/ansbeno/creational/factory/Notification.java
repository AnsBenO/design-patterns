package com.ansbeno.creational.factory;

/**
 * FACTORY PATTERN INTERFACE
 * 
 * Defines the contract for all concrete notification implementations.
 * 
 * Benefits of using an interface:
 * - Decouples client code from concrete implementations
 * - Client only depends on this interface, not specific notification classes
 * - Easy to add new notification types without modifying client code
 * - Enables polymorphism and flexibility
 */
public interface Notification {
      /**
       * Sends a message through this notification channel
       * 
       * @param message The message to send
       */
      void send(String message);
}