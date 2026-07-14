package com.ansbeno.creational.factory;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * CONCRETE FACTORY PRODUCT - SmsNotification
 * 
 * Concrete implementation of Notification for SMS channel.
 * Each concrete product implements the Notification interface independently.
 */
public class SmsNotification implements Notification {
      private static SingletonLogger log = SingletonLogger.getInstance();

      @Override
      public void send(String message) {
            log.info("Sending SMS: " + message);
      }

}
