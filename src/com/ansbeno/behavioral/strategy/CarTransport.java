package com.ansbeno.behavioral.strategy;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * CONCRETE STRATEGY - CarTransport
 * 
 * One concrete implementation of the TransportStrategy interface.
 * Different strategies can have completely different implementations.
 */
public class CarTransport implements TransportStrategy {

      private static final SingletonLogger log = SingletonLogger.getInstance();

      @Override
      public void transport() {
            log.info("Transporting by car...");
      }

}
