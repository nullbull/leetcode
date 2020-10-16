package study.mutilthread.product;

/**
 * @author niuzhenhao
 * @date 2020/10/16 9:51
 * @desc
 */

public class Consumer implements Runnable{

    private BUffer bUffer;

    public Consumer(BUffer bUffer) {
        this.bUffer = bUffer;
    }

    @Override
    public void run() {
            try {
                bUffer.consume();
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
