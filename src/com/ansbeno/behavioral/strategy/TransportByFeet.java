package com.ansbeno.behavioral.strategy;

/**
 * CONCRETE STRATEGY - TransportByFeet
 * 
 * Third concrete implementation of the TransportStrategy interface.
 * Demonstrates that strategies can be added without modifying existing code.
 */
public class TransportByFeet implements TransportStrategy {

      @Override
      public void transport() {
            System.out.println("Transporting by feet...");
      }
}
