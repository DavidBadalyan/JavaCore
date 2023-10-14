package homework.forLoop;

public class ForExamples {
    public static void main(String[] args) {
        //task 1: print 1 - 1000 adding a '-' after all of them, except the last one
        for (int i = 0; i < 1000; i++) {
            System.out.print(i + 1 + " ");
            if (i < 999) {
                System.out.print("- ");
            }
        }

        System.out.println("\n\n");

        //task 2: print all the even numbers 1 - 100 using the % operator
        for (int i = 0; i < 100; i++) {
            if ((i + 1) % 2 == 0) {
                System.out.print((i + 1) + " ");
            }
        }

        System.out.println("\n\n");

        //task 3: print the biggest number in an array of integers
        int[] array = {2, 5, 8, 4, 9, 3, 7};
        int max = array[0];

        for (int i = 1; i < 7; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("The biggest number in {2,5,8,4,9,3,7} array is: " + max);
    }
}
