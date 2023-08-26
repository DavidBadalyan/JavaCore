package classwork.chapter3;

public class DynInit {
    public static void main(String[] args) {
        double a, b, c;

        a = 3.0;
        b = 4.0;

        //c is dynamically initialized
        c = Math.sqrt(a * a + b * b);

        System.out.println("Hypotenuse is " + c);
    }
}
