package homework.onlineStore.storages;

import homework.onlineStore.Exception.NoSuchOrderException;
import homework.onlineStore.Exception.NoSuchProductException;
import homework.onlineStore.enums.OrderStatus;
import homework.onlineStore.models.Order;
import homework.onlineStore.models.Product;
import homework.onlineStore.models.User;

import java.util.Scanner;

public class OrderStorage implements Commands {
    Scanner scanner = new Scanner(System.in);
    Order[] orders = new Order[10];
    int size = 0;

    @Override
    public void add(Object order) {
        if (size >= orders.length) {
            extend();
        }
        orders[size++] = (Order) order;
    }

    private void extend() {
        Order[] temp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, temp, 0, orders.length);
        orders = temp;
    }

    @Override
    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void changeOrderStatus(Order order) {
        System.out.println("Change status: ");
        String status = scanner.nextLine();
        try {
            order.setOrderStatus(OrderStatus.valueOf(status));
        } catch (IllegalArgumentException e) {
            System.out.println("There is no status like that.");
            return;
        }

        if (order.getOrderStatus().equals(OrderStatus.DELIVERED)) {
            order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
        }
    }

    public Order[] getOrdersByUser(User user) throws NoSuchOrderException {
        Order[] ordersByUser = new Order[size];
        int localSize = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(user)) {
                ordersByUser[localSize++] = orders[i];
            }
        }
        if (localSize != 0) {
            return ordersByUser;
        }

        throw new NoSuchOrderException("There is no such order.");
    }

    public Order getOrderByID(String orderID) throws NoSuchOrderException {
        for (int i = 0; i < size; i++) {
            if (orders[i].getID().equals(orderID)) {
                return orders[i];
            }
        }
        throw new NoSuchOrderException("There is no such order.");
    }

    public void cancelOrderByID(String ID) {
        Order order = null;
        try {
            order = getOrderByID(ID);
        } catch (NoSuchOrderException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (order != null) {
            order.setOrderStatus(OrderStatus.CANCELED);
        }
    }
}
