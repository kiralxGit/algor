import java.util.ArrayList;
import java.util.List;

public class MyHash {
    private Node head;
    private Node[] table = new Node[16];
    private int size = 0;


    public Object put(Integer k , Integer v){ // добавить элемент
        Node newNode = new Node(k, v);
        newNode.hash = getHash(k);
        if(containsKey(k)) {
            return get(k); // в оригинале вроде перезаписывает, здесь сделал как на семинаре возврат значения
        } else if(table[newNode.hash] != null){
            newNode.next = table[newNode.hash];
        }
        table[newNode.hash] = newNode;
        size++;
        return null;
    }
    public Object get(Integer k){ // получить значение соответствующее ключу
        int index = getHash(k);
        if(table[index] != null){
            return findNode(table[index], k);
        }
        return null;
    }
    public int size(){
        return size;
    }

    public Object remove(Integer k){ // удалить элемент с соответствующем ключём
        int index = getHash(k);
        if(table[index] != null) return removeNode(index, k);
        return null;
    }
    public Object replace(Integer k, Integer v){ // заменить значение
        int index = getHash(k);
        Node head = table[index];
        while(head != null){
            if(head.key == k) {
                Integer oldValue = head.value;
                head.value = v;
                return oldValue;
            }
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(Integer k) { //  проверка наличия ключа
        int index = getHash(k);
        Node head = table[index];
        while(head != null){
            if(head.key == k) return true;
            head = head.next;
        }
        return false;
    }
    public boolean containsValue(Integer v) { //  проверка наличия значения
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null){
                Node head = table[i];
                while(head != null){
                    if(head.value == v) return true;
                    head = head.next;
                }
            }
        }
        return false;
    }
    private Object findNode(Node head, Integer k){
        while(head != null){
            if(head.key == k) return head.value;
            head = head.next;
        }
        return null;
    }
    private int getHash(Integer k){
        return k.hashCode() % 16;
    }
    private Object removeNode(int index, Integer k){
        Node head = table[index];
        if(head.key == k){
            if(head.next == null) {
                table[index] = null;
                size--;
                return head.value;
            }
            table[index] = head.next;
            size--;
            return head.value;
        }
        while(head.next != null){
            if(head.next.key == k){
                Integer removeValue = head.next.value;
                head.next = head.next.next;
                size--;
                return removeValue;
            }
            head = head.next;
        }
        return null;
    }

    class Node{
        int key, value, hash;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
