package com.ansbeno.creational.factory;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * CONCRETE FACTORY PRODUCT - PushNotification
 * 
 * Concrete implementation of Notification for push notification channel.
 * Demonstrates the flexibility of the Factory pattern - easy to add new types.
 */
public class PushNotification implements Notification {
      private static SingletonLogger log = SingletonLogger.getInstance();

      @Override
      public void send(String message) {
            log.info("Sending push notification: " + message);
      }
}
