package com.tpadsz.mysocket.chapter02.auth;

import sun.misc.BASE64Encoder;

import java.net.*;
import java.io.*;

public class MailSenderWithAuth {

    public static void main(String[] args) {
        new MailSenderWithAuth().sendMail();
    }

    public void sendMail() {

        String sender = "18170756879@163.com";
        String receiver = "after_hj@163.com";
        String password = "auth001";
        String user = new BASE64Encoder().encode(sender.substring(0, sender.indexOf("@")).getBytes());
        String pass = new BASE64Encoder().encode(password.getBytes());

        Socket socket = null;
        try {
            socket = new Socket("smtp.163.com", 25);
            BufferedReader reader = getReader(socket);
            PrintWriter writer = getWriter(socket);
            sendAndReceive("",reader);
            //HELO
            writer.println("HELO huan");
            sendAndReceive("HELO huan",reader);
            //AUTH LOGIN
            writer.println("auth login");
            sendAndReceive("auth login",reader);
            writer.println(user);
            sendAndReceive(user,reader);
            writer.println(pass);
            sendAndReceive(pass,reader);
            //Set mail from   and   rcpt to
            writer.println("mail from:<" + sender + ">");
            sendAndReceive("mail from:<" + sender + ">",reader);
            writer.println("rcpt to:<" + receiver + ">");
            sendAndReceive("rcpt to:<" + receiver + ">",reader);

            //Set data
            writer.println("data");
//            sendAndReceive(reader);
            writer.println("subject:来自SMPT问候socket...");
            writer.println("from:" + sender);
            writer.println("to:" + receiver);
            writer.println("Content-Type: text/plain;charset=\"utf-8\"");
            writer.println();
            writer.println("女神，晚上可以共进晚餐吗？");
            writer.println(".");
            writer.println("");
            sendAndReceive("data",reader);

            //Say GoodBye
            writer.println("rset");
            sendAndReceive("rset",reader);
            writer.println("quit");
            sendAndReceive("quit",reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送一行字符串，并接收一行服务器的响应数据
     */
    private void sendAndReceive(String str, BufferedReader br) throws IOException {
        System.out.println("Client>" + str);
        System.out.println("Server>" + br.readLine());
    }



    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

}