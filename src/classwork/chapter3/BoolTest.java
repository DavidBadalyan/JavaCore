package classwork.chapter3;

public class BoolTest {
    public static void main(String[] args) {
        boolean b;

        b = false;
        System.out.println("b is " + b);
        b = true;
        System.out.println("b is now " + b);

        //a boolean value can also control an if and for statement
        if(b) {
            System.out.println("This is executed");
        }

        b = false;
        if(b) {
            System.out.println("This is not executed");
        }

        //the outcome of a relational operator like >, <, == is a boolean
        System.out.println("10 > 9 is " + (10 > 9));
    }
}
