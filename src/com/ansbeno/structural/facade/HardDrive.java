package com.ansbeno.structural.facade;

/**
 * FACADE SUBSYSTEM COMPONENT - HardDrive
 * 
 * Part of the complex subsystem hidden behind ComputerFacade.
 * This class handles hard drive operations during system startup.
 */
public class HardDrive {

      // Reads the boot sector from hard drive
      public void read() {
            System.out.println("Hard Drive: Reading boot sector...");
      }
}