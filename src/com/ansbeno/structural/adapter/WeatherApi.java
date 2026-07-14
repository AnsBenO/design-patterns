package com.ansbeno.structural.adapter;

/**
 * ADAPTER PATTERN - Incompatible Class (Third-party API)
 * 
 * This class represents a third-party API with:
 * - Different interface than what our application expects
 * - Different data formats (Fahrenheit instead of Celsius, mph instead of kph)
 * - Singleton implementation (returns same instance)
 * 
 * Note: This uses a lazy-initialization singleton pattern.
 * The WeatherAdapter converts this API's output to our standard format.
 */
public class WeatherApi {

      // Temperature in Fahrenheit (third-party format)
      private int tempF = 0;

      // Weather description
      private String description = "cloudy";

      // Humidity percentage
      private float humidity = 0.0f;

      // Wind speed in miles per hour (third-party format)
      private double windSpeed = 11;

      // Lazy-initialized singleton instance
      private static WeatherApi instance;

      private WeatherApi() {
      }

      // Lazy singleton initialization (if statement check needed)
      public static WeatherApi getInstance() {
            if (instance == null) {
                  instance = new WeatherApi();
            }
            return instance;
      }

      // Returns temperature in Fahrenheit (NOT Celsius)
      public int getTempF() {
            return tempF;
      }

      public String getDescription() {
            return description;
      }

      public float getHumidity() {
            return humidity;
      }

      // Returns wind speed in miles per hour (NOT kilometers per hour)
      public double getWindSpeedMph() {
            return windSpeed;
      }

}
