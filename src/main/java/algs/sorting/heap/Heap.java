package algs.sorting.heap;

/**
 * 大根堆
 * <p>
 * 堆中某个节点的值总是大于等于其子节点的值，并且堆是一颗完全二叉树。
 * <p>
 * 堆可以用数组来表示，这是因为堆是完全二叉树，而完全二叉树很容易就存储在数组中。
 * 位置 k 的节点的父节点位置为 k/2，而它的两个子节点的位置分别为 2k 和 2k+1。
 * 这里不使用数组索引为 0 的位置，是为了更清晰地描述节点的位置关系。
 *
 * @param <T> 堆中元素类型
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        //noinspection unchecked
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 比较堆数组中两元素的大小
     *
     * @param i 元素1的数组下标
     * @param j 元素2的数组下标
     * @return 元素1小于元素2，返回 true；否则返回 false
     */
    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    /**
     * 节点上浮
     *
     * @param k 待上浮节点的堆数组下标
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 节点下沉
     *
     * @param k 待下沉节点的堆数组下标
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // 先选出节点 k 最大的子节点
            if (j < N && less(j, j + 1)) {
                j++;
            }
            // 若节点 k 大于其子节点，则下沉完毕
            if (less(j, k)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 插入元素
     * <p>
     * 将新元素放到数组末尾，然后上浮到合适的位置。
     *
     * @param v 待插入的元素
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * 删除堆顶元素
     * <p>
     * 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，
     * 并让这个元素下沉到合适的位置。
     *
     * @return 堆顶元素，即最大元素
     */
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }
}
