package study.mutilthread.product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author niuzhenhao
 * @date 2020/10/16 9:55
 * @desc
 */

public class BUffer {


    private int MAX = 10;

    private List<String> queue = new ArrayList<>(10);

    private final Object lock = new Object();

    private final Object readLock = new Object();


    private AtomicInteger count = new AtomicInteger(0);


    public  void product() throws Exception{
        while (true) {
            Thread.sleep(200);
            synchronized (readLock) {
                readLock.notifyAll();
            }
            synchronized (lock) {
                if (queue.size() <= MAX) {
                    String product = "product-" + (count.getAndIncrement() % MAX);
                    queue.add(product);
                    System.out.println(Thread.currentThread().getName() + "product" + product);
                } else {
                    lock.wait();
                }
            }
        }


    }

    public void consume() throws Exception{
        while (true) {
            Thread.sleep(500);
            synchronized (lock) {
                lock.notifyAll();
            }
            synchronized (readLock) {
                if (!queue.isEmpty()) {
                    String remove = queue.remove(0);
                    System.out.println(Thread.currentThread().getName() + "consume" + remove);

                }
            }
        }



    }


    public static void main(String[] args) {
        BUffer bUffer = new BUffer();
        Consumer consumerA = new Consumer(bUffer);
        Consumer consumerB = new Consumer(bUffer);

        Producer producer = new Producer(bUffer);

        new Thread(producer).start();
        new Thread(consumerA).start();
        new Thread(consumerB).start();


    }


}
