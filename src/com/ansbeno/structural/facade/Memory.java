package com.ansbeno.structural.facade;

/**
 * FACADE SUBSYSTEM COMPONENT - Memory
 * 
 * Part of the complex subsystem hidden behind ComputerFacade.
 * This class handles memory operations during system startup.
 */
public class Memory {

      // Loads data into memory during startup
      public void load() {
            System.out.println("Memory: Loading data...");
      }
}
