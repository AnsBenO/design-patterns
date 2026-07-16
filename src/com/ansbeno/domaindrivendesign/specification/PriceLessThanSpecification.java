package com.ansbeno.domaindrivendesign.specification;

public class PriceLessThanSpecification implements Specification<Product> {
      private double price;

      public PriceLessThanSpecification(double price) {
            this.price = price;
      }

      public boolean isSatisfiedBy(Product item) {
            return item.getPrice() < price;
      }
}
