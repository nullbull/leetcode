package study.nettylearn.nettyl.niosocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author niuzhenhao
 * @date 2020/9/28 13:49
 * @desc
 */

public class NioServer extends AbstractNIO {


    private static final int BUFFER_SIZE = 2048;

    private ByteBuffer sendBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    private ByteBuffer receiveBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    private Selector selector;



    public void openServer(int port) throws IOException{
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.bind(new InetSocketAddress(port));
        selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("start server on port:" + port);

    }

    @Override
    void handlerKey(SelectionKey key) throws IOException {
        ServerSocketChannel server;
        SocketChannel client;
        int count;

        if (key.isAcceptable()) {
            //1. 服务端启动后，先注册读事件，等待客户端输入
            server = (ServerSocketChannel) key.channel();
            client = server.accept();
            if (client != null) {
                client.configureBlocking(false);
                client.register(selector, SelectionKey.OP_READ);
            }

        } else if (key.isReadable()) {
            //2. 当服务端可读时，读取客户端输入，然后注册写事件
            client = (SocketChannel) key.channel();
            receiveBuffer.clear();
            count = client.read(receiveBuffer);
            if (count > 0) {
                receiveBuffer.flip();
                String msg = new String(receiveBuffer.array(), 0, receiveBuffer.limit());
                System.out.println("server received msg:" + msg);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (key.isWritable()) {
            //3. 当服务端可写时，向客户端发送数据，然后注册读事件
            sendBuffer.clear();
            client = (SocketChannel) key.channel();
            String msg = "msg from server";
            sendBuffer.put(msg.getBytes());
            sendBuffer.flip();
            client.write(sendBuffer);
            client.register(selector, SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8888;
        NioServer nioServer = new NioServer();
        nioServer.openServer(port);
        nioServer.listen(nioServer.getSelector());
    }

    public Selector getSelector() {
        return selector;
    }
}
