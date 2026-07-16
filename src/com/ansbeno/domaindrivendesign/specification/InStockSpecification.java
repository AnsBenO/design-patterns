package com.ansbeno.domaindrivendesign.specification;

public class InStockSpecification implements Specification<Product> {
      public boolean isSatisfiedBy(Product item) {
            return item.isInStock();
      }

}
