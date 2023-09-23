package homework.dynamicarray;

public class DynArrTest {
    public static void main(String[] args) {
        DynArray array = new DynArray();

        for (int i = 0; i < 25; i++) {
            array.add(i + 1);
        }

        System.out.println("this is the normal array");
        array.print();
        array.set(0, 85);
        System.out.println("this is the array after the \"set\" method");
        array.print();
        array.add(2, 1);
        System.out.println("this is the array after the \"add\" method");
        array.print();
        System.out.println(array.exists(55));
        System.out.println(array.exists(25));
        System.out.println(array.getIndexByValue(25));
        array.deleteByIndex(24);
        System.out.println("this is the array after \"deleteByIndex\" method");
        array.print();
    }
}
