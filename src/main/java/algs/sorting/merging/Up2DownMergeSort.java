package algs.sorting.merging;

/**
 * 将一个大数组分成两个小数组去求解。
 * 即分治思想。也是快速排序的核心思想。
 * <p>
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
}
