package algs.threesum.test;

import org.junit.Test;
import algs.threesum.ThreeSum;
import algs.threesum.ThreeSumBinarySearch;
import algs.threesum.ThreeSumSlow;
import algs.threesum.ThreeSumTwoPointer;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {

    private static final int[] NUMS = {-2, -1, 0, 1, 2};
    private static final int EXPECT = 2;

    @Test
    public void testThreeSumSlow() {
        test(new ThreeSumSlow());
    }

    @Test
    public void testThreeSumBinarySearch() {
        test(new ThreeSumBinarySearch());
    }

    @Test
    public void testTreeSumTwoPointer() {
        test(new ThreeSumTwoPointer());
    }

    private void test(ThreeSum threeSum) {
        assertEquals(threeSum.count(NUMS), EXPECT);
    }

}