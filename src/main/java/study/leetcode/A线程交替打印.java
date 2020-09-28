package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/8/28 16:16
 * @desc
 */

public class A线程交替打印 {

    public volatile static boolean flag = false;

    public static final Object lock = new Object();

    static int i = 0;
    static int j = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (i < 10) {
                synchronized (lock) {
                    if (flag){
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "----" + (i++));
                        flag = true;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (j < 10) {
                synchronized (lock) {
                    if (!flag){
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "----" + (j++));
                        flag = false;
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }
}
