public class Q1115交替打印FooBar {

    private int n;
    private final Object lock = new Object();
    private boolean fooTurn = true;

    public Q1115交替打印FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!fooTurn) {
                    lock.wait();
                }
                printFoo.run();
                fooTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooTurn) {
                    lock.wait();
                }
                printBar.run();
                fooTurn = true;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Q1115交替打印FooBar solution = new Q1115交替打印FooBar(10);

        Runnable printFoo = () -> System.out.print("foo");
        Runnable printBar = () -> System.out.println("bar");

        Thread threadFoo = new Thread(() -> {
            try {
                solution.foo(printFoo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadBar = new Thread(() -> {
            try {
                solution.bar(printBar);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadFoo.start();
        threadBar.start();

        try {
            threadFoo.join();
            threadBar.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
