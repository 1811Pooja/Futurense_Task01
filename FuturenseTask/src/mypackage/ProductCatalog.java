package mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    public static void main(String[] args) {
        // Manage the ProductDemo catalog using a suitable collection
        Map<String, ProductDemo> ProductDemoCatalog = new HashMap<>();
        ProductDemoCatalog.put("001", new ProductDemo("001", "Laptop", "Electronics", 1200, 10));
        ProductDemoCatalog.put("002", new ProductDemo("002", "Shirt", "Apparel", 40, 4));
        ProductDemoCatalog.put("003", new ProductDemo("003", "Headphones", "Electronics", 100, 15));
        ProductDemoCatalog.put("004", new ProductDemo("004", "Jeans", "Apparel", 60, 5));

        // Category-wise ProductDemo Listing
        Map<String, List<ProductDemo>> categoryWiseProductDemos = new HashMap<>();
        for (ProductDemo ProductDemo : ProductDemoCatalog.values()) {
            categoryWiseProductDemos.computeIfAbsent(ProductDemo.getCategory(), k -> new ArrayList<>()).add(ProductDemo);
        }

        // Inventory Status Tracking: Flag ProductDemos with stock below a threshold
        int stockThreshold = 5;
        List<ProductDemo> lowStockProductDemos = new ArrayList<>();
        for (ProductDemo ProductDemo : ProductDemoCatalog.values()) {
            if (ProductDemo.getQuantity() < stockThreshold) {
                lowStockProductDemos.add(ProductDemo);
            }
        }

        // Frequent ProductDemo Updates: Updating quantity of a ProductDemo
        if (ProductDemoCatalog.containsKey("002")) {
            ProductDemo shirt = ProductDemoCatalog.get("002");
            shirt.setQuantity(6);
        }

        // Displaying results
        System.out.println("Category-wise Product Listing:");
        categoryWiseProductDemos.forEach((category, ProductDemos) -> {
            System.out.println(category + ":");
            ProductDemos.forEach(System.out::println);
        });

        System.out.println("\nInventory Status - Product below " + stockThreshold + " quantity:");
        lowStockProductDemos.forEach(System.out::println);

        System.out.println("\nUpdated Product Catalog:");
        ProductDemoCatalog.values().forEach(System.out::println);
    }
}
