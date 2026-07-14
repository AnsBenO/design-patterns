package com.ansbeno.structural.facade;

/**
 * FACADE PATTERN - Facade Class
 * 
 * The Facade pattern provides a unified, simplified interface to a complex
 * subsystem of classes, making it easier to use.
 * 
 * In this example:
 * - The computer startup process is complex (CPU, Memory, HardDrive interactions)
 * - Instead of exposing all components, ComputerFacade provides a simple start() method
 * - Clients don't need to know about individual components
 * 
 * Without Facade (complex client code):
 * hardDrive.read();
 * memory.load();
 * cpu.freeze();
 * cpu.execute();
 * 
 * With Facade (simple client code):
 * computer.start();
 * 
 * Benefits:
 * - Simplifies complex subsystems
 * - Reduces client dependencies on subsystem components
 * - Promotes loose coupling
 * - Makes the system easier to understand and use
 * 
 * Key difference from Adapter:
 * - Adapter: Makes incompatible interfaces work together
 * - Facade: Simplifies complex interfaces
 */
public class ComputerFacade {
      // Internal components (hidden from client)
      private final CPU cpu;
      private final Memory memory;
      private final HardDrive hardDrive;

      // Constructor initializes all components
      public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.hardDrive = new HardDrive();
      }

      // Single simplified method that orchestrates the startup sequence
      public void start() {
            hardDrive.read();
            memory.load();
            cpu.freeze();
            cpu.execute();
      }

}
