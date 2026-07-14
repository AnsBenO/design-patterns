package com.ansbeno.creational.builder;

/**
 * BUILDER PATTERN - Builder Class
 * 
 * This class implements the builder part of the Builder design pattern.
 * 
 * Responsibilities:
 * - Holds the parameters for object construction
 * - Provides setter methods that return 'this' for method chaining
 * - build() method creates and returns the final Person object
 * 
 * Benefits:
 * - Fluent interface (readable method chaining)
 * - Optional parameters easy to handle
 * - Separates construction from representation
 * - Cleaner than multiple constructors
 * 
 * Example usage:
 * Person p = Person.builder()
 *     .name("John")
 *     .age(30)
 *     .salary(50000)
 *     .build();
 */
public class PersonBuilder {
      String name;
      int age;
      double salary;
      boolean isMarried;

      // Each setter returns 'this' to enable method chaining
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

      // build() creates the actual Person object
      public Person build() {
            return new Person(this);
      }
}