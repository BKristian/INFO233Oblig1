import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDequeTest {
    ArrayDeque<Integer> intDeque = new ArrayDeque<>(10);
    ArrayDeque<String> strDeque = new ArrayDeque<>(10);

    @BeforeEach
    void populate() throws DequeFullException {
        intDeque.addLast(1);
        intDeque.addLast(2);
        intDeque.addLast(3);
        intDeque.addLast(4);
        intDeque.addLast(5);
        intDeque.addLast(6);
        intDeque.addLast(7);

        strDeque.addLast("a");
        strDeque.addLast("b");
        strDeque.addLast("c");
        strDeque.addLast("d");
        strDeque.addLast("e");
        strDeque.addLast("f");
        strDeque.addLast("g");

    }

    @Test
    void size() throws DequeFullException {
        assertEquals(7, intDeque.size());
        intDeque.addFirst(8);
        assertEquals(8, intDeque.size());
    }

    @Test
    void addFirst() throws DequeEmptyException, DequeFullException {
        assertEquals(Integer.valueOf(1), intDeque.peekFirst());
        intDeque.addFirst(8);
        assertEquals(Integer.valueOf(8), intDeque.peekFirst());
    }

    @Test
    void pullFirst() throws DequeEmptyException {
        assertEquals(Integer.valueOf(1), intDeque.pullFirst());
        assertEquals(Integer.valueOf(2), intDeque.pullFirst());
    }

    @Test
    void peekFirst() throws DequeEmptyException{
        assertEquals(Integer.valueOf(1), intDeque.peekFirst());
    }

    @Test
    void addLast() throws DequeFullException, DequeEmptyException {
        assertEquals(Integer.valueOf(7), intDeque.peekLast());
        intDeque.addLast(8);
        assertEquals(Integer.valueOf(8), intDeque.peekLast());
    }

    @Test
    void pullLast() throws DequeEmptyException {
        assertEquals(Integer.valueOf(7), intDeque.pullLast());
        assertEquals(Integer.valueOf(6), intDeque.pullLast());
    }

    @Test
    void peekLast() throws DequeEmptyException {
        assertEquals(Integer.valueOf(7), intDeque.peekLast());
    }

    @Test
    void contains() {
        assertEquals(true, intDeque.contains(4));
        assertEquals(true, strDeque.contains("d"));
    }

    @Test
    void toArray() {
    }

    @Test
    void clear() {
    }
}
