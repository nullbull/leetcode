package study.leetcode.nettyl.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author niuzhenhao
 * @date 2020/9/2 15:14
 * @desc
 */

public class ClientTest {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("0.0.0.0", 8001);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.write("hello, this is client\r\n");
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(in.readLine());


        socket.close();


    }
}
