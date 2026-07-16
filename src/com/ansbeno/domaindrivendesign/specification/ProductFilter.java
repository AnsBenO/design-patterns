package com.ansbeno.domaindrivendesign.specification;

import java.util.List;

public class ProductFilter {
      public static List<Product> filter(List<Product> products, Specification<Product> spec) {
            return products.stream()
                        .filter(spec::isSatisfiedBy) // (item) -> spec.isSatisfiedBy(item)
                        .toList();
      }
}
