import java.util.concurrent.atomic.AtomicInteger;

public class Q1115交替打印FooBar_自己写_AtomicInteger {

    private int n;
    AtomicInteger lockFoo = new AtomicInteger(1);//0不能打印 1可以打印
    AtomicInteger lockBar = new AtomicInteger(0);

    public Q1115交替打印FooBar_自己写_AtomicInteger(int n) {
        this.n = n;
    }


    // public void foo(Runnable printFoo) throws InterruptedException {
    //     for (int i = 0; i < n; i++) {
    //         while(lockFoo.get() == 0){}
    //         printFoo.run();
    //         lockFoo.decrementAndGet();
    //         lockBar.incrementAndGet();
    //     }
    // }
    //
    // public void bar(Runnable printBar) throws InterruptedException {
    //     for (int i = 0; i < n; i++) {
    //         while (lockBar.get()==0){}
    //         printBar.run();
    //         lockBar.decrementAndGet();
    //         lockFoo.incrementAndGet();
    //     }
    // }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(lockFoo.get() == 0){}
            System.out.print("foo");
            lockFoo.decrementAndGet();
            lockBar.incrementAndGet();
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (lockBar.get()==0){}
            System.out.println("bar");
            lockBar.decrementAndGet();
            lockFoo.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Q1115交替打印FooBar_自己写_AtomicInteger solution = new Q1115交替打印FooBar_自己写_AtomicInteger(10);

        // Runnable printFoo = () -> System.out.print("foo");
        // Runnable printBar = () -> System.out.println("bar");


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
                solution.foo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadBar = new Thread(() -> {
            try {
                solution.bar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadFoo.start();
        threadBar.start();

    }
}
