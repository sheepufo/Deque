import java.util.Iterator;
//import java.util.NoSuchElementException;
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
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
         if( N == a.length) {
             resize ( 2 * a.length);
         }
         a[N++] = item;
     }
     public Item dequeue(){
         int rt = StdRandom.uniform(N);
         Item item = a[rt];
         a[rt] = null;
         N--;
         if (N > 0 && N == a.length/4) resize(a.length/2);
         return item;
     }
     public Item sample(){
         int rt = StdRandom.uniform(N);
         return a[rt];
     }
     public Iterator<Item> iterator()
     { return new ReverseArrayIterator(); }
     private class ReverseArrayIterator implements Iterator<Item>
     {
         private int i = N;
         public boolean hasNext() { return i > 0; }
         public void remove() { /* not supported */}
         public Item next() { return a[--i]; }
     }
}
