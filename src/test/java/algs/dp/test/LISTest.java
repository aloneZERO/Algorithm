package algs.dp.test;

import algs.dp.LIS;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author justZero
 * @since 2019/3/31
 */
public class LISTest {

    @Test
    public void test1() {
        int[] arr = {5, 6, 7, 1, 2, 8};
        String ans = new LIS(arr)
                .getLIS()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        assertEquals("5678", ans);
    }

}
