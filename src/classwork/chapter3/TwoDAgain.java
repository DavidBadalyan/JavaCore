package classwork.chapter3;

public class TwoDAgain {
    public static void main(String[] args) {
        int[][] twoD= new int[4][];

        /*
        for (int i = 0; i < 4; i++) {
            twoD[i] = new int[i + 1];
        }
        */

        twoD[0] = new int[1];
        twoD[1] = new int[2];
        twoD[2] = new int[3];
        twoD[3] = new int[4];

        int i, j, k = 0;
        for (i = 0; i < 4; ++i) {
            for (j = 0; j < i + 1; ++j) {
                twoD[i][j] = k + 1;
                k++;
            }
        }

        for (i = 0; i < 4; ++i) {
            for (j = 0; j < i + 1; ++j) {
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }
    }
}
