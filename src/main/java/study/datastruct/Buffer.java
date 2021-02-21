package study.datastruct;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author niuzhenhao
 * @date 2021/2/18 13:56
 * @desc
 */

public class Buffer {

    private LinkedList<String> queue = new LinkedList<>();
    private static Object empty_lock = new Object();
    private static Object full_lock = new Object();
    private AtomicInteger count = new AtomicInteger();
    private int size = 10;

    private void add() {

        synchronized (empty_lock) {
            empty_lock.notifyAll();
        }


            synchronized (full_lock) {
                if (queue.size() == size) {
                try {
                    System.out.println("queue is full wait");
                    full_lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                } else {
                    int cur = count.getAndIncrement();
                    queue.add("produce:" + cur);
                    System.out.println("produce:" + cur);
            }
        }

    }

    private  void consume() {
        synchronized (full_lock) {
            full_lock.notifyAll();
        }

       synchronized (empty_lock) {
           if (queue.isEmpty()) {
               try {
                   System.out.println("queue is empty wait");
                   empty_lock.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           } else {
               String poll = queue.poll();
               System.out.println("consume:" + poll);
           }
       }

    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread a = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buffer.add();
            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                buffer.consume();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
    }


}
