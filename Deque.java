import java.util.Iterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private class Node {
        Item item;
        Node next;
    }
    private int size = 0;
    public Deque() {}
    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("Item can't be null.");
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public void addLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        oldlast.next = last;
    }
    public Item removeFirst() {
        Node oldfirst = first;
        first = first.next;
        return oldfirst.item;
    }
    public Item removeLast() {
        Node oldlast = last;
        last = null;
        return oldlast.item;
    }
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { /* not supported */} 
        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
     public static void main(String[] args) {
         Deque<Integer> de=new Deque<Integer>();
         for (int j=0; j<=5; j++) {
             de.addFirst(j);
         }
         StdOut.println(de.size());
     }
    
}