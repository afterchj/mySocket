package com.tpadsz.mysocket.chapter12;

import java.util.*;
import java.io.*;

public class PropertyReader {
  static private Properties ps;

  static{
    ps=new Properties();
    try{
      InputStream in=new FileInputStream(new File("C:\\workspace\\mySocket\\target\\classes\\db.conf"));
//      InputStream in=PropertyReader.class.getResourceAsStream("classes/db.conf");
      ps.load(in);
      in.close();
    }catch(Exception e){e.printStackTrace();}
  }

  public static String get(String key){
     return (String)ps.get(key);
  }
}
