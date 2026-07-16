package com.ansbeno.creational.singleton;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * SINGLETON PATTERN IMPLEMENTATION
 * 
 * This class demonstrates the Singleton design pattern.
 * 
 * Key characteristics:
 * - Private constructor prevents instantiation from outside
 * - Static instance
 * - getInstance() provides global access point
 * - Ensures only ONE instance exists throughout application
 * 
 * Benefits:
 * - Memory efficient (single instance)
 * - Thread-safe global access
 * - Consistent state across application
 * 
 * Use cases: Logger, Database connection, Configuration manager
 */
public class SingletonLogger {

      // Static instance
      private static SingletonLogger instance;

      // Private constructor prevents direct instantiation
      private SingletonLogger() {

      }

      // Static method provides global access to the instance
      public static SingletonLogger getInstance() {
            if (instance == null) {
                  instance = new SingletonLogger();
            }
            return instance;
      }

      // Log info level messages
      public void info(String... arg) {
            System.out.println("[INFO] " + String.join("\n", arg));
      }

      // Log debug level messages
      public void debug(String... args) {
            System.out.println("[DEBUG] " + String.join("\n", args));
      }

      // Log error level messages with exceptions
      public void error(Exception... exceptions) {
            String message = Arrays.stream(exceptions)
                        .map(Exception::getMessage)
                        .collect(Collectors.joining("\n"));

            System.err.println("[ERROR] " + message);

      }
}