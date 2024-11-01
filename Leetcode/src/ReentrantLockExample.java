import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() throws InterruptedException {
        lock.lock();  // 获取锁
        try {
            // 执行临界区代码
            System.out.println("Task is being performed by " + Thread.currentThread().getName());
            // Thread.sleep(1000);
        } finally {
            lock.unlock();  // 确保在完成任务后释放锁
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    example.performTask();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // 启动两个线程来执行任务
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();
    }
}
