package classwork.chapter10;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, tryLoop;
        int[] arr;

        a = Integer.parseInt(scanner.nextLine());

        arr = new int[a];

        tryLoop = Integer.parseInt(scanner.nextLine());

        try {
            for (int i = 0; i < tryLoop; i++) {
                System.out.println("Please enter a number to fill the array!");
                arr[i] = Integer.parseInt(scanner.nextLine());
            }
        } catch(Throwable e) {
            System.out.println("The amount of times you wanted the loop to run is more than array.length");
        }
    }
}
