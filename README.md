# Design Patterns Guide

A comprehensive guide to understanding 7 essential design patterns with real code examples.

---

## What Are Design Patterns?

### Definition

**Design patterns are reusable solutions to common problems in software design.** They are proven, tested approaches to solving recurring design problems that make your code more maintainable, scalable, and easier to understand.

A design pattern is like a **blueprint or template** for solving a problem. Just as architects use architectural patterns to design buildings, software developers use design patterns to design robust applications.

### Origin

Design patterns were popularized by the "Gang of Four" (GoF) - four computer scientists (Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides) who published "Design Patterns: Elements of Reusable Object-Oriented Software" in 1994. This book documented 23 classical design patterns organized into three categories.

### Why Use Design Patterns?

1. **Communication** - Developers understand design decisions quickly
2. **Code Reusability** - Proven solutions can be applied to similar problems
3. **Maintainability** - Well-structured code is easier to modify
4. **Scalability** - Patterns help manage complexity as systems grow
5. **Best Practices** - Encapsulate industry wisdom and experience
6. **Avoid Reinventing the Wheel** - Don't solve the same problem twice

### Problem → Solution → Implementation

Every design pattern follows this structure:

```
┌─────────────────────────────────────────────────────────┐
│ 1. PROBLEM                                              │
│    What recurring issue are we trying to solve?         │
├─────────────────────────────────────────────────────────┤
│ 2. CONTEXT                                              │
│    When and where does this problem occur?              │
├─────────────────────────────────────────────────────────┤
│ 3. SOLUTION                                             │
│    What is the proven approach to solve it?             │
├─────────────────────────────────────────────────────────┤
│ 4. CONSEQUENCES                                         │
│    What are the trade-offs (pros & cons)?               │
├─────────────────────────────────────────────────────────┤
│ 5. IMPLEMENTATION                                       │
│    How do we code this solution?                        │
└─────────────────────────────────────────────────────────┘
```

### Three Categories of Design Patterns

#### 1. **Creational Patterns** - Object Creation

Focus on **how objects are created**. They abstract the instantiation process to make systems independent of how objects are composed.

**Goal:** Create objects in a flexible, reusable way.

**Patterns:**

- Singleton - Ensure only one instance exists
- Builder - Construct complex objects step-by-step
- Factory - Create objects without specifying concrete classes

#### 2. **Structural Patterns** - Object Composition

Focus on **how objects are combined** to form larger structures while keeping these structures flexible and efficient.

**Goal:** Create efficient relationships between objects.

**Patterns:**

- Adapter - Make incompatible interfaces compatible
- Facade - Provide simplified interface to complex subsystem

#### 3. **Behavioral Patterns** - Object Interaction

Focus on **how objects interact** and how responsibilities are distributed among them. They increase flexibility in communication.

**Goal:** Define how objects communicate and collaborate.

**Patterns:**

- Observer - Notify multiple objects about state changes
- Strategy - Encapsulate interchangeable algorithms

### Real-World Analogy

Think of design patterns like **cooking recipes**:

- **Problem:** You want to make a delicious cake
- **Solution:** Use a cake recipe (the pattern)
- **Pattern Benefits:**
    - You don't reinvent the recipe each time
    - Others can follow the same recipe and get consistent results
    - You can modify the recipe slightly for variations
    - New cooks can learn from established recipes

Similarly, in software:

- **Problem:** You need to ensure only one logger exists
- **Solution:** Use Singleton pattern
- **Pattern Benefits:**
    - Other developers recognize it immediately
    - You don't reinvent the solution
    - Code is consistent across projects
    - Maintenance is easier

### When Should You Use Design Patterns?

✓ **DO use patterns when:**

- You identify a recurring problem
- The pattern solves a real problem in your codebase
- The pattern's benefits outweigh added complexity
- Your team understands the pattern
- Multiple developers will work on the code

✗ **DON'T use patterns when:**

- It's the first time solving the problem (understand it first)
- The simple solution is sufficient
- It over-complicates a simple requirement
- You're forcing a pattern where it doesn't fit
- The performance overhead is significant

### Pattern Notation

Each pattern in this guide is described with:

| Element                 | Description                           |
| ----------------------- | ------------------------------------- |
| **What is it?**         | Simple explanation of the pattern     |
| **When to use it?**     | Scenarios where this pattern applies  |
| **Problem it solves**   | The specific problem addressed        |
| **Code Example**        | Real implementation from this project |
| **Usage**               | How to use the pattern                |
| **Key Characteristics** | Important features of the pattern     |
| **Pros & Cons**         | Trade-offs to consider                |

### Principle: Don't Over-Engineer

> "Simplicity is the ultimate sophistication." - Leonardo da Vinci

The most important principle when using design patterns is **avoiding over-engineering**.

- Start with simple code
- Add patterns when complexity becomes apparent
- Use patterns to solve real problems, not hypothetical ones
- Don't use a pattern just because you know it

A good architect builds complexity incrementally as needed, not all at once.

---

## Table of Contents

1. [Creational Patterns](#creational-patterns)
    - [Singleton](#singleton)
    - [Builder](#builder)
    - [Factory](#factory)
2. [Structural Patterns](#structural-patterns)
    - [Adapter](#adapter)
    - [Facade](#facade)
3. [Behavioral Patterns](#behavioral-patterns)
    - [Observer](#observer)
    - [Strategy](#strategy)
    - [Specification](#specification)

---

# Creational Patterns

Creational patterns deal with object creation mechanisms. They aim to create objects in a manner suitable to the situation.

---

## Singleton

### What is it?

The Singleton pattern ensures that a class has **only one instance** and provides a global point of access to it.

### When to use it?

- **Loggers** - One logging system for the entire application
- **Database connections** - Single connection pool
- **Configuration managers** - One set of configurations
- **Thread pools** - Single shared executor

### Problem it solves

Without Singleton, you might accidentally create multiple instances of expensive resources, wasting memory and creating inconsistent state.

### Code Example

```java
public class SingletonLogger {
    // Static instance created once at class loading
    private static final SingletonLogger instance = new SingletonLogger();

    // Private constructor prevents instantiation from outside
    private SingletonLogger() {
    }

    // Global access point
    public static SingletonLogger getInstance() {
        return instance;
    }

    public void info(String... arg) {
        System.out.println("[INFO] " + String.join("\n", arg));
    }
}
```

### Usage

```java
// Get the logger multiple times
SingletonLogger logger1 = SingletonLogger.getInstance();
SingletonLogger logger2 = SingletonLogger.getInstance();
SingletonLogger logger3 = SingletonLogger.getInstance();

// All refer to the SAME object
boolean sameInstance = (logger1 == logger2); // true
```

### Key Characteristics

- ✓ **Private constructor** - prevents direct instantiation
- ✓ **Static instance** - created once when class loads
- ✓ **getInstance()** - global access method
- ✓ **Thread-safe** - in this eager initialization approach

### Pros & Cons

| Pros                     | Cons                              |
| ------------------------ | --------------------------------- |
| Memory efficient         | Hides dependencies                |
| Global access            | Hard to unit test                 |
| Consistent state         | Can violate Single Responsibility |
| Thread-safe (eager init) | Difficult to subclass             |

---

## Builder

### What is it?

The Builder pattern provides a **flexible way to construct complex objects** step-by-step using method chaining (fluent interface).

### When to use it?

- Objects with **many optional parameters**
- Need for **readable construction** code
- Want to avoid **constructor explosion** (too many overloads)
- Need **immutable objects**

### Problem it solves

Without Builder, you end up with multiple constructors:

```java
// Without Builder - Constructor Explosion
Person(String name) { }
Person(String name, int age) { }
Person(String name, int age, double salary) { }
Person(String name, int age, double salary, boolean isMarried) { }
// ... and many more combinations
```

With Builder, you have one clean interface:

```java
Person p = Person.builder()
    .name("Alice")
    .age(28)
    .salary(75000)
    .isMarried(true)
    .build();
```

### Code Example

**The Builder Class:**

```java
public class PersonBuilder {
    String name;
    int age;
    double salary;
    boolean isMarried;

    // Each setter returns 'this' for method chaining
    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder salary(double salary) {
        this.salary = salary;
        return this;
    }

    public PersonBuilder isMarried(boolean isMarried) {
        this.isMarried = isMarried;
        return this;
    }

    // build() creates the actual object
    public Person build() {
        return new Person(this);
    }
}
```

**The Person Class:**

```java
public class Person {
    private String name;
    private int age;
    private double salary;
    private boolean isMarried;

    // Constructor takes a builder
    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
        this.isMarried = builder.isMarried;
    }

    // Builder method returns a new builder
    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public boolean isMarried() { return isMarried; }
}
```

### Usage

```java
// Build with all parameters
Person person1 = Person.builder()
    .name("Alice Johnson")
    .age(28)
    .salary(75000)
    .isMarried(true)
    .build();

// Build with only some parameters (others use default)
Person person2 = Person.builder()
    .name("Bob Smith")
    .age(35)
    .build();
```

### Key Characteristics

- ✓ **Method chaining** - fluent interface
- ✓ **Optional parameters** - set only what you need
- ✓ **Immutability** - once built, can't change
- ✓ **Readability** - clear what each value means

### Pros & Cons

| Pros                     | Cons                        |
| ------------------------ | --------------------------- |
| Readable code            | More classes needed         |
| Flexible parameters      | Slightly slower             |
| No constructor explosion | More complex setup          |
| Immutable objects        | Overhead for simple objects |

---

## Factory

### What is it?

The Factory pattern provides an **interface for creating objects** without specifying their exact concrete classes. It encapsulates object creation logic.

### When to use it?

- Creating objects from a **family of related classes**
- Want to **decouple client code** from concrete classes
- Need **flexible object creation** based on parameters
- Adding new types frequently

### Problem it solves

Without Factory, client code is tightly coupled to concrete classes:

```java
// Without Factory - Tight Coupling
if (type == EMAIL) {
    Notification notif = new EmailNotification();
} else if (type == SMS) {
    Notification notif = new SmsNotification();
} else if (type == PUSH) {
    Notification notif = new PushNotification();
}
```

With Factory, creation is centralized:

```java
// With Factory - Loose Coupling
Notification notif = NotificationFactory.createNotification(type);
```

### Code Example

**The Interface:**

```java
public interface Notification {
    void send(String message);
}
```

**Concrete Implementations:**

```java
public class EmailNotification implements Notification {
    private static SingletonLogger log = SingletonLogger.getInstance();

    @Override
    public void send(String message) {
        log.info("Sending email: " + message);
    }
}

public class SmsNotification implements Notification {
    private static SingletonLogger log = SingletonLogger.getInstance();

    @Override
    public void send(String message) {
        log.info("Sending SMS: " + message);
    }
}

public class PushNotification implements Notification {
    private static SingletonLogger log = SingletonLogger.getInstance();

    @Override
    public void send(String message) {
        log.info("Sending push notification: " + message);
    }
}
```

**The Factory:**

```java
public class NotificationFactory {
    public static Notification createNotification(NotificationType type) {
        switch (type) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SmsNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
```

### Usage

```java
// Client code - doesn't know about concrete classes
Notification emailNotif = NotificationFactory.createNotification(NotificationType.EMAIL);
emailNotif.send("Hello via Email");

Notification smsNotif = NotificationFactory.createNotification(NotificationType.SMS);
smsNotif.send("Hello via SMS");

Notification pushNotif = NotificationFactory.createNotification(NotificationType.PUSH);
pushNotif.send("Hello via Push");
```

### Key Characteristics

- ✓ **Centralized creation** - all logic in one place
- ✓ **Polymorphism** - treat all objects the same way
- ✓ **Encapsulation** - hides concrete classes
- ✓ **Easy to extend** - add new types without changing client code

### Pros & Cons

| Pros                 | Cons                         |
| -------------------- | ---------------------------- |
| Loose coupling       | More classes                 |
| Easy to add types    | Can be over-engineered       |
| Centralized logic    | Less useful for simple cases |
| Polymorphic behavior | Hidden dependencies          |

---

# Structural Patterns

Structural patterns deal with object composition, creating relationships between objects to form larger structures.

---

## Adapter

### What is it?

The Adapter pattern **converts the interface of a class** into another interface that clients expect, allowing incompatible objects to work together.

### When to use it?

- Integrating **third-party libraries** with incompatible interfaces
- Working with **legacy code**
- **Data format conversion** needed
- Different systems need to communicate

### Problem it solves

You have a third-party API that returns data in an incompatible format:

- Temperature in **Fahrenheit** (you need Celsius)
- Wind speed in **mph** (you need km/h)

Instead of modifying the third-party code or your entire application, use an Adapter!

### Code Example

**The Incompatible Class (Third-party API):**

```java
public class WeatherApi {
    // Returns temperature in Fahrenheit (NOT Celsius)
    public int getTempF() {
        return 72; // 72°F
    }

    // Returns wind speed in miles per hour (NOT km/h)
    public double getWindSpeedMph() {
        return 10; // 10 mph
    }

    public String getDescription() {
        return "cloudy";
    }

    public float getHumidity() {
        return 65.0f;
    }
}
```

**The Target Interface (What we want):**

```java
public interface WeatherApp {
    String getWeather();
    int getTempC();              // Wants Celsius
    float getHumidity();
    double getWindSpeedKph();    // Wants km/h
}
```

**The Adapter (Bridges the gap):**

```java
public class WeatherAdapter implements WeatherApp {
    private final WeatherApi weatherApi = WeatherApi.getInstance();

    @Override
    public String getWeather() {
        return weatherApi.getDescription();
    }

    // Convert Fahrenheit to Celsius
    @Override
    public int getTempC() {
        return (weatherApi.getTempF() - 32) * 5 / 9;
    }

    @Override
    public float getHumidity() {
        return weatherApi.getHumidity();
    }

    // Convert mph to km/h
    @Override
    public double getWindSpeedKph() {
        return weatherApi.getWindSpeedMph() * 1.60934;
    }
}
```

### Usage

```java
// Client only knows about the adapter
WeatherApp weather = new WeatherAdapter();

System.out.println("Temperature: " + weather.getTempC() + "°C");    // 22°C
System.out.println("Wind: " + weather.getWindSpeedKph() + " km/h"); // 16 km/h

// The adapter handles all conversions transparently!
```

### Key Characteristics

- ✓ **Wraps incompatible object** - WeatherApi wrapped by adapter
- ✓ **Implements target interface** - implements WeatherApp
- ✓ **Converts methods & data** - Fahrenheit to Celsius, mph to km/h
- ✓ **Transparent to client** - client doesn't know about conversions

### Pros & Cons

| Pros                       | Cons                 |
| -------------------------- | -------------------- |
| Reuse incompatible classes | Additional classes   |
| Loose coupling             | Can hide complexity  |
| Separation of concerns     | Performance overhead |
| Client code unchanged      | Extra method calls   |

---

## Facade

### What is it?

The Facade pattern provides a **unified, simplified interface** to a complex subsystem of classes, making it easier to use.

### When to use it?

- **Complex subsystems** with many classes
- Want to **hide complexity** from clients
- **Simplify APIs** for library users
- **Orchestrate multiple components**

### Problem it solves

A computer startup involves many complex steps. Without Facade:

```java
// Without Facade - Complex and Error-prone
hardDrive.read();
memory.load();
cpu.freeze();
cpu.execute();

// What if order is wrong?
// What if we forget a step?
// Clients must know the correct sequence
```

With Facade:

```java
// With Facade - Simple
computer.start();
// Facade handles all the complexity
```

### Code Example

**The Subsystem Components (Hidden from client):**

```java
public class HardDrive {
    public void read() {
        System.out.println("Hard Drive: Reading boot sector...");
    }
}

public class Memory {
    public void load() {
        System.out.println("Memory: Loading data...");
    }
}

public class CPU {
    public void freeze() {
        System.out.println("CPU: Freezing...");
    }

    public void execute() {
        System.out.println("CPU: Executing instructions...");
    }
}
```

**The Facade (Simplifies the subsystem):**

```java
public class ComputerFacade {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // Single method that orchestrates complex startup
    public void start() {
        hardDrive.read();    // Step 1
        memory.load();       // Step 2
        cpu.freeze();        // Step 3
        cpu.execute();       // Step 4
    }
}
```

### Usage

```java
// Client only interacts with facade
ComputerFacade computer = new ComputerFacade();
computer.start();

// Output:
// Hard Drive: Reading boot sector...
// Memory: Loading data...
// CPU: Freezing...
// CPU: Executing instructions...

// Client doesn't need to know about CPU, Memory, HardDrive!
```

### Key Characteristics

- ✓ **Hides subsystem components** - client doesn't see them
- ✓ **Single entry point** - one method to use system
- ✓ **Orchestrates interactions** - knows correct sequence
- ✓ **Easy to change internally** - client code unchanged

### Pros & Cons

| Pros                       | Cons                       |
| -------------------------- | -------------------------- |
| Simplifies complex systems | Can become "god object"    |
| Loose coupling             | May hide important details |
| Easier to understand       | Adds abstraction layer     |
| Client code simpler        | Potential performance cost |

---

# Behavioral Patterns

Behavioral patterns are concerned with object collaboration and the delegation of responsibilities between objects.

---

## Observer

### What is it?

The Observer pattern defines a **one-to-many dependency** between objects so that when one object changes state, all dependent objects are notified automatically.

### When to use it?

- **Event systems** - many handlers for one event
- **MVC architecture** - model notifies views of changes
- **Message queues** - subscribers listen for messages
- **Data binding** - UI updates when data changes

### Problem it solves

Without Observer, polling is needed:

```java
// Without Observer - Polling (Bad)
while (true) {
    if (newsChannel.hasNewContent()) {
        String news = newsChannel.getContent();
        subscriber.update(news);
    }
    Thread.sleep(1000);
}
```

With Observer, automatic notifications:

```java
// With Observer - Event-driven (Good)
newsChannel.notifySubscribers("Breaking news!");
// All subscribers automatically notified
```

### Code Example

**The Subject (Publisher):**

```java
public class Subject {
    private List<Subscriber> subscribers;

    public Subject(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    // Notify all subscribers
    public void notifySubscribers(String content) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(content);
        }
    }

    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unregisterSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
```

**The Observer (Subscriber):**

```java
public class Subscriber {
    private String name;
    private Subject subject;

    public Subscriber(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    // Called when subject notifies
    public void update(String content) {
        System.out.println("Updating " + name + " with " + content);
    }
}
```

### Usage

```java
// Create subscribers
List<Subscriber> subscribers = new ArrayList<>();
Subscriber alice = new Subscriber("Alice", null);
Subscriber bob = new Subscriber("Bob", null);

subscribers.add(alice);
subscribers.add(bob);

// Create subject
Subject newsChannel = new Subject(subscribers);

// Publish news - all subscribers notified automatically!
newsChannel.notifySubscribers("Breaking News: Design Patterns are Awesome!");

// Output:
// Updating Alice with Breaking News: Design Patterns are Awesome!
// Updating Bob with Breaking News: Design Patterns are Awesome!
```

### Key Characteristics

- ✓ **One-to-many relationship** - subject → multiple observers
- ✓ **Automatic notification** - no polling needed
- ✓ **Loose coupling** - subject doesn't know observer details
- ✓ **Dynamic subscriptions** - can add/remove at runtime

### Pros & Cons

| Pros                  | Cons                                   |
| --------------------- | -------------------------------------- |
| Event-driven          | Unpredictable notification order       |
| Loose coupling        | Memory leaks if unsubscribe not called |
| Dynamic subscriptions | Hidden dependencies                    |
| Easy to add observers | Difficult to debug                     |

---

## Strategy

### What is it?

The Strategy pattern **encapsulates a family of algorithms**, makes them interchangeable, and lets the algorithm vary independently from clients that use it.

### When to use it?

- **Different algorithms** for same task
- Want to **avoid conditional statements** (if-else, switch)
- Need **runtime flexibility** to change behavior
- Algorithms might change frequently

### Problem it solves

Without Strategy, you get messy conditional logic:

```java
// Without Strategy - Messy
if (transportType == CAR) {
    car.drive();
} else if (transportType == BUS) {
    bus.ride();
} else if (transportType == FEET) {
    walk.go();
}
// Adding new type requires modifying this code!
```

With Strategy, clean and extensible:

```java
// With Strategy - Clean
commuter.setTransportStrategy(new CarTransport());
commuter.commute();

commuter.setTransportStrategy(new BusTransport());
commuter.commute();

// Adding new strategy: just create new class, no changes needed!
```

### Code Example

**The Strategy Interface:**

```java
public interface TransportStrategy {
    void transport();
}
```

**Concrete Strategies:**

```java
public class CarTransport implements TransportStrategy {
    private static final SingletonLogger log = SingletonLogger.getInstance();

    @Override
    public void transport() {
        log.info("Transporting by car...");
    }
}

public class BusTransport implements TransportStrategy {
    private static final SingletonLogger log = SingletonLogger.getInstance();

    @Override
    public void transport() {
        log.info("Transporting by bus...");
    }
}

public class TransportByFeet implements TransportStrategy {
    @Override
    public void transport() {
        System.out.println("Transporting by feet...");
    }
}
```

**The Context (Uses strategies):**

```java
public class Commuter {
    private TransportStrategy transportStrategy;

    public void commute() {
        transportStrategy.transport();
    }

    public void setTransportStrategy(TransportStrategy strategy) {
        this.transportStrategy = strategy;
    }
}
```

### Usage

```java
Commuter commuter = new Commuter();

// Strategy 1: By Car
commuter.setTransportStrategy(new CarTransport());
commuter.commute();  // Output: Transporting by car...

// Strategy 2: By Bus (no code change needed!)
commuter.setTransportStrategy(new BusTransport());
commuter.commute();  // Output: Transporting by bus...

// Strategy 3: By Feet (just add new class, no modifications!)
commuter.setTransportStrategy(new TransportByFeet());
commuter.commute();  // Output: Transporting by feet...

// Switch back to car in rainy weather
commuter.setTransportStrategy(new CarTransport());
commuter.commute();  // Output: Transporting by car...
```

### Key Characteristics

- ✓ **Family of algorithms** - Car, Bus, Feet transport
- ✓ **Interchangeable** - can switch at runtime
- ✓ **Encapsulated** - each algorithm in own class
- ✓ **Open/Closed Principle** - open for extension, closed for modification

### Pros & Cons

| Pros                   | Cons                      |
| ---------------------- | ------------------------- |
| Runtime flexibility    | More classes              |
| No conditionals        | Slight overhead           |
| Easy to add algorithms | Overkill for simple cases |
| Follows Open/Closed    | More complex initially    |

---

## Specification

### What is it?

The Specification pattern is a behavioral pattern that encapsulates a **business rule or requirement into a reusable object**. Instead of embedding complex filtering logic directly into your code, you create specifications that can be combined, composed, and reused.

A specification is essentially a **predicate** - it answers the question "Does this object meet my criteria?" and returns true or false.

### When to use it?

- **Complex filtering logic** - Finding products by multiple criteria
- **Reusable business rules** - Rules used in multiple places
- **Composable conditions** - Need to combine conditions with AND, OR, NOT
- **Query builders** - Building complex queries dynamically
- **Validation rules** - Validating objects against business rules
- **Report generation** - Filtering data for different reports

### Problem it solves

Without Specification, you end up with:

1. **Scattered logic** - Filter conditions spread throughout the codebase
2. **Rigid filters** - Hard to combine or modify filter criteria
3. **Duplicate code** - Same business rules repeated in multiple places
4. **Tight coupling** - Filtering logic mixed with domain objects
5. **Difficult testing** - Complex filter conditions hard to unit test

### Code Example

The core of the Specification pattern is a simple interface:

```java
public interface Specification<T> {
    boolean isSatisfiedBy(T item);

    default Specification<T> and(Specification<T> other) {
        return item -> this.isSatisfiedBy(item) && other.isSatisfiedBy(item);
    }

    default Specification<T> or(Specification<T> other) {
        return item -> this.isSatisfiedBy(item) || other.isSatisfiedBy(item);
    }

    default Specification<T> not() {
        return item -> !this.isSatisfiedBy(item);
    }
}
```

Then you create concrete specifications for specific business rules:

```java
// Specification 1: Items that are in stock
public class InStockSpecification implements Specification<Product> {
    public boolean isSatisfiedBy(Product item) {
        return item.isInStock();
    }
}

// Specification 2: Items priced under a certain amount
public class PriceLessThanSpecification implements Specification<Product> {
    private double price;

    public PriceLessThanSpecification(double price) {
        this.price = price;
    }

    public boolean isSatisfiedBy(Product item) {
        return item.getPrice() < price;
    }
}

// Specification 3: Items in a specific category
public class CategorySpecification implements Specification<Product> {
    private String category;

    public CategorySpecification(String category) {
        this.category = category;
    }

    public boolean isSatisfiedBy(Product item) {
        return item.getCategory().equals(category);
    }
}
```

### Usage

The real power comes from **composing specifications** together:

```java
// Create individual specifications
Specification<Product> inStock = new InStockSpecification();
Specification<Product> cheap = new PriceLessThanSpecification(500);
Specification<Product> electronics = new CategorySpecification("Electronics");

// Compose them with logical operators
// Find: (In-stock AND Electronics) OR (Cheap items)
Specification<Product> complexSpec = inStock.and(electronics).or(cheap);

// Apply the specification
List<Product> filteredProducts = ProductFilter.filter(products, complexSpec);
```

The filter is simple:

```java
public class ProductFilter {
    public static List<Product> filter(List<Product> products,
                                       Specification<Product> spec) {
        return products.stream()
            .filter(spec::isSatisfiedBy)
            .toList();
    }
}
```

### Key Characteristics

- ✓ **Reusable rules** - Specifications are independent and reusable
- ✓ **Composable** - Combine with `and()`, `or()`, `not()`
- ✓ **Generic** - `Specification<T>` works with any type
- ✓ **Readable** - Clear intent of what criteria are being checked
- ✓ **Testable** - Each specification can be unit tested independently
- ✓ **Loose coupling** - Domain objects don't know about filtering

### Pros & Cons

| Pros                          | Cons                                                 |
| ----------------------------- | ---------------------------------------------------- |
| Reusable business rules       | More classes (one per rule)                          |
| Composable and flexible       | Small overhead from objects                          |
| Easy to test independently    | Overkill for simple filters                          |
| Separates concerns            | Functional approach may be simpler for trivial cases |
| Clear, readable code          | Learning curve for new developers                    |
| Follows Single Responsibility | Extra abstraction layers                             |

### When NOT to use it

- **Simple one-off filters** - Use lambdas or simple methods
- **SQL queries** - Use database queries directly
- **Rarely changing rules** - Simpler approaches may suffice
- **Performance-critical paths** - Objects add overhead vs. direct comparisons

---

## Summary Table

| Pattern           | Category   | Purpose                           | Key Benefit          |
| ----------------- | ---------- | --------------------------------- | -------------------- |
| **Singleton**     | Creational | One instance globally             | Memory efficient     |
| **Builder**       | Creational | Flexible object construction      | Clean, readable code |
| **Factory**       | Creational | Hide concrete classes             | Loose coupling       |
| **Adapter**       | Structural | Make incompatible interfaces work | Reuse existing code  |
| **Facade**        | Structural | Simplify complex subsystems       | Easy to use APIs     |
| **Observer**      | Behavioral | One-to-many notifications         | Event-driven systems |
| **Strategy**      | Behavioral | Runtime algorithm selection       | No conditionals      |
| **Specification** | Behavioral | Encapsulate business rules        | Reusable conditions  |

---

## When to Use What?

### Need to create objects?

- **Singleton** - Only one needed
- **Builder** - Complex with many options
- **Factory** - Different types from a family

### Need to work with objects?

- **Adapter** - Incompatible interfaces
- **Facade** - Complex subsystems
- **Observer** - Automatic notifications
- **Strategy** - Different algorithms
- **Specification** - Complex filtering or business rules

---

## Key Principles

1. **Loose Coupling** - Objects depend on abstractions, not concrete classes
2. **High Cohesion** - Each class has single responsibility
3. **Open/Closed** - Open for extension, closed for modification
4. **Dependency Inversion** - Depend on abstractions, not implementations
5. **Interface Segregation** - Specific interfaces, not general ones

---

## Best Practices

- ✓ Use patterns to **solve real problems**, not just because they exist
- ✓ Start **simple**, add patterns when complexity appears
- ✓ Understand the **problem** before choosing a pattern
- ✓ Don't **over-engineer** for simple cases
- ✓ **Combine patterns** when appropriate (e.g., Factory + Singleton)
- ✓ **Document** why you chose a particular pattern
