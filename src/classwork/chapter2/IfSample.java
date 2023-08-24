package classwork.chapter2;

public class IfSample {
    public static void main(String[] args) {
        int x, y;
        x = 10;
        y = 20;

        if (x < y) {
            System.out.println("x is less than y!" + 5);
        }

        x *= 2;
        if (x == y) {
            System.out.println("x is equal to y!");
        }

        x *= 4;
        if (x > y) {
            System.out.println("x is larger than y!");
        }

        //this is not going to work
        if (x == y) {
            System.out.println("You are not going to see this!");
        }
    }
}
