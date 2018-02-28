import java.util.Arrays;

public class ArrayDeque<E> implements IDeque<E> {
    private E[] deque;
    private int size = 0;
    private int initialCapacity;

    public ArrayDeque(int initialCapacity) {
        @SuppressWarnings("unchecked")
        E[] deque = (E[]) new Object[initialCapacity];
        this.deque = deque;
        this.initialCapacity = initialCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {
        if (isFull()) {
            expandDeque();
        }
        for (int i = size; i > 0; --i) {
            deque[i] = deque[i - 1];
        }
        deque[0] = elem;
        ++size;
    }

    @Override
    public E pullFirst() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque er tom");
        }
        E output = deque[0];
        for (int i = 0; i < size; ++i) {
            deque[i] = deque[i + 1];
        }
        --size;
        return output;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque er tom");
        }
        return deque[0];
    }

    @Override
    public void addLast(E elem) throws DequeFullException {
        if (isFull()) {
            expandDeque();
        }
        deque[size] = elem;
        ++size;
    }

    @Override
    public E pullLast() throws DequeEmptyException {
        E output = deque[size - 1];
        deque[size - 1] = null;
        --size;
        return output;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque er tom");
        }
        return deque[size - 1];
    }

    @Override
    public boolean contains(Object elem) {
        for (Object obj : deque) {
            if (obj == elem) {
                return true;
            }
        }
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(deque, deque.length, a.getClass());
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[initialCapacity];
        deque = temp;
        size = 0;
    }

    private boolean isFull() {
        return size == deque.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void expandDeque() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[deque.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[i];
        }
        deque = temp;
    }
}
