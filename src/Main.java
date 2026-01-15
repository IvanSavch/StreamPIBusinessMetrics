import by.task2.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("1","Ivan","Sav.van", LocalDateTime.now(),23,"Minsk");
        Customer customer2 = new Customer("2","Ivan2","Sav.van", LocalDateTime.now(),23,"Brest");
        Customer customer3 = new Customer("3","Ivan3","Sav.van", LocalDateTime.now(),23,"Gomel");
        Customer customer4 = new Customer("4","Ivan4","Sav.van", LocalDateTime.now(),23,"Minsk");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("tv",2,3000.0,Category.ELECTRONICS));
        Order order = new Order("1",LocalDateTime.now(),customer,orderItems, OrderStatus.PROCESSING);
        Order order2 = new Order("2",LocalDateTime.now(),customer2,orderItems, OrderStatus.DELIVERED);
        Order order3 = new Order("3",LocalDateTime.now(),customer3,orderItems, OrderStatus.DELIVERED);
        Order order4  = new Order("4",LocalDateTime.now(),customer4,orderItems, OrderStatus.PROCESSING);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        List<String> list = orderList.stream().map((Order t) -> t.getCustomer().getCity()).distinct().collect(Collectors.toList());
//        System.out.println(list);
        double sum = orderList.stream().filter(s -> s.getStatus().equals(OrderStatus.DELIVERED)).flatMap(o -> o.getItems().stream()).mapToDouble(OrderItem::getTotalPrice).sum();
        System.out.println(sum);
        System.out.println();
    }
}