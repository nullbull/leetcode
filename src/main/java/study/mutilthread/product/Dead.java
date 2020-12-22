package study.mutilthread.product;

/**
 * @author niuzhenhao
 * @date 2020/12/22 15:40
 * @desc 两个线程死锁
 */

public class Dead {


    public static Object lock1 = new Object();

    public static Object lock2 = new Object();



    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread t = new Thread(threadTest);
        Thread tb = new Thread(new ThreadTestB());
        t.start();
        tb.start();
    }


    public static class ThreadTest implements Runnable{

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName()  + " is running");
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                        synchronized (lock1) {
                            System.out.println(Thread.currentThread().getName()  + " is waiting" + lock1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static class ThreadTestB implements Runnable{

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName()  + " is running");
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName()  + " is waiting" + lock2);

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
