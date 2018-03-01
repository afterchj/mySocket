import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2018/03/01.
 */
public class SMTPMain {
    public static void main(String[] args) {
        String sender = "18170756879@163.com";
        String receiver = "after@tpadsz.com";
        String password = "auth001";
        String user = new BASE64Encoder().encode(sender.substring(0, sender.indexOf("@")).getBytes());
        String pass = new BASE64Encoder().encode(password.getBytes());
        try {
            Socket socket = new Socket("smtp.163.com", 25);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);  //我TM去 这个true太关键了!
            System.out.println(reader.readLine());
            //HELO
            writer.println("HELO huan");
            System.out.println(reader.readLine());
            //AUTH LOGIN
            writer.println("auth login");
            System.out.println(reader.readLine());
            writer.println(user);
            System.out.println(reader.readLine());
            writer.println(pass);
            System.out.println(reader.readLine());
            //Set mail from   and   rcpt to
            writer.println("mail from:<" + sender +">");
            System.out.println(reader.readLine());
            writer.println("rcpt to:<" + receiver +">");
            System.out.println(reader.readLine());

            //Set data
            writer.println("data");
            System.out.println(reader.readLine());
            writer.println("subject:来自SMPT问候socket...");
            writer.println("from:" + sender);
            writer.println("to:" + receiver);
            writer.println("Content-Type: text/plain;charset=\"utf-8\"");
            writer.println();
            writer.println("女神，晚上可以共进晚餐吗？");
            writer.println(".");
            writer.println("");
            System.out.println(reader.readLine());

            //Say GoodBye
            writer.println("rset");
            System.out.println(reader.readLine());
            writer.println("quit");
            System.out.println(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
