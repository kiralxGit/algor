public class Demo4 {
    public static void main(String[] args) {
        MyHash myHash = new MyHash();

        myHash.put(777, 888);

        for (int i = 0; i < 32; i++) {
            myHash.put(i, 100 + i);
        }

        System.out.println(myHash.put(777, 1)); // ожидаем 888
        System.out.println(myHash.containsValue(888)); // ожидаем true
        System.out.println(myHash.get(15)); // ожидаем 115
        System.out.println("---");

        System.out.println(myHash.replace(1000, 15)); // ожидаем null
        System.out.println(myHash.replace(15, 500)); // ожидаем 115
        System.out.println(myHash.get(15)); // ожидаем 500
        System.out.println("---");

        System.out.println(myHash.size()); // ожидаем 33
        System.out.println(myHash.remove(333)); // ожидаем null
        System.out.println(myHash.remove(777)); // ожидаем 888
        System.out.println(myHash.size()); // ожидаем 32

    }

}
