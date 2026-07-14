package com.ansbeno;

import com.ansbeno.behavioral.observer.Subject;
import com.ansbeno.behavioral.observer.Subscriber;
import com.ansbeno.behavioral.strategy.BusTransport;
import com.ansbeno.behavioral.strategy.CarTransport;
import com.ansbeno.behavioral.strategy.Commuter;
import com.ansbeno.behavioral.strategy.TransportByFeet;
import com.ansbeno.creational.builder.Person;
import com.ansbeno.creational.factory.Notification;
import com.ansbeno.creational.factory.NotificationFactory;
import com.ansbeno.creational.factory.NotificationType;
import com.ansbeno.creational.singleton.SingletonLogger;
import com.ansbeno.structural.adapter.WeatherAdapter;
import com.ansbeno.structural.adapter.WeatherApp;
import com.ansbeno.structural.facade.ComputerFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns Demo Application
 *
 * This application demonstrates 6 fundamental design patterns:
 * 1. SINGLETON - Creational Pattern
 * 2. BUILDER - Creational Pattern
 * 3. FACTORY - Creational Pattern
 * 4. ADAPTER - Structural Pattern
 * 5. FACADE - Structural Pattern
 * 6. OBSERVER - Behavioral Pattern
 * 7. STRATEGY - Behavioral Pattern
 */
public class App {

    // SINGLETON PATTERN: SingletonLogger ensures only one instance of logger exists
    // throughout the application. This is useful for logging, configuration, etc.
    private static final SingletonLogger log = SingletonLogger.getInstance();

    public static void main(String[] args) {
        log.info("\n========== DESIGN PATTERNS DEMO ==========\n");

        // --- CREATIONAL PATTERNS ---
        demonstrateSingletonPattern();
        demonstrateBuilderPattern();
        demonstrateFactoryPattern();

        // --- STRUCTURAL PATTERNS ---
        demonstrateAdapterPattern();
        demonstrateFacadePattern();

        // --- BEHAVIORAL PATTERNS ---
        demonstrateObserverPattern();
        demonstrateStrategyPattern();

        log.info("\n========== DEMO COMPLETED ==========\n");
    }

    /**
     * SINGLETON PATTERN DEMO
     *
     * Purpose: Ensures that a class has only one instance and provides a global
     * point of access to it.
     *
     * Use Case: SingletonLogger - only one logger instance needed for the entire app
     * Benefit: Memory efficient, consistent state, thread-safe access
     */
    private static void demonstrateSingletonPattern() {
        log.info("\n--- SINGLETON PATTERN ---");
        log.info("Pattern: Singleton");
        log.info("Purpose: Ensure only one instance of a class exists globally");

        // Get the same instance multiple times
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();

        // Both references point to the same object
        log.info("Same instance? " + (logger1 == logger2));
        log.info("Singleton ensures consistent logging across the application");
    }

    /**
     * BUILDER PATTERN DEMO
     *
     * Purpose: Provides a flexible way to construct complex objects step-by-step.
     *
     * Use Case: Person object with multiple optional parameters
     * Benefit: Cleaner API than multiple constructors, clear readability,
     *          flexible parameter setting
     */
    private static void demonstrateBuilderPattern() {
        log.info("\n--- BUILDER PATTERN ---");
        log.info("Pattern: Builder");
        log.info("Purpose: Construct complex objects with a fluent interface");

        // Builder pattern allows step-by-step construction with method chaining
        Person person1 = Person.builder()
                .name("Anas Beno")
                .age(25)
                .salary(75000)
                .isMarried(false)
                .build();

        log.debug("Person 1: " + person1.getName() + ", Age: " + person1.getAge());

        // Builder is flexible - you can set only some properties
        Person person2 = Person.builder()
                .name("Alice Johnson")
                .age(30)
                .isMarried(true)
                .build();

        log.debug("Person 2: " + person2.getName() + ", Salary: " + person2.getSalary());
    }

    /**
     * FACTORY PATTERN DEMO
     *
     * Purpose: Provides an interface for creating objects without specifying
     * their exact classes.
     *
     * Use Case: NotificationFactory creates different notification types
     * Benefit: Decouples client code from concrete classes, centralizes
     *          object creation logic
     */
    private static void demonstrateFactoryPattern() {
        log.info("\n--- FACTORY PATTERN ---");
        log.info("Pattern: Factory");
        log.info("Purpose: Create different objects based on parameters");

        // Factory method creates appropriate notification object
        Notification emailNotification = NotificationFactory.createNotification(NotificationType.EMAIL);
        emailNotification.send("Hello via Email");

        Notification smsNotification = NotificationFactory.createNotification(NotificationType.SMS);
        smsNotification.send("Hello via SMS");

        Notification pushNotification = NotificationFactory.createNotification(NotificationType.PUSH);
        pushNotification.send("Hello via Push");

        log.info("Factory encapsulates object creation logic in one place");
    }

    /**
     * ADAPTER PATTERN DEMO
     *
     * Purpose: Converts the interface of a class into another interface
     * that clients expect.
     *
     * Use Case: WeatherAdapter adapts a third-party API to match our application's
     *           expected interface (converts Fahrenheit to Celsius, mph to kph)
     * Benefit: Integrates incompatible interfaces, promotes loose coupling
     */
    private static void demonstrateAdapterPattern() {
        log.info("\n--- ADAPTER PATTERN ---");
        log.info("Pattern: Adapter");
        log.info("Purpose: Convert incompatible interfaces to work together");

        // WeatherAdapter adapts third-party WeatherApi to WeatherApp interface
        // It converts temperature from Fahrenheit to Celsius and wind speed from mph to kph
        WeatherApp weatherApp = new WeatherAdapter();

        log.debug("Weather: " + weatherApp.getWeather());
        log.debug("Temperature (°C): " + weatherApp.getTempC());
        log.debug("Humidity: " + weatherApp.getHumidity() + "%");
        log.debug("Wind Speed (kph): " + weatherApp.getWindSpeedKph());

        log.info("Adapter allows using third-party code without modification");
    }

    /**
     * FACADE PATTERN DEMO
     *
     * Purpose: Provides a unified, simplified interface to a set of interfaces
     * in a subsystem.
     *
     * Use Case: ComputerFacade hides complex startup sequence of CPU, Memory, HardDrive
     * Benefit: Simplifies client code, hides complexity, promotes loose coupling
     */
    private static void demonstrateFacadePattern() {
        log.info("\n--- FACADE PATTERN ---");
        log.info("Pattern: Facade");
        log.info("Purpose: Simplify complex subsystems with a unified interface");

        // ComputerFacade hides the complexity of starting up multiple components
        // Instead of: hardDrive.read(), memory.load(), cpu.freeze(), cpu.execute()
        // We just call: computer.start()
        ComputerFacade computer = new ComputerFacade();
        log.info("Starting computer...");
        computer.start();

        log.info("Facade abstracts away the complexity of internal components");
    }

    /**
     * OBSERVER PATTERN DEMO
     *
     * Purpose: Defines a one-to-many dependency between objects so that when
     * one object changes state, all dependents are notified automatically.
     *
     * Use Case: Subject notifies multiple Subscribers of content updates
     * Benefit: Loose coupling between subject and observers, dynamic subscriptions
     */
    private static void demonstrateObserverPattern() {
        log.info("\n--- OBSERVER PATTERN ---");
        log.info("Pattern: Observer");
        log.info("Purpose: Notify multiple objects about state changes automatically");

        // Create subscribers
        List<Subscriber> subscribers = new ArrayList<>();
        Subscriber subscriber1 = new Subscriber("Alice", null);
        Subscriber subscriber2 = new Subscriber("Bob", null);
        Subscriber subscriber3 = new Subscriber("Charlie", null);

        subscribers.add(subscriber1);
        subscribers.add(subscriber2);
        subscribers.add(subscriber3);

        // Create subject with subscribers
        Subject newsChannel = new Subject(subscribers);

        log.info("All subscribers registered with news channel");
        log.info("Publishing news to all subscribers...");

        // Notify all observers about new content
        newsChannel.notifySubscribers("Breaking News: Design Patterns are awesome!");

        log.info("Observer pattern enables event-driven architecture");
    }

    /**
     * STRATEGY PATTERN DEMO
     *
     * Purpose: Encapsulates a family of algorithms, makes them interchangeable,
     * and lets the algorithm vary independently from clients that use it.
     *
     * Use Case: Commuter can choose different transportation strategies (car, bus, feet)
     * Benefit: Eliminates conditional statements, promotes flexibility, runtime selection
     */
    private static void demonstrateStrategyPattern() {
        log.info("\n--- STRATEGY PATTERN ---");
        log.info("Pattern: Strategy");
        log.info("Purpose: Select algorithm behavior at runtime");

        Commuter commuter = new Commuter();

        // Strategy 1: Commute by Car
        log.info("\nCommuting by Car:");
        commuter.setTransportStrategy(new CarTransport());
        commuter.commute();

        // Strategy 2: Commute by Bus
        log.info("Commuting by Bus:");
        commuter.setTransportStrategy(new BusTransport());
        commuter.commute();

        // Strategy 3: Commute by Feet
        log.info("Commuting by Feet:");
        commuter.setTransportStrategy(new TransportByFeet());
        commuter.commute();

        log.info("Strategy pattern allows behavior to be selected dynamically");
    }
}
