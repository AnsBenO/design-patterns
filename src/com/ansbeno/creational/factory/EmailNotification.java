package com.ansbeno.creational.factory;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * CONCRETE FACTORY PRODUCT - EmailNotification
 * 
 * Concrete implementation of Notification for email channel.
 * 
 * Note: Uses SingletonLogger for logging, demonstrating pattern composition.
 */
public class EmailNotification implements Notification {
      private static SingletonLogger log = SingletonLogger.getInstance();

      @Override
      public void send(String message) {
            log.info("Sending email: " + message);
      }

}
