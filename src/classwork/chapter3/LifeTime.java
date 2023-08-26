package classwork.chapter3;

public class LifeTime {
    public static void main(String[] args) {
        int x;

        for(x = 0; x < 3; x++) {
            int y = -1;   //the value of y is renewed to -1 every time the loop works
            System.out.println("y is " + y);
            y = 100;   //this value is renewed every time as well
            System.out.println("y is now " + y);
        }
    }
}
