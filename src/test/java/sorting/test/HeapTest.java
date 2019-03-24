package sorting.test;

import org.junit.Test;
import sorting.heap.Heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapTest {

    @Test
    public void test() {
        Heap<Integer> heap = new Heap<>(10);

        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(1);

        assertEquals(heap.size(), 4);

        assertEquals(6, (int) heap.delMax());
        assertEquals(5, (int) heap.delMax());
        assertEquals(4, (int) heap.delMax());
        assertEquals(1, (int) heap.delMax());

        assertTrue(heap.isEmpty());
    }
}