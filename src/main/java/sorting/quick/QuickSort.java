package sorting.quick;

import org.junit.Test;
import sorting.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * 快速排序
 * <p>
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * <p>
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，
 * 右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 *
 * @param <T> 排序元素类型
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    /**
     * 打乱数组元素
     *
     * @param nums 目标数组
     */
    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l]; // 切分元素
        while (true) {
            // 从数组左端向右扫描，直到找到一个大于等于 v 的元素
            while (less(nums[++i], v) && i != h) ;
            // 从数组右端向左扫描，直到找到一个小于 v 的元素
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    /**
     * 查找数组第 k 大的元素
     * <p>
     * 基于切分的快速选择算法。
     * partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，
     * 且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
     *
     * @param nums 目标数组
     * @param k    第 k 大
     * @return 返回数组第 k 大的元素
     */
    public T select(T[] nums, int k) {
        if (k <= 0) { // 下越界，返回最小元素
            k = 1;
        } else if (k > nums.length) { // 上越界返回最大元素
            k = nums.length;
        }

        k -= 1; // 下标从0开始，需要先减1
        int low = 0, high = nums.length - 1;
        while (high > low) {
            int j = partition(nums, low, high);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                high = j - 1;

            } else {
                low = j + 1;
            }
        }
        return nums[k];
    }

    @Test
    public void test() {
        QuickSort<Integer> sort = new QuickSort<>();
        Integer[] nums = {3, 1, 6, 2, 5, 8, 4, 7};
        sort.partition(nums, 0, 7);
        assertArrayEquals(new Integer[]{2, 1, 3, 6, 5, 8, 4, 7}, nums);

        int res = sort.select(nums, 5);
        assertEquals(5, res);
        assertEquals(1, (int) sort.select(nums, -1));
        assertEquals(8, (int) sort.select(nums, 233));
    }
}
