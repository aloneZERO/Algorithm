package algs.dp.test;

import algs.dp.StockIncome1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author justZero
 * @since 2019/3/31
 */
public class StockIncomeTest {

    @Test
    public void test1() {
        StockIncome1 stock = new StockIncome1();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int ans = stock.maxProfit(prices);
        assertEquals(5, ans);
    }

}
