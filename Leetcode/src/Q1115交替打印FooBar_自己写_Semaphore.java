import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Q1115交替打印FooBar_自己写_Semaphore {

    private int n;

    public Q1115交替打印FooBar_自己写_Semaphore(int n) {
        this.n = n;
    }

    //Semaphore变为1后通过acquire 然后重新变为0 等待release后再变成1
    private Semaphore fooSemaphore = new Semaphore(1); // 初始许可数量为1，表示foo可以先执行
    private Semaphore barSemaphore = new Semaphore(0); // 初始许可数量为0，表示bar需要等待

    private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);


    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // System.out.println(fooSemaphore);
            fooSemaphore.acquire(); // 获取许可，如果没有可用许可则等待
            printFoo.run();
            // System.out.println(fooSemaphore);
            System.out.println(barSemaphore);
            barSemaphore.release(); // 释放一个许可给bar
            System.out.println(barSemaphore);
            // Thread.yield();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(); // 获取许可，如果没有可用许可则等待
            printBar.run();
            fooSemaphore.release(); // 释放一个许可给foo
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Q1115交替打印FooBar_自己写_Semaphore solution = new Q1115交替打印FooBar_自己写_Semaphore(10);

        Runnable printFoo = () -> System.out.print("foo");
        Runnable printBar = () -> System.out.println("bar");


        // Thread threadFoo = new Thread(() -> {
        //     try {
        //         solution.foo(printFoo);
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        // });
        //
        // Thread threadBar = new Thread(() -> {
        //     try {
        //         solution.bar(printBar);
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        // });

        Thread threadFoo = new Thread(() -> {
            try {
                solution.foo(printFoo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadBar = new Thread(() -> {
            try {
                solution.bar(printBar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadFoo.start();
        threadBar.start();

    }
}
