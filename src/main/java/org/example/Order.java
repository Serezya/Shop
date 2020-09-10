package org.example;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final User user;
    private int orderNumber = 1;
    private Tracking status;
    private final Map<Integer, User> orders = new HashMap<>();

    public Order(User user, int orderNumber) {
        this.user = user;
        this.orderNumber = orderNumber;
        this.status = Tracking.WAITING_FOR_PAYMENT;
    }

    public void newOrder(User user, Tracking status) {
        orders.put(orderNumber, user);
        System.out.println("Новый заказ!" +
                "\nНомер: " + orderNumber +
                "\nСтатус: " + status +
                "\nОт: " + user.getName() + " " + user.getSurname() +
                "\n" + user.getCart());
        orderNumber++;
    }

    public void printOrders() {
        System.out.println("Выведем все заказы:");
        for (Map.Entry<Integer, User> orderEntry : orders.entrySet()) {
            System.out.println(orderEntry.getKey() + ". " + orderEntry.getValue().getName() + " " + orderEntry.getValue().getSurname()
                    + "\n" + orderEntry.getValue().getCart());
        }
    }

    public User getUser() {
        return user;
    }

    public Tracking getStatus() {
        return status;
    }

    public void setStatus(Tracking status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Заказ" +
                "\nНомер: " + orderNumber +
                "\nСтатус: " + status +
                "\nОт: " + user.getName() + " " + user.getSurname() +
                "\n" + user.getCart();
    }
}
