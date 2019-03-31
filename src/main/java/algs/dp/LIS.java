package algs.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 最长递增子序列
 * Longest Increasing Subsequence
 * 给定长度为 N 的数组 A，计算 A 的最长的单调递增的子序列(不一定连续)。
 * 如：给定数组 A {5,6,7,1,2,8}，则 A 的 LIS 为 {5,6,7,8}，长度为4。
 *
 * @author justZero
 * @since 2019-3-31
 */
public class LIS {

    private int[] arr;
    private List<Integer> lis; // 存储 LIS
    private int[] pre; // 前驱数组
    private int index; // 子序列结尾元素在原数组中的下标

    public LIS(int[] arr) {
        this.arr = arr;
        this.lis = new ArrayList<>();
        this.pre = new int[arr.length];
        this.compute();
        this.buildLIS();
    }

    /**
     * 计算 LIS，时间复杂度 O(N^2)
     */
    private void compute() {
        int len = arr.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            pre[i] = -1;
        }

        int lisLen = 1;
        index = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (lisLen < dp[i]) {
                lisLen = dp[i];
                index = i;
            }
        }
    }
    private void buildLIS() {
        while (index >= 0) {
            lis.add(arr[index]);
            index = pre[index];
        }
        Collections.reverse(lis);
    }

    public List<Integer> getLIS() {
        return lis;
    }
}
