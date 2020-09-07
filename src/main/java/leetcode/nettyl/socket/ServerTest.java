package leetcode.nettyl.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author niuzhenhao
 * @date 2020/9/2 15:12
 * @desc
 */

public class ServerTest {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(8001);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(in.readLine());
            //注意 写入的数据 需要带着\n
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("hello, this is server");
        }

//        serverSocket.close();


    }
}
