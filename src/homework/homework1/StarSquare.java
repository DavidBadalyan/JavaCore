package homework.homework1;

public class StarSquare {
    public static void main(String[] args) {
        /*for (int i = 0; i < 6; i++) {
            System.out.println("******");
        }*/

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //not a good solution
        /*
        System.out.println("******");
        System.out.println("******");
        System.out.println("******");
        System.out.println("******");
        System.out.println("******");
        System.out.println("******");
        */
    }
}
