package homework.braceCheck;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker example1 = new BraceChecker("Hello from {{([Java])}}");
        example1.check();
    }
}
