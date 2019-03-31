package algs.stack;

/**
 * 栈
 * <p>
 * 元素先进后出
 *
 * @param <Item> 栈内元素类型
 */
public interface MyStack<Item> extends Iterable<Item> {

    MyStack<Item> push(Item item);

    Item pop() throws Exception;

    boolean isEmpty();

    int size();

}
