package com.ansbeno.behavioral.strategy;

import com.ansbeno.creational.singleton.SingletonLogger;

/**
 * STRATEGY PATTERN DEMO
 * 
 * Purpose: Encapsulates a family of algorithms, makes them interchangeable,
 * and lets the algorithm vary independently from clients that use it.
 * 
 * Key Characteristics:
 * - Defines family of algorithms as separate classes
 * - Each algorithm implements same interface
 * - Client can switch algorithms at runtime
 * - Eliminates if-else statements for behavior selection
 * 
 * Use Cases: Sorting algorithms, payment methods, compression formats,
 * caching strategies, route planning
 * 
 * Benefits: Runtime flexibility, eliminates conditionals, open/closed principle
 * Drawbacks: More classes, can be overkill for simple cases
 */
public class StrategyDemo {
    
    private static SingletonLogger log = SingletonLogger.getInstance();
    
    public static void main(String[] args) {
        System.out.println("\n========== STRATEGY PATTERN DEMO ==========\n");
        
        System.out.println("Scenario: Commuter can use different transportation strategies\n");
        
        // Create commuter
        Commuter commuter = new Commuter();
        
        // Strategy 1: Commute by Car
        System.out.println("Strategy 1: Commuting by Car");
        commuter.setTransportStrategy(new CarTransport());
        commuter.commute();
        System.out.println("Car: Fast, expensive, comfortable\n");
        
        // Strategy 2: Commute by Bus
        System.out.println("Strategy 2: Commuting by Bus");
        commuter.setTransportStrategy(new BusTransport());
        commuter.commute();
        System.out.println("Bus: Medium speed, affordable, crowded\n");
        
        // Strategy 3: Commute by Feet
        System.out.println("Strategy 3: Commuting by Feet");
        commuter.setTransportStrategy(new TransportByFeet());
        commuter.commute();
        System.out.println("Feet: Slow, free, healthy\n");
        
        // Switch back to car
        System.out.println("Strategy 4: Back to Car (it's raining now)");
        commuter.setTransportStrategy(new CarTransport());
        commuter.commute();
        
        System.out.println("\n\nWithout Strategy Pattern (bad approach):");
        System.out.println("  if (commute == BY_CAR) car.drive();");
        System.out.println("  else if (commute == BY_BUS) bus.ride();");
        System.out.println("  else if (commute == BY_FEET) walk.go();");
        System.out.println("  // Adding new strategy requires modifying this code");
        
        System.out.println("\n\nWith Strategy Pattern (good approach):");
        System.out.println("  commuter.setTransportStrategy(new CarTransport());");
        System.out.println("  commuter.commute(); // Uses current strategy");
        System.out.println("  // Adding new strategy: just create new class, no changes needed");
        
        System.out.println("\n\nKey Points:");
        log.info("✓ Strategies can be selected at runtime");
        log.info("✓ Adding new strategies doesn't modify existing code");
        log.info("✓ Each strategy has its own implementation");
        log.info("✓ Follows Open/Closed Principle");
        log.info("✓ Eliminates complex conditional logic");
    }
}
