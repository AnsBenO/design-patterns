package com.ansbeno.structural.adapter;

/**
 * ADAPTER PATTERN DEMO
 * 
 * Purpose: Converts the interface of a class into another interface that
 * clients expect, allowing incompatible objects to collaborate.
 * 
 * Key Characteristics:
 * - Wraps incompatible object (WeatherApi)
 * - Implements target interface (WeatherApp)
 * - Converts method calls and data formats
 * - Bridges two incompatible interfaces
 * 
 * Use Cases: Legacy code integration, third-party library adaptation,
 * data format conversion
 * 
 * Benefits: Reuse incompatible classes, loose coupling, separation of concerns
 * Drawbacks: Additional classes needed, can hide underlying complexity
 */
public class AdapterDemo {
    
    public static void main(String[] args) {
        System.out.println("\n========== ADAPTER PATTERN DEMO ==========\n");
        
        System.out.println("Problem: Third-party WeatherApi uses incompatible format");
        System.out.println("- Temperature in Fahrenheit (not Celsius)");
        System.out.println("- Wind speed in miles/hour (not kilometers/hour)");
        
        System.out.println("\nSolution: WeatherAdapter converts to our expected format");
        
        // Create adapter that wraps the incompatible API
        WeatherApp weatherApp = new WeatherAdapter();
        
        System.out.println("\nGetting weather data through adapter:");
        System.out.println("Weather: " + weatherApp.getWeather());
        System.out.println("Temperature (°C): " + weatherApp.getTempC() + "°C");
        System.out.println("Humidity: " + weatherApp.getHumidity() + "%");
        System.out.println("Wind Speed (km/h): " + weatherApp.getWindSpeedKph() + " km/h");
        
        System.out.println("\nWhat the adapter did (conversions):");
        System.out.println("✓ Temperature: Converted from Fahrenheit to Celsius");
        System.out.println("   Formula: (°F - 32) × 5/9 = °C");
        
        System.out.println("\n✓ Wind Speed: Converted from mph to km/h");
        System.out.println("   Formula: mph × 1.60934 = km/h");
        
        System.out.println("\nKey Points:");
        System.out.println("✓ Client code uses WeatherApp interface");
        System.out.println("✓ Adapter hides WeatherApi complexity");
        System.out.println("✓ Data format conversions happen transparently");
        System.out.println("✓ Easy to swap implementations without changing client");
    }
}
