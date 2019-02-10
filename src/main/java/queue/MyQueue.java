package queue;

/**
 * 队列
 * <p>
 * 元素先进先出
 *
 * @param <Item> 队列中元素的类型
 */
public interface MyQueue<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();

    MyQueue<Item> add(Item item);

    Item remove() throws Exception;
}
