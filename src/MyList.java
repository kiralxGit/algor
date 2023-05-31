public class MyList {
    private Node head;
    private int size = 0;

    public void reverse(){
        if(size > 1){
            Node previous = null;
            Node current = head;

            while (current != null) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            head = previous;
        }
    }
    public String get(int i) {
        if(size < i) throw new ArrayIndexOutOfBoundsException();
        Node tmp = head;
        while (i > 0){
            tmp = tmp.next;
            i--;
        }
        return tmp.value;
    }

    public int size(){
        return size;
    }
    public void remove(){
        if(head != null) head = head.next;
        size--;
    }
    public void add(String str){
        Node node = new Node();
        node.value = str;
        if(head != null) node.next = head;
        head = node;
        size++;
    }


    class Node{
        public String value;
        public Node next;
    }
}

