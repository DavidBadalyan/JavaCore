package homework.dynamicarray;

public class DynArrTest {
    public static void main(String[] args) {
        DynArray array = new DynArray();

        for (int i = 0; i < 25; i++) {
            array.add(i + 1);
        }

        array.print();

        System.out.println(array.getByIndex(23) + " " + array.getByIndex(31));
    }
}
