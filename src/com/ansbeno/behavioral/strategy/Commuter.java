package com.ansbeno.behavioral.strategy;

/**
 * STRATEGY PATTERN - Context Class
 * 
 * The context class (Commuter) uses a strategy to perform its operations.
 * 
 * Key characteristics:
 * - Holds a reference to a TransportStrategy
 * - Delegates the actual work to the current strategy
 * - Can change the strategy at runtime (setTransportStrategy)
 * - Doesn't care which concrete strategy implementation is used
 * 
 * This design allows Commuter to support unlimited transport strategies
 * without creating multiple subclasses or using if-else statements.
 */
public class Commuter {

      // Current strategy (can be changed at runtime)
      private TransportStrategy transportStrategy;

      // Execute the commute using the current strategy
      public void commute() {
            transportStrategy.transport();
      }

      // Change the strategy at runtime
      public void setTransportStrategy(TransportStrategy transportStrategy) {
            this.transportStrategy = transportStrategy;
      }

}
