package study.nettylearn.nettyl.niosocket;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author niuzhenhao
 * @date 2020/9/28 13:45
 * @desc
 */

public abstract class AbstractNIO {


    void listen(Selector selector) throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.keys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                handlerKey(key);
            }
        }
    }

    abstract void handlerKey(SelectionKey key) throws IOException;

}
