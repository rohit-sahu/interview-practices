package io.devzona.interview_practices.java8;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProblem {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(1);
        order.setCategory("Electronics");
        order.setOrderName("12354");
        order.setPrice(200);
        order.setItemId(1);
        order.setItemName("Item1");

        Order order2 = new Order();
        order2.setId(2);
        order2.setCategory("Clothes");
        order2.setOrderName("075432");
        order2.setPrice(250);
        order2.setItemId(2);
        order2.setItemName("Item2");

        Order order3 = new Order();
        order3.setId(3);
        order3.setCategory("Pharmacy");
        order3.setOrderName("567948");
        order3.setPrice(300);
        order3.setItemId(3);
        order3.setItemName("Item3");

        Order order4 = new Order();
        order4.setId(4);
        order4.setCategory("Pharmacy");
        order4.setOrderName("567948");
        order4.setPrice(400);
        order4.setItemId(4);
        order4.setItemName("Item4");

        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order);

        Optional<Integer> optionalInteger = orders.stream().sorted((o1, o2) -> o2.getPrice().compareTo(o1.getPrice())).map(Order::getItemId).findFirst();
        System.out.println(optionalInteger.orElse(-1));

        Optional<Integer> optionalInteger1 = orders.stream().sorted(Comparator.comparing(Order::getPrice, Comparator.reverseOrder())).map(Order::getItemId).findFirst();
        System.out.println(optionalInteger1.orElse(-1));

        Set<Double> doubleSet = orders.stream().collect(Collectors.groupingBy(Order::getCategory, Collectors.toSet()))
                .values().stream().map(orderSet -> orderSet.stream().mapToInt(Order::getPrice).average().orElse(0)).collect(Collectors.toSet());
        doubleSet.forEach(System.out::println);

        Set<Order> collectByCategoryAndMaxOrderPrice = orders.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(Order::getCategory),
                        stringListMap -> stringListMap.values().stream().map(orderSet -> orderSet.stream()
                                .reduce((order1, order5) -> order1.getPrice() > order5.getPrice() ? order1 : order5).orElse(null))))
                .collect(Collectors.toSet());
        System.out.println(collectByCategoryAndMaxOrderPrice);

        Long collect = orders.stream().mapToDouble(Order::getPrice).boxed().collect(Collectors.collectingAndThen(Collectors.averagingDouble(Double::doubleValue), Math::round));
        System.out.println(collect);
    }

}

@Data
class Order {

    private Integer id;
    private String orderName;
    private Integer price;
    private String category;
    private Integer itemId;
    private String itemName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) && Objects.equals(orderName, order.orderName) && Objects.equals(itemId, order.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, itemId);
    }
}
