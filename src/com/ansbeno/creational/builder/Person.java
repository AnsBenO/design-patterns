package com.ansbeno.creational.builder;

/**
 * BUILDER PATTERN - Product Class
 * 
 * This class represents the complex object being constructed.
 * 
 * Key features:
 * - Constructor accepts a PersonBuilder object (not individual parameters)
 * - Makes fields immutable by only setting them in constructor
 * - Provides getter methods for accessing properties
 * - Factory method builder() returns a new PersonBuilder instance
 * 
 * This pattern is superior to having multiple constructors like:
 * - Person(String name)
 * - Person(String name, int age)
 * - Person(String name, int age, double salary)
 * - etc. (constructor explosion)
 */
public class Person {
      private String name;
      private int age;
      private double salary;
      private boolean isMarried;

      // Constructor takes a builder, not individual parameters
      public Person(PersonBuilder personBuilder) {
            this.name = personBuilder.name;
            this.age = personBuilder.age;
            this.salary = personBuilder.salary;
            this.isMarried = personBuilder.isMarried;
      }

      // Factory method that returns a new builder
      public static PersonBuilder builder() {
            return new PersonBuilder();
      }

      // Getters for immutable properties
      public String getName() {
            return name;
      }

      public int getAge() {
            return age;
      }

      public double getSalary() {
            return salary;
      }

      public boolean isMarried() {
            return isMarried;
      }

}
