package com.ansbeno.creational.singleton;

/**
 * SINGLETON PATTERN DEMO
 * 
 * Purpose: Ensures that a class has only one instance and provides a global
 * point of access to it.
 * 
 * Key Characteristics:
 * - Private constructor prevents instantiation from outside
 * - Static instance created once at class loading
 * - getInstance() provides global access point
 * - Only ONE instance exists throughout the application
 * 
 * Use Cases: Logger, Database connection pool, Configuration manager, Thread pool
 * 
 * Benefits: Memory efficient, thread-safe, consistent state
 * Drawbacks: Hides dependencies, hard to test, violates Single Responsibility
 */
public class SingletonDemo {
    
    public static void main(String[] args) {
        System.out.println("\n========== SINGLETON PATTERN DEMO ==========\n");
        
        // Get the same instance multiple times
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();
        SingletonLogger logger3 = SingletonLogger.getInstance();

        // All references point to the same object in memory
        boolean sameInstance1 = (logger1 == logger2);
        boolean sameInstance2 = (logger2 == logger3);
        
        logger1.info("logger1 == logger2: " + sameInstance1);
        logger1.info("logger2 == logger3: " + sameInstance2);
        
        logger1.info("\nKey Points:");
        logger1.info("✓ Singleton ensures only ONE instance exists");
        logger1.info("✓ Multiple getInstance() calls return the SAME object");
        logger1.info("✓ Memory efficient and ensures consistent behavior");
        logger1.info("✓ Perfect for shared global resources like loggers");
        
        logger1.debug("This is a debug message from the singleton logger");
    }
}
