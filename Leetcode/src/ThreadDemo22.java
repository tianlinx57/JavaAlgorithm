public class ThreadDemo22 {
    public static void main(String[] args) throws InterruptedException {
        Object locker =new Object();
        Thread t1=new Thread(() ->{
            try {
                System.out.println("wait 开始");
                synchronized (locker){
                    locker.wait();
                }
                System.out.println("wait 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t3=new Thread(() ->{
            try {
                System.out.println("wait 开始");
                synchronized (locker){
                    locker.wait();
                }
                System.out.println("wait 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t4=new Thread(() ->{
            try {
                System.out.println("wait 开始");
                synchronized (locker){
                    locker.wait();
                }
                System.out.println("wait 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });



        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("notifyAll 开始");
                locker.notifyAll();
                System.out.println("notifyAll 结束");
            }
        });
        t1.start();
        t3.start();
        t4.start();
        Thread.sleep(1000);
        t2.start();


    }
}

