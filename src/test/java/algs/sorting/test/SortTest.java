package algs.sorting.test;

import org.junit.Test;
import algs.sorting.*;
import algs.sorting.merging.Down2UpMergeSort;
import algs.sorting.merging.Up2DownMergeSort;
import algs.sorting.quick.QuickSort;
import algs.sorting.quick.ThreeWayQuickSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private static final Integer[][] NUMS_BEFORE = {
            {1, 2, 3},
            {3, 2, 1},
            {1},
            {1, 3, 5, 7, 6, 4, 2, 0, -1, -2},
            {Integer.MAX_VALUE, Integer.MIN_VALUE}
    };

    private static final Integer[][] NUMS_AFTER = {
            {1, 2, 3},
            {1, 2, 3},
            {1},
            {-2, -1, -0, 1, 2, 3, 4, 5, 6, 7},
            {Integer.MIN_VALUE, Integer.MAX_VALUE}
    };


    @Test
    public void SelectionTest() {
        test(new Selection<>());
    }

    @Test
    public void BubbleTest() {
        test(new Bubble<>());
    }

    @Test
    public void InsertionTest() {
        test(new Insertion<>());
    }

    @Test
    public void ShellTest() {
        test(new Shell<>());
    }

    @Test
    public void Up2DownMergeSortTest() {
        test(new Up2DownMergeSort<>());
    }

    @Test
    public void Down2UpMergeSortTest() {
        test(new Down2UpMergeSort<>());
    }

    @Test
    public void QuickSortTest() {
        test(new QuickSort<>());
    }

    @Test
    public void ThreeWayQuickSortTest() {
        test(new ThreeWayQuickSort<>());
    }

    private void test(Sort<Integer> sort) {
        for (int i = 0; i < NUMS_BEFORE.length; i++) {
            Integer[] nums = Arrays.copyOf(NUMS_BEFORE[i], NUMS_BEFORE[i].length);

            sort.sort(nums);
            assertArrayEquals(nums, NUMS_AFTER[i]);
        }
    }
}
