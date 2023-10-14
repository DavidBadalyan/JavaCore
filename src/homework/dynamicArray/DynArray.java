package homework.dynamicArray;

public class DynArray {
        //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
        private int[] array = new int[10];
        //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
        private int size = 0;

        //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
        //և ավելացնենք
        public void add(int value) {
            if (size >= array.length) {
                extend();
            }
            array[size] = value;
            size++;
        }

        //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
        //2․ քցել հին մասիվի էլեմենտները նորի մեջ
        //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
        private void extend() {
            int[] newArr = new int[array.length + 10];
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }

        //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
        // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
        public int getByIndex(int index) {
            if(index >= 0 && index < array.length) {
                return array[index];
            }
            return -1;
        }

        //տպել մասիվի ավելացված էլեմենտները
        public void print() {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        //ջնջել մասիվի index-երորդ էլեմենտը
    //եթե չկա նման ինդեքսով էլեմենտ, տպել, որ չկա նման էլեմենտ
        public void deleteByIndex(int index) {
            if (index < 0 || index >= array.length){
                System.out.println("There is no index like that!");
                return;
            }

            int[] newArr = new int[array.length-1];

            int shift = 0;

            for (int i = 0; i < newArr.length; i++) {
                if (i == index) {
                    shift = 1;
                }
                newArr[i] = array[i + shift];
            }

            array = newArr;
        }
        //տրված value-ն դնելու ենք տրված index-ով էլեմենտի տեղը։
    //Հին արժեքը կկորի
    //եթե նման ինդեքսով էլեմենտ չկա, գրում ենք որ չկա։
        public void set(int index, int value) {
            if (index < 0 || index >= array.length){
                System.out.println("There is no index like that!");
                return;
            }

            array[index] = value;
        }
        //ավելացնել տրված value-ն տրված ինդեքսում, իսկ էղած էլեմենտները մի հատ աջ տանել։
    //Եթե չկա նման ինդեքս, տպել որ չկա
        public void add(int index, int value) {
            if (index < 0 || index >= array.length){
                System.out.println("There is no index like that!");
                return;
            }

            int[] newArr = new int[array.length + 1];
            int shift = 0;

            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    newArr[i] = value;
                    shift = 1;
                }

                newArr[i + shift] = array[i];
            }

            array = newArr;
        }

        //Վերադարձնել true եթե տրված value-ն կա մեր մասիվի մեջ, եթե ոչ false
        public boolean exists(int value) {
            for (int j : array) {
                if (j == value) {
                    return true;
                }
            }
            return false;
        }
        //Վերադարձնել տրված value-ի ինդեքսը, եթե շատ կա տվյալ թվից, վերադարձնել առաջին ինդեքսը։
    //եթե չկա, -1
        public int getIndexByValue(int value) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1;
        }

    }
