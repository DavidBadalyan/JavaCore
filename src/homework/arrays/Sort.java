package homework.arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4,7,1,3,9,0,2};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
