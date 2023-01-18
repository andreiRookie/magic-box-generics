import java.lang.reflect.Array;
import java.util.Random;

public class MagicBox<T> {
    private T[] items;
    private Random random = new Random();

    //  @SuppressWarnings("unchecked")
    public MagicBox(int maxItemsCount) {
        this.items = (T[]) new Object[maxItemsCount];

    /*  this.items = (T[]) new Object[maxItemsCount];
        T[] getItems() throws ClaasCastException
        Object[] getItems() works ok
        @SuppressWarnings("unchecked") doesn't help
    */
    }
    public Object[] getItems() {
        return items;
    }

    public MagicBox(Class<T> _class, int maxItemsCount) {
        this.items = (T[]) Array.newInstance(_class, maxItemsCount);
    }
    public T[] getTItems() {
        return items;
    }



    public boolean add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    public T pick() {
        int emptySlots = 0;
        for (T item : items) {
            if (item == null) {
                emptySlots++;
            }
        }
        if (emptySlots > 0) {
            throw new RuntimeException("The magicBox (" + this + ") still has " +
                    emptySlots + " vacant item places");
        }
        return items[random.nextInt(items.length)];
    }
}
