package com.ansbeno.behavioral.specification;

public class Product {
      private String name;
      private String category;
      private double price;
      private boolean inStock;

      public Product(String name, String category, double price, boolean inStock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.inStock = inStock;
      }

      public String getName() {
            return name;
      }

      public String getCategory() {
            return category;
      }

      public double getPrice() {
            return price;
      }

      public boolean isInStock() {
            return inStock;
      }
}