package com.ansbeno.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN DEMO
 * 
 * Purpose: Defines a one-to-many dependency between objects so that when
 * one object changes state, all dependent objects are notified automatically.
 * 
 * Key Characteristics:
 * - Subject maintains list of observers
 * - Observers register/unregister with subject
 * - Subject notifies all observers of state changes
 * - Observers react to notifications
 * 
 * Use Cases: Event systems, MVC architecture, message queues, notification
 * systems, data binding
 * 
 * Benefits: Loose coupling, dynamic subscriptions, event-driven programming
 * Drawbacks: Observers notified in unpredictable order, memory leaks if unsubscribe not called
 */
public class ObserverDemo {
    
    public static void main(String[] args) {
        System.out.println("\n========== OBSERVER PATTERN DEMO ==========\n");
        
        System.out.println("Scenario: News Channel (Subject) and Subscribers (Observers)\n");
        
        // Create subscribers
        List<Subscriber> subscribers = new ArrayList<>();
        Subscriber alice = new Subscriber("Alice", null);
        Subscriber bob = new Subscriber("Bob", null);
        Subscriber charlie = new Subscriber("Charlie", null);
        
        subscribers.add(alice);
        subscribers.add(bob);
        subscribers.add(charlie);
        
        System.out.println("Step 1: Create subscribers");
        System.out.println("  - Alice subscribed");
        System.out.println("  - Bob subscribed");
        System.out.println("  - Charlie subscribed");
        
        // Create subject with subscribers
        Subject newsChannel = new Subject(subscribers);
        System.out.println("\nStep 2: Create NewsChannel (Subject)");
        System.out.println("  - NewsChannel has " + subscribers.size() + " subscribers");
        
        // Publish news - all subscribers notified automatically
        System.out.println("\nStep 3: NewsChannel publishes breaking news");
        System.out.println("  → Broadcasting to all subscribers...\n");
        
        newsChannel.notifySubscribers("Breaking News: Design Patterns are Awesome!");
        
        System.out.println("\n\nStep 4: NewsChannel publishes another update");
        System.out.println("  → Broadcasting to all subscribers...\n");
        
        newsChannel.notifySubscribers("Update: Observer pattern enables event-driven systems");
        
        System.out.println("\n\nKey Points:");
        System.out.println("✓ Subject notifies all subscribers automatically");
        System.out.println("✓ Each subscriber receives the update");
        System.out.println("✓ Observers don't need to poll for changes");
        System.out.println("✓ Easy to add/remove subscribers dynamically");
        System.out.println("✓ Loose coupling: Subject doesn't know observer details");
    }
}
