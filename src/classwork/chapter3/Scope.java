package classwork.chapter3;

public class Scope {
    public static void main(String[] args) {
        int x; //known to all code within main method

        x = 10;
        if(x == 10) {
            int y = 20; //known only inside this if block

            //x and y are both known here
            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        }

        //y = 100  //y is not known here

        //x is still visible here;
        System.out.println("x is " + x);
    }
}
