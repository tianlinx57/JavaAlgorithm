import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 线程池10个 {

    public static void main(String[] args) {
        线程池10个 solution = new 线程池10个();

        int corePoolSize = 2;
        int maxPoolSize = 5;
        long keepAliveSeconds = 5;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(4);
        AtomicInteger threadId = new AtomicInteger(1);
        ThreadFactory factory = runnable -> new Thread(runnable, "thread-" + threadId.getAndIncrement());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS, workQueue, factory);

        for (int i = 0; i < 10; i++) {
            int finalI = i+1;
            executor.submit(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(finalI);
                } catch (InterruptedException ignored) {}
                // System.out.println(Thread.currentThread().getName());
            });
        }

    }
}