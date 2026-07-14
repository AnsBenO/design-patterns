package com.ansbeno.structural.facade;

/**
 * FACADE PATTERN DEMO
 * 
 * Purpose: Provides a unified, simplified interface to a complex subsystem
 * of classes, making it easier to use.
 * 
 * Key Characteristics:
 * - Hides complex subsystem components
 * - Provides single simplified interface
 * - Orchestrates complex interactions
 * - Reduces client dependencies
 * 
 * Use Cases: Computer startup sequence, database operations, library wrappers,
 * API simplification
 * 
 * Benefits: Simplifies complex systems, loose coupling, easier to understand
 * Drawbacks: Can become a "god object", might hide important details
 */
public class FacadeDemo {
    
    public static void main(String[] args) {
        System.out.println("\n========== FACADE PATTERN DEMO ==========\n");
        
        System.out.println("Without Facade (complex, error-prone):");
        System.out.println("client code must know about all components:");
        System.out.println("  hardDrive.read();");
        System.out.println("  memory.load();");
        System.out.println("  cpu.freeze();");
        System.out.println("  cpu.execute();");
        
        System.out.println("\n\nWith Facade (simple, clean):");
        System.out.println("Client only calls one method:");
        System.out.println("  computer.start();");
        
        System.out.println("\n\nActual execution sequence:");
        // Create facade
        ComputerFacade computer = new ComputerFacade();
        
        // Simple interface hides complex startup sequence
        computer.start();
        
        System.out.println("\nWhat happened behind the scenes:");
        System.out.println("✓ Facade called hardDrive.read()");
        System.out.println("✓ Facade called memory.load()");
        System.out.println("✓ Facade called cpu.freeze()");
        System.out.println("✓ Facade called cpu.execute()");
        
        System.out.println("\nKey Points:");
        System.out.println("✓ Client doesn't know about CPU, Memory, HardDrive");
        System.out.println("✓ Facade knows the correct sequence of operations");
        System.out.println("✓ Complex subsystem hidden behind simple interface");
        System.out.println("✓ Easy to change internal implementation");
        System.out.println("✓ Reduces client complexity significantly");
    }
}
