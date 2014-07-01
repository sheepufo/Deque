import java.util.Iterator;
import java.util.NoSuchElementException;
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
    }
     public boolean isEmpty() {
        return N == 0;
    }
     public int size() {
         return N;
     }
     public void enqueue(Item item) {
         
     }
}
