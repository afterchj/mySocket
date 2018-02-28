package com.tpadsz.mysocket.chapter01;

import java.io.*;
/**
 * Created by hongjian.chen on 2018/2/28.
 */
public class EchoPlayer {
    public String echo(String msg) {
        return "echo:"+msg;
    }
    public void talk()throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while((msg=br.readLine())!=null){
            System.out.println(echo(msg));
            if(msg.equals("bye"))  //当用户输入“bye”，结束程序
                break;
        }
    }

    public static void main(String arg[])throws IOException{
        new EchoPlayer().talk();
    }
}
