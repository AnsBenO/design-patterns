package com.ansbeno.behavioral.specification;

public class CategorySpecification implements Specification<Product> {

      private String category;

      public CategorySpecification(String category) {
            this.category = category;
      }

      @Override
      public boolean isSatisfiedBy(Product item) {
            return item.getCategory().equals(category);
      }

}
