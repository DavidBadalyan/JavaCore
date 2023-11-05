package homework.onlineStore.demo;

import homework.onlineStore.Exception.NoSuchOrderException;
import homework.onlineStore.Exception.NoSuchUserException;
import homework.onlineStore.Exception.OutOfStockException;
import homework.onlineStore.enums.PaymentMethod;
import homework.onlineStore.enums.ProductType;
import homework.onlineStore.enums.UserType;
import homework.onlineStore.models.Order;
import homework.onlineStore.models.Product;
import homework.onlineStore.models.User;
import homework.onlineStore.storages.OrderStorage;
import homework.onlineStore.storages.ProductStorage;
import homework.onlineStore.storages.UserStorage;

import java.util.Scanner;

public class StoreDemo {
    static Scanner scanner = new Scanner(System.in);
    static OrderStorage orderStorage = new OrderStorage();
    static ProductStorage productStorage = new ProductStorage();
    static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) {

        boolean isActive = true;

        while (isActive) {
            System.out.println("0 - Login");
            System.out.println("1 - Register");
            int choice = Integer.parseInt(scanner.nextLine());
            User user;

            switch (choice) {
                case 0:
                    user = login();
                    break;
                case 1:
                    user = register();
                    break;
                default:
                    user = null;
            }
            if (user != null) {
                if (user.getType().equals(UserType.ADMIN)) {
                    System.out.println("0 - End");
                    System.out.println("1 - Logout");
                    System.out.println("2 - Add Product");
                    System.out.println("3 - Remove Product By ID");
                    System.out.println("4 - Print Products");
                    System.out.println("5 - Print Users");
                    System.out.println("6 - Print Orders");
                    System.out.println("7 - Change Order Status");

                    int choice2 = Integer.parseInt(scanner.nextLine());

                    switch (choice2) {
                        case 0:
                            isActive = false;
                            break;
                        case 1:
                            continue;
                        case 2:
                            addProduct();
                            break;
                        case 3:
                            removeProductByID();
                            break;
                        case 4:
                            productStorage.print();
                            break;
                        case 5:
                            userStorage.printUsers();
                            break;
                        case 6:
                            orderStorage.print();
                            break;
                        case 7:
                            changeOrdStatus();
                            break;
                        default:
                            System.out.println("There is no command like that!");
                            break;
                    }
                } else {
                    System.out.println("0 - End");
                    System.out.println("1 - Logout");
                    System.out.println("2 - Print All Products");
                    System.out.println("3 - Buy Product");
                    System.out.println("4 - Print My Orders");
                    System.out.println("5 - Cancel Order By ID");

                    int choice2 = Integer.parseInt(scanner.nextLine());

                    switch (choice2) {
                        case 0:
                            isActive = false;
                            break;
                        case 1:
                            continue;
                        case 2:
                            productStorage.print();
                            break;
                        case 3:
                            System.out.println("Enter the id of the product you wanna buy: ");
                            String ID = scanner.nextLine();
                            System.out.println("Enter the amount of that product you want to buy: ");
                            int qty = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the Payment Method (CARD, CASH or PAYPAL):");
                            PaymentMethod paymentMethod = null;
                            try {
                                paymentMethod = PaymentMethod.valueOf(scanner.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println("It has to be CASH, CARD or PAYPAL");
                                return;
                            }
                            try {
                                userStorage.buyProduct(user, ID, qty, paymentMethod);
                            } catch (OutOfStockException e) {
                                System.out.println(e.getMessage());
                                return;
                            }
                            break;
                        case 4:
                            userStorage.printMyOrders(user);
                            break;
                        case 5:
                            System.out.println("Enter the ID of the order you want to cancel: ");
                            String ID1 = scanner.nextLine();
                            orderStorage.cancelOrderByID(ID1);
                            break;
                        default:
                            System.out.println("There is no command like that!");
                            break;
                    }
                }
            }
        }
    }

    public static User login() {
        System.out.println("Enter your ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter User Type (USER or ADMIN): ");
        UserType userType = null;
        try {
            userType = UserType.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("You should've entered USER or ADMIN");
            return null;
        }

        User user = new User(ID, name, email, password, userType);
        try {
            userStorage.login(user);
        } catch (NoSuchUserException e) {
            System.out.println(e.getMessage());
            return null;
        }

        System.out.println("---------------------------");
        return user;
    }

    public static User register() {
        System.out.println("Enter your ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter User Type (USER or ADMIN): ");
        UserType userType = null;
        try {
            userType = UserType.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("You should've entered USER or ADMIN");
            return null;
        }

        User user = new User(ID, name, email, password, userType);
        userStorage.add(user);

        System.out.println("---------------------------");
        return user;
    }

    public static void addProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product price: ");
        double price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the quantity of that product you have: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Product Type (ELECTRONICS, CLOTHING or BOOKS): ");
        ProductType productType = null;
        try {
            productType = ProductType.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("You should've entered ELECTRONICS, CLOTHING or BOOKS");
            return;
        }

        Product product = new Product(name, description, price, qty, productType);
        productStorage.add(product);

        System.out.println("---------------------------");
    }

    public static void removeProductByID() {
        System.out.println("Enter the ID of the product you want to remove:");
        String ID = scanner.nextLine();

        productStorage.deleteProductByID(ID);
        System.out.println("---------------------------");
    }

    public static void changeOrdStatus() {
        System.out.println("Please enter the ID of the order you wanna change: ");
        String ID = scanner.nextLine();

        try {
            orderStorage.changeOrderStatus(orderStorage.getOrderByID(ID));
        } catch (NoSuchOrderException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println("---------------------------");
        }
    }

    public static void buyProduct() {

    }
}
