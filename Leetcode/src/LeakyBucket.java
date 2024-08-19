import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 漏斗算法限流示例
 */
public class LeakyBucket {

    private final int capacity; // 漏斗容量
    private final int permitsPerSecond; // 漏水速率（令牌生成速率）
    private final AtomicInteger permits; // 当前可用令牌数
    private final ScheduledExecutorService scheduler;

    public LeakyBucket(int capacity, int permitsPerSecond) {
        this.capacity = capacity;
        this.permitsPerSecond = permitsPerSecond;
        this.permits = new AtomicInteger(capacity);
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> replenishPermits(), 0, 1, TimeUnit.MILLISECONDS);
    }

    /**
     * 尝试获取令牌
     *
     * @return 是否获取成功
     */
    public boolean acquire() {
        while (true) {
            int availablePermits = permits.get();
            int newPermits = availablePermits - 1;
            if (newPermits < 0) {
                return false;
            }
            if (permits.compareAndSet(availablePermits, newPermits)) {
                return true;
            }
        }
    }

    /**
     * 每秒补充令牌
     */
    private void replenishPermits() {
        while (true) {
            int availablePermits = permits.get();
            int newPermits = Math.min(availablePermits + permitsPerSecond, capacity);
            if (permits.compareAndSet(availablePermits, newPermits)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // LeakyBucket leakyBucket = new LeakyBucket(10, 1); // 漏斗容量为10，漏水速率为1令牌/秒
        //
        // for (int i = 0; i < 20; i++) {
        //     int finalI = i;
        //     new Thread(() -> {
        //         if (leakyBucket.acquire()) {
        //             System.out.println("获取令牌成功，处理任务：" + finalI);
        //         } else {
        //             System.out.println("获取令牌失败，任务：" + finalI + " 被丢弃");
        //         }
        //     }).start();
        // }
        //
        // Thread.sleep(5000);
        // String domain = "www.baidu.com";
        // String[] split = domain.split("\\.");
        // System.out.println(Arrays.toString(split));

        String domain = "maps.google.com";
        String[] parts = domain.split("g"); // 错误的用法

        System.out.println(Arrays.toString(parts));
    }
}
