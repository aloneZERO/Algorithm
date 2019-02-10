package threesum;

/**
 * 用于统计算法运行时间
 */
public class StopWatch {

    private static long start;

    /**
     * 开始计时
     */
    public static void start() {
        start = System.currentTimeMillis();
    }

    /**
     * 以调用 start() 为起点到现在所经过的时间
     *
     * @return 已用时（单位：秒）
     */
    public static double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
