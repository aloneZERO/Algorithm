package threesum.test;

import threesum.StopWatch;
import threesum.ThreeSum;
import threesum.ThreeSumSlow;

/**
 * 倍率实验
 * <p>
 * 如果 T(N) ~ aN^blogN，那么 T(2N)/T(N) ~ 2^b。
 */
public class RatioTest {

    public static void main(String[] args) {
        int N = 500;
        int loopTimes = 7;
        double preTime = -1;
        while (loopTimes-- > 0) {
            int[] nums = new int[N];
            StopWatch.start();
            ThreeSum threeSum = new ThreeSumSlow();
            int cnt = threeSum.count(nums);
            System.out.println(cnt);
            double elapsedTime = StopWatch.elapsedTime();
            double ratio = preTime == -1 ? 0 : elapsedTime / preTime;
            System.out.println(N + "  " + elapsedTime + "  " + ratio);
            preTime = elapsedTime;
            N *= 2;
        }
    }
}