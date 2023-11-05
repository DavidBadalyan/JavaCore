package homework.onlineStore.storages;

import homework.onlineStore.Exception.NoSuchOrderException;
import homework.onlineStore.Exception.NoSuchProductException;
import homework.onlineStore.Exception.NoSuchUserException;
import homework.onlineStore.Exception.OutOfStockException;
import homework.onlineStore.enums.OrderStatus;
import homework.onlineStore.enums.PaymentMethod;
import homework.onlineStore.enums.UserType;
import homework.onlineStore.models.Order;
import homework.onlineStore.models.Product;
import homework.onlineStore.models.User;

import java.util.Date;
import java.util.Scanner;

public class UserStorage implements Commands {
    private final ProductStorage productStorage = new ProductStorage();
    private final OrderStorage orderStorage = new OrderStorage();
    private final Scanner scanner = new Scanner(System.in);
    private User[] users = new User[10];
    private int size = 0;

    @Override
    public void add(Object user) {
        if (size >= users.length) {
            extend();
        }
        users[size++] = (User) user;
    }

    private void extend() {
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, users.length);
        users = temp;
    }

    @Override
    public void print() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void login(User user) throws NoSuchUserException {
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i])) {
                return;
            }
        }
        throw new NoSuchUserException("There is no user like that!");
    }


    public void buyProduct(User user, String ID, int qty, PaymentMethod paymentMethod) throws OutOfStockException {
        Product product = null;
        try {
            product = productStorage.getProductByID(ID);
        } catch (NoSuchProductException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (product != null) {
            if (product.getStockQty() < qty) {
                throw new OutOfStockException("The quantity you want is not available in the stock right now!");
            }

            System.out.println("Do you want to buy " + product.getName().toUpperCase() + " in the quantity of " + qty + " by " + paymentMethod);
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("YES")) {
                Order order = new Order(user, product, new Date(), product.getPrice() * qty, OrderStatus.NEW, qty, paymentMethod);
            }
        }
    }

    public void printMyOrders(User user) {
        Order[] orders = null;
        try {
            orders = orderStorage.getOrdersByUser(user);
        } catch (NoSuchOrderException e) {
            System.out.println("This user doesn't have any orders!");
            return;
        }

        if (orders != null) {
            for (int i = 0; i < orders.length && orders[i] != null; i++) {
                System.out.println(orders[i]);
            }
        }
    }

    public void printUsers() {
        for (User user : users) {
            if (user.getType().equals(UserType.USER)) {
                System.out.println(user);
            }
        }
    }
}

