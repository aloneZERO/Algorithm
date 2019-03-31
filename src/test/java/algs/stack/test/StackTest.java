package algs.stack.test;

import org.junit.Test;
import algs.stack.ArrayStack;
import algs.stack.ListStack;
import algs.stack.MyStack;

import static org.junit.Assert.*;


public class StackTest {

    @Test
    public void ResizingArrayStackTest() throws Exception {
        test(new ArrayStack<>());
    }

    @Test
    public void ListStackTest() throws Exception {
        test(new ListStack<>());
    }

    private void test(MyStack<Integer> stack) throws Exception {
        stack.push(1).push(2).push(3).push(4);

        assertEquals(stack.size(), 4);
        assertFalse(stack.isEmpty());

        for (Integer item : stack) {
            System.out.println(item);
        }

        assertEquals(4, (int) stack.pop());
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());

        assertTrue(stack.isEmpty());

    }
}
