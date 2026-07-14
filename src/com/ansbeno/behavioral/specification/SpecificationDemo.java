package com.ansbeno.behavioral.specification;

import java.util.List;

import com.ansbeno.creational.singleton.SingletonLogger;

public class SpecificationDemo {

      private static final SingletonLogger log = SingletonLogger.getInstance();

      public static void main(String[] args) {
            // Sample products
            List<Product> products = List.of(
                        new Product("Laptop", "Electronics", 1200, true),
                        new Product("Phone", "Electronics", 800, false),
                        new Product("TV", "Electronics", 600, true),
                        new Product("Desk", "Furniture", 250, true),
                        new Product("Chair", "Furniture", 100, false));
            // Sample specifications
            Specification<Product> inStock = new InStockSpecification();
            Specification<Product> cheap = new PriceLessThanSpecification(500);
            Specification<Product> electronics = new CategorySpecification("Electronics");

            List<Product> filteredProducts = ProductFilter.filter(products, inStock.and(electronics.or(cheap)));
            filteredProducts.forEach(p -> log.info(p.getName()));

      }

}
