package study.mutilthread.product;

/**
 * @author niuzhenhao
 * @date 2020/10/16 9:51
 * @desc
 */

public class Producer implements Runnable{

    private BUffer bUffer;


    public Producer(BUffer bUffer) {
        this.bUffer = bUffer;
    }

    @Override
    public void run() {
            try {

                bUffer.product();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
