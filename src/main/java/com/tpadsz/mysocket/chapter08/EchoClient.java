package com.tpadsz.mysocket.chapter08;

import java.net.*;
import java.io.*;
public class EchoClient {
  private String remoteHost="192.168.51.75";
  private int remotePort=8000;
  private DatagramSocket socket;

  public EchoClient()throws IOException{
    socket=new DatagramSocket(); //与本地的任意一个UDP端口绑定
  }
  public static void main(String args[])throws IOException{
    new EchoClient().talk();
  }
  public void talk()throws IOException {
    try{
      InetAddress remoteIP=InetAddress.getByName(remoteHost);
      System.out.println(remoteIP.getHostName()+":"+remoteIP.getHostAddress());

      BufferedReader localReader=new BufferedReader(new InputStreamReader(System.in));
      String msg;
      while((msg=localReader.readLine())!=null){
        byte[] outputData=msg.getBytes();
        DatagramPacket outputPacket=new DatagramPacket(outputData, outputData.length,remoteIP,remotePort);
        socket.send(outputPacket);  //给EchoServer发送数据报

        DatagramPacket inputPacket=new DatagramPacket(new byte[512],512);
        socket.receive(inputPacket);
        System.out.println(new String(inputPacket.getData(),0,inputPacket.getLength()));
        if(msg.equals("bye"))
          break;
      }
    }catch(IOException e){
      e.printStackTrace();
    }finally{
      socket.close();
    }
  }
}
