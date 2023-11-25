package mypackage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductManagement {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 1000, 5),
                new Product(2, "Headphones", "Electronics", 150, 10),
                new Product(3, "Desk", "Furniture", 200, 3)
        );

        // Filtering by Category and Quantity
        String desiredCategory = "Electronics";
        int quantityThreshold = 6;
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals(desiredCategory) && product.getQuantity() < quantityThreshold)
                .collect(Collectors.toList());

        // Statistics: Summary statistics for each category
        Map<String, DoubleSummaryStatistics> categoryStatistics = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summarizingDouble(Product::getPrice)));

        // Conversion: Convert list of products to a map with ID as key and name as value
        Map<Integer, String> idToNameMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Product::getName));

        // Custom Sorting based on price-to-quantity ratio
        List<Product> sortedProductsByRatio = products.stream()
                .sorted(Comparator.comparingDouble(product -> product.getPrice() / product.getQuantity()))
                .collect(Collectors.toList());

        // Displaying results
        System.out.println("Filtered Products in category " + desiredCategory + " with quantity below " + quantityThreshold + ":");
        filteredProducts.forEach(product -> System.out.println(product.getId() + ": " + product.getName()));

        System.out.println("\nStatistics for each category:");
        categoryStatistics.forEach((category, stats) ->
                System.out.println(category + ": Average Price - " + stats.getAverage() + ", Total Quantity - " + stats.getSum()));

        System.out.println("\nConversion: Map of ID to Name:");
        idToNameMap.forEach((id, name) -> System.out.println(id + ": " + name));

        System.out.println("\nSorted Products based on price-to-quantity ratio:");
        sortedProductsByRatio.forEach(product -> System.out.println(product.getId() + ": " + product.getName()
                + " - Price: " + product.getPrice() + ", Quantity: " + product.getQuantity()
                + ", Ratio: " + (product.getPrice() / product.getQuantity())));
    }
}
