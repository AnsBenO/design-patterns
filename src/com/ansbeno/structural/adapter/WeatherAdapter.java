package com.ansbeno.structural.adapter;

/**
 * ADAPTER PATTERN - Adapter Class
 * 
 * The Adapter pattern converts the interface of a class into another interface
 * that clients expect, allowing incompatible objects to collaborate.
 * 
 * In this example:
 * - WeatherApi is a third-party API (incompatible interface)
 * - WeatherApp is the interface our application expects
 * - WeatherAdapter bridges the two by:
 *   1. Implementing the target interface (WeatherApp)
 *   2. Wrapping the incompatible object (WeatherApi)
 *   3. Converting method calls and data formats
 * 
 * Conversions performed:
 * - Fahrenheit → Celsius
 * - Miles per hour → Kilometers per hour
 * 
 * Benefits:
 * - Integrate third-party code without modification
 * - Application code depends on WeatherApp, not WeatherApi
 * - Easy to swap implementations if needed
 * - Promotes loose coupling
 * 
 * This pattern is useful when:
 * - Working with legacy code
 * - Integrating external libraries
 * - Standardizing different data formats
 */
public class WeatherAdapter implements WeatherApp {

      // The incompatible object being adapted
      private final WeatherApi weatherApi = WeatherApi.getInstance();

      @Override
      public String getWeather() {
            return this.weatherApi.getDescription();
      }

      // Adapter converts Fahrenheit to Celsius
      @Override
      public int getTempC() {
            return (this.weatherApi.getTempF() - 32) * 5 / 9;
      }

      @Override
      public float getHumidity() {
            return this.weatherApi.getHumidity();
      }

      // Adapter converts miles per hour to kilometers per hour
      @Override
      public double getWindSpeedKph() {
            return this.weatherApi.getWindSpeedMph() * 1.60934;
      }

}
