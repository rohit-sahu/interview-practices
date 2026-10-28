package io.devzona.interview_practices.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Epam {
    public static void main(String[] args) {
        // Sample data
        List<Orders> orders = Arrays.asList(
                new Orders(Arrays.asList(new Item("Electronics", 100), new Item("Clothing", 40))),
                new Orders(Arrays.asList(new Item("Electronics", 150), new Item("Clothing", 60))),
                new Orders(Arrays.asList(new Item("Food", 20), new Item("Electronics", 80))),
                new Orders(Arrays.asList(new Item("Clothing", 55), new Item("Food", 50)))
        );
        orders.stream().flatMap(order -> order.getItems().stream()).sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())).findFirst();

        orders.stream().flatMap(order -> order.getItems().stream()).collect(Collectors.groupingBy(Item::getCategory, Collectors.toSet())).values()
                .stream().map(items -> items.stream().mapToDouble(Item::getPrice).average()).collect(Collectors.toSet());
    }
}

class Orders {
    private List<Item> items;

    public Orders(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private String category;
    private double price;

    public Item(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
