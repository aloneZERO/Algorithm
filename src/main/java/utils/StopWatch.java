package threesum;

import java.time.Duration;
import java.time.Instant;

/**
 * 用于统计算法运行时间
 */
public class StopWatch {

    private static Instant start;

    /**
     * 开始计时
     */
    public static void start() {
        start = Instant.now();
    }

    /**
     * 以调用 start() 为起点到现在所经过的时间
     *
     * @return 已用时（单位：秒）
     */
    public static double elapsedTime() {
        Instant now = Instant.now();
        return Duration.between(start, now)
                .toMillis() / 1000.0;
    }
}
