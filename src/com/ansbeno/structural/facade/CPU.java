package com.ansbeno.structural.facade;

/**
 * FACADE SUBSYSTEM COMPONENT - CPU
 * 
 * Part of the complex subsystem hidden behind ComputerFacade.
 * This class is only used internally by the facade.
 * Clients interact through facade, not directly with CPU.
 */
public class CPU {

      // Freezes the CPU state
      public void freeze() {
            System.out.println("CPU: Freezing...");
      }

      // Executes CPU instructions
      public void execute() {
            System.out.println("CPU: Executing instructions...");
      }
}