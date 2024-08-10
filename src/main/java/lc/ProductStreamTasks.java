package lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductStreamTasks {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 999.99, 10),
                new Product(2, "Phone", "Electronics", 599.99, 15),
                new Product(3, "Tablet", "Electronics", 399.99, 8),
                new Product(4, "Chair", "Furniture", 89.99, 20),
                new Product(5, "Desk", "Furniture", 199.99, 5)
        );

        List<Product> filteredProducts = filterAndCollect(products, "Electronics", 500);
        System.out.println("Filtered Products: " + filteredProducts);

        List<Product> sortedProducts = sortByPriceDescending(filteredProducts);
        System.out.println("Sorted Products: " + sortedProducts);

        List<String> productNames = mapToProductNames(products);
        System.out.println("Product Names: " + productNames);

        double totalPrice = calculateTotalPrice(filteredProducts);
        System.out.println("Total Price: " + totalPrice);

        Map<String, Long> categoryCount = groupAndCountByCategory(products);
        System.out.println("Category Count: " + categoryCount);
    }

    public static List<Product> filterAndCollect(List<Product> products, String category, double minPrice) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .filter(price -> price.getPrice() > minPrice)
                .collect(Collectors.toList());
    }

    public static List<Product> sortByPriceDescending(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public static List<String> mapToProductNames(List<Product> products) {


        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public static double calculateTotalPrice(List<Product> products) {
        // v1
        Double collect =
                products.stream()
                        .map(p -> p.getPrice() * p.getQuantity())
//                .reduce(0.0, (a, b) -> Double.sum(a, b));
//                .reduce(0.0, (a, b) -> sum(a, b));
//                .reduce(0.0, (a, b) -> a + b);
                        .reduce(0.0, Double::sum);

        //v2
        collect =
                products.stream()
                        .collect(
                                Collectors.summingDouble(
                                        p -> p.getPrice() * p.getQuantity())
                        );

        //v3


        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public static Map<String, Long> groupAndCountByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }
}
