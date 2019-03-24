package sorting;

/**
 * 研究排序算法的成本模型时，统计的是比较和交换的次数。
 *
 * @param <T> 排序对象类型
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    /**
     * 比较两个元素
     *
     * @param v 比较对象
     * @param w 比较对象
     * @return v 小于 w 时返回 true；否则返回 false
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 数组中交换两个元素位置
     *
     * @param a 目标数组
     * @param i 元素1的数组下标
     * @param j 元素2的数组下标
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
