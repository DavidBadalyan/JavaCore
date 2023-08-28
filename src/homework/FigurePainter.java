package homework;

public class FigurePainter {
    public static void main(String[] args) {
//        //triangle 1 with 2D array
//        String[][] triangle1= new String[5][];
//        triangle1[0] = new String[1];
//        triangle1[1] = new String[2];
//        triangle1[2] = new String[3];
//        triangle1[3] = new String[4];
//        triangle1[4] = new String[5];
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                triangle1[i][j] = "* ";
//                System.out.print(triangle1[i][j]);
//            }
//            System.out.println();
//        }

        //triangle 1
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j >= 1 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

//        //triangle 2 with 2D array
//        String[][] triangle1= new String[5][];
//        triangle1[0] = new String[5];
//        triangle1[1] = new String[4];
//        triangle1[2] = new String[3];
//        triangle1[3] = new String[2];
//        triangle1[4] = new String[1];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5 - i; j++) {
//                triangle1[i][j] = "* ";
//                System.out.print(triangle1[i][j]);
//            }
//            System.out.println();
//        }

        //triangle 2
        for (int i = 5; i >= 1; i--) {
            for (int j = i; j >= 1 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        //triangle 3
        for (int i = 4; i >= 0; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("  ");
            }
            for (int j = 5 - i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        //triangle 4
        for (int i = 0; i <= 4; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print("  ");
            }
            for (int j = 5 - i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        //triangle 5
        for (int i = 1; i <= 5; i++) {
            for (int j = 5 - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 5 - i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
