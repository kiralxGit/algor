public class Demo3 {
    public static void main(String[] args) {
        MyList myList = new MyList();


        myList.add("Java_1");
        myList.add("Java_2");
        myList.add("Java_3");
        myList.add("Java_4");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        myList.reverse();

        System.out.println(myList.size());
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

    }
}