package study.nettylearn.nettyl.niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author niuzhenhao
 * @date 2020/9/28 14:07
 * @desc
 */

public class NioClient extends AbstractNIO {

    private static final int BUFFER_SIZE = 2048;

    private ByteBuffer sendBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    private ByteBuffer receiveBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    private Selector selector;


    void connectedServer(final String ip, final int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(ip, port));
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        System.out.println("client connect to server!");
    }

    @Override
    void handlerKey(SelectionKey key) throws IOException {
        SocketChannel client;
        int count;
        if (key.isConnectable()) {
            //1. 客户端连接上时，注册写事件
            client = (SocketChannel) key.channel();
            if(client.isConnectionPending()) {
                client.finishConnect();
            }
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_WRITE);
        } else if (key.isReadable()) {
            //2， 客户端可读时，读取从服务端发送过来的数据，然后注册写事件
            client = (SocketChannel) key.channel();
            receiveBuffer.clear();
            count = client.read(receiveBuffer);
            if (count > 0) {
                receiveBuffer.flip();
                String msg = new String(receiveBuffer.array(), 0, receiveBuffer.limit());
                System.out.println("client received msg:" + msg);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (key.isWritable()) {
            //3. 客户端可写时， 向服务端发送数据，并注册读事件
            sendBuffer.clear();
            client = (SocketChannel) key.channel();
            String msg = "msg from client";
            sendBuffer.clear();
            sendBuffer.put(msg.getBytes());
            sendBuffer.flip();
            client.write(sendBuffer);
            client.register(selector, SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.connectedServer("localhost", 8888);
        client.listen(client.getSelector());
    }


    public Selector getSelector() {
        return selector;
    }
}
