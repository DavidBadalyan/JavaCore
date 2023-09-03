package homework;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        //task 1: print all the elements divided by space
        System.out.println("Task 1");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }


        //task 2: print the first element of the array
        System.out.println("\n\nTask 2");

        System.out.println("The first element of the array is " + numbers[0]);

        //task 3: print the last element of the array
        System.out.println("\nTask 3");

        System.out.println("The last element of the array is " + numbers[numbers.length - 1]);

        //task 4: print the length of the array
        System.out.println("\nTask 4");

        System.out.println("The length of the array is " + numbers.length);

        //task 5: print the smallest number in the array
        System.out.println("\nTask 5");

        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("The smallest number in the array is " + min);

        //task 6: print one/two elements from the middle of the array
        System.out.println("\nTask 6");

        if(numbers.length > 2) {
            if(numbers.length % 2 == 0) {
                System.out.println("The middle values of the array are " + numbers[numbers.length / 2 - 1] + ", "
                + numbers[numbers.length / 2 - 1 + 1]);
            }else {
                System.out.println("The middle value of the array is " + numbers[numbers.length / 2 - 1 + 1]);
            }
        } else {
            System.out.println("cannot print the middle value(s)");
        }

        //task 7: count and print the amount of even numbers in the array
        System.out.println("\nTask 7");

        int evenCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                evenCount++;
            }
        }

        System.out.println("The amount of even numbers in the array is " + evenCount);

        //task 8: count and print the amount of odd numbers in the array
        System.out.println("\nTask 8");

        System.out.println("The amount of odd numbers in the array is " + (numbers.length - evenCount));
        /*
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddCount++;
            }
        }

        System.out.println("The amount of odd numbers in the array is " + oddCount);
        */

        //task 9: print the sum of all the elements of the array
        System.out.println("\nTask 9");

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("The sum of the elements of the array is " + sum);

        //task 10: print the average of all the elements of the array
        System.out.println("\nTask 10");

        int average = 0;
        for (int i = 0; i < numbers.length; i++) {
            average += numbers[i];
        }
        average /= numbers.length;

        System.out.println("The average of all the elements in this array is " + average);
    }
}
