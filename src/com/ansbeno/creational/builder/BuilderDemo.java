package com.ansbeno.creational.builder;

/**
 * BUILDER PATTERN DEMO
 * 
 * Purpose: Provides a flexible way to construct complex objects step-by-step
 * using method chaining (fluent interface).
 * 
 * Key Characteristics:
 * - Separates object construction from representation
 * - Provides fluent interface with method chaining
 * - Handles optional parameters elegantly
 * - Avoids constructor explosion
 * 
 * Use Cases: Building objects with many optional parameters, UI components,
 * SQL queries, configuration objects
 * 
 * Benefits: Readable code, flexible parameter setting, optional fields
 * Drawbacks: More classes needed, slightly slower instantiation
 */
public class BuilderDemo {
    
    public static void main(String[] args) {
        System.out.println("\n========== BUILDER PATTERN DEMO ==========\n");
        
        // Build a person with all properties
        System.out.println("Creating Person 1 with all properties:");
        Person person1 = Person.builder()
                .name("Alice Johnson")
                .age(28)
                .salary(75000)
                .isMarried(true)
                .build();
        
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Salary: " + person1.getSalary());
        System.out.println("Married: " + person1.isMarried());
        
        // Build a person with only some properties
        System.out.println("\n\nCreating Person 2 with partial properties:");
        Person person2 = Person.builder()
                .name("Bob Smith")
                .age(35)
                .build();
        
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Salary: " + person2.getSalary() + " (default)");
        System.out.println("Married: " + person2.isMarried() + " (default)");
        
        // Build another person with different properties
        System.out.println("\n\nCreating Person 3 with different properties:");
        Person person3 = Person.builder()
                .name("Charlie Brown")
                .salary(95000)
                .isMarried(false)
                .build();
        
        System.out.println("Name: " + person3.getName());
        System.out.println("Age: " + person3.getAge() + " (default)");
        System.out.println("Salary: " + person3.getSalary());
        System.out.println("Married: " + person3.isMarried());
        
        System.out.println("\nKey Points:");
        System.out.println("✓ Fluent interface: method chaining for readability");
        System.out.println("✓ Optional parameters: set only what you need");
        System.out.println("✓ No constructor explosion: no need for multiple overloads");
        System.out.println("✓ Immutable objects: properties set only once");
    }
}
