package com.ansbeno.behavioral.strategy;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * CONCRETE STRATEGY - BusTransport
 * 
 * Another concrete implementation of the TransportStrategy interface.
 * Each strategy can have its own unique implementation.
 */
public class BusTransport implements TransportStrategy {
      private static final SingletonLogger log = SingletonLogger.getInstance();

      @Override
      public void transport() {
            log.info("Transporting by bus...");
      }

}
