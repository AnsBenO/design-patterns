package com.ansbeno.structural.adapter;

/**
 * ADAPTER PATTERN - Target Interface
 * 
 * This is the interface that the client application expects.
 * All methods return data in the format our application needs:
 * - Temperature in Celsius
 * - Wind speed in kilometers per hour
 * 
 * The WeatherAdapter implements this interface by adapting
 * the incompatible WeatherApi to this standard.
 */
public interface WeatherApp {

      // Get weather description
      public String getWeather();

      // Get temperature in Celsius (our standard)
      public int getTempC();

      // Get humidity percentage
      public float getHumidity();

      // Get wind speed in kilometers per hour (our standard)
      public double getWindSpeedKph();
}
