package com.ansbeno.behavioral.strategy;

/**
 * STRATEGY PATTERN - Strategy Interface
 * 
 * The Strategy pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary independently
 * from clients that use it.
 * 
 * In this example:
 * - Different transportation modes are different strategies
 * - Each implements the same interface
 * - Client (Commuter) can switch strategies at runtime
 * 
 * Benefits over inheritance:
 * - Avoid creating subclasses for each algorithm (Commuter_Car, Commuter_Bus, etc.)
 * - Strategies are interchangeable
 * - Behavior can be changed dynamically at runtime
 * - Easy to add new strategies without modifying existing code
 * 
 * Real-world examples:
 * - Payment strategies (credit card, PayPal, Bitcoin)
 * - Sorting algorithms (quicksort, mergesort, bubblesort)
 * - Compression strategies (zip, rar, 7z)
 * - Caching strategies (LRU, LFU, FIFO)
 */
public interface TransportStrategy {

      /**
       * Execute the transport action
       */
      public void transport();

}
