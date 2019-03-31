package algs.dp;

/**
 * 股票最大收益
 * 给定数组A[0...N-1]，其中A[i]表示某股票第i天的价格。
 * 如果允许最多只进行一次交易(先买一次，再卖一次)，
 * 请计算何时买卖达到最大收益，返回最大收益值。
 * <p>
 * 如：[7,1,5,3,6,4]，则最大收益为6-1=5。
 * 如：[7,6,4,3,1]，则最大收益为0。
 * <p>
 * 一路下跌，则最好的方法是不进行交易。
 *
 * @author justZero
 * @since 2019/3/31
 */
public class StockIncome1 {

    /**
     * 若在第i天卖出，则应该在哪天买入更好？
     * 应在 prices[0...i-1] 的最小值处买入。
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0]; // 最低买入价
        for (int i=1; i< prices.length; i++) {
            min = Math.min(min, prices[i-1]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

}
