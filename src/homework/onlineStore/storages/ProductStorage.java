package homework.onlineStore.storages;

import homework.onlineStore.Exception.NoSuchProductException;
import homework.onlineStore.Exception.OutOfStockException;
import homework.onlineStore.enums.PaymentMethod;
import homework.onlineStore.models.Product;

import java.util.Scanner;

public class ProductStorage implements Commands{
    Scanner scanner = new Scanner(System.in);
    Product[] products = new Product[10];
    int size = 0;

    @Override
    public void add(Object product) {
        if(size >= products.length) {
            extend();
        }
        products[size++] = (Product) product;
    }

    private void extend() {
        Product[] temp = new Product[products.length + 10];
        System.arraycopy(products, 0, temp, 0, products.length);
        products = temp;
    }

    @Override
    public void print() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public int getIndexByID(String productID) throws NoSuchProductException {
        for (int i = 0; i < size; i++) {
            if (products[i].getID().equals(productID)) {
                return i;
            }
        }
        throw new NoSuchProductException("There is no such product.");
    }

    public Product getProductByID(String productID) throws NoSuchProductException {
        for (int i = 0; i < size; i++) {
            if (products[i].getID().equals(productID)) {
                return products[i];
            }
        }
        throw new NoSuchProductException("There is no such product.");
    }

    public void deleteProductByID(String givenID) {
        int index;
        try{
            index = getIndexByID(givenID);
        } catch (NoSuchProductException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i = index; i < size - 1; i++) {
            products[i] = products[i + 1];
        }
        --size;
    }

    public void buyProduct(String ID, int qty, PaymentMethod paymentMethod) throws OutOfStockException {
        Product product;
        for (int i = 0; i < size; i++) {
            if(products[i].getID().equals(ID)) {
                product = products[i];

                if(product.getStockQty() < qty) {
                    throw new OutOfStockException("The quantity you want is not available in the stock right now!");
                }

                System.out.println("Do you want to buy " + product.getName().toUpperCase() + " in the quantity of " + qty + " by " + paymentMethod);
                String choice = scanner.nextLine();

                if(choice.equalsIgnoreCase("YES")) {

                }
            } else {
                System.out.println("There is no product like that.");
                return;
            }
        }
    }
}
