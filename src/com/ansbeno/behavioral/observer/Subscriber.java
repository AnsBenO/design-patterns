package com.ansbeno.behavioral.observer;

/**
 * OBSERVER PATTERN - Observer Class
 * 
 * Concrete observer that receives notifications from the Subject.
 * Each subscriber is an observer that reacts to subject state changes.
 * 
 * Responsibilities:
 * - Maintain reference to the Subject
 * - Implement update() method to receive notifications
 * - React to notifications as needed
 * 
 * Key point: Subscriber doesn't poll the Subject for updates,
 * instead the Subject automatically calls update() when state changes.
 */
public class Subscriber {

      private String name;
      private Subject subject;

      // Constructor with name and subject
      public Subscriber(String name, Subject subject) {
            this.name = name;
            this.subject = subject;
      }

      // Called by Subject when there's new content
      // This is the key method in the Observer pattern
      public void update(String content) {
            System.out.println("Updating " + name + " with " + content);
      }

      // Getters and setters
      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public Subject getSubject() {
            return subject;
      }

      public void setSubject(Subject subject) {
            this.subject = subject;
      }

}
