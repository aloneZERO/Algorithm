package algs.sorting.merging;

import algs.sorting.Sort;

/**
 * 二路归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 */
abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * 将数组中两个已经排序的部分归并成一个。
     *
     * @param nums 待归并数组
     * @param l 第一部分起点
     * @param m 第一部分终点；m+1 为第二部分起点
     * @param h 第二部分终点
     */
    void merge(T[] nums, int l, int m, int h) {
        // 辅助数组
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Comparable[nums.length];

        int i = l, j = m + 1;

        // 将原数组下标从 l~h 的元素复制到辅助数组对应的位置中
        System.arraycopy(nums, l, aux, l, h + 1 - l);

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
