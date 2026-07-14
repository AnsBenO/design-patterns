package com.ansbeno.behavioral.specification;

public class InStockSpecification implements Specification<Product> {
      public boolean isSatisfiedBy(Product item) {
            return item.isInStock();
      }

}
