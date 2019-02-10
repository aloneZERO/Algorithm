package sorting.merging;

import sorting.Sort;

/**
 * 二路归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux; // 辅助数组

    /**
     * 将数组中两个已经排序的部分归并成一个。
     *
     * @param nums 待归并数组
     * @param l 第一部分起点
     * @param m 第一部分终点；m+1 为第二部分起点
     * @param h 第二部分终点
     */
    protected void merge(T[] nums, int l, int m, int h) {
        aux = (T[]) new Comparable[nums.length];

        int i = l, j = m + 1;
        System.arraycopy(nums, l, aux, l, h + 1 - l); // 将数据复制到辅助数组

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];

            } else if (j > h) {
                nums[k] = aux[i++];

            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
