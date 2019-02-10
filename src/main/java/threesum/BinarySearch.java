package threesum;

public class BinarySearch {

    /**
     * 二分查找
     *
     * @param nums 待查找数组（有序）
     * @param target 查找目标
     * @return 查找成功：返回数组下标；否则返回-1
     */
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }
}
