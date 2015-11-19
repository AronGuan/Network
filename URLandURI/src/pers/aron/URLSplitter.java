package pers.aron;
import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {

  public static void main(String args[]) {

    for (int i = 0; i < args.length; i++) {
      try {
        URL u = new URL(args[i]);
        System.out.println("The URL is " + u); //URL
        System.out.println("The scheme is " + u.getProtocol()); //协议        
        System.out.println("The user info is " + u.getUserInfo()); //口令(在协议和@之间)
        
        String host = u.getHost();
        if (host != null) {
          int atSign = host.indexOf('@');  
          if (atSign != -1) host = host.substring(atSign+1);
          System.out.println("The host is " + host);   //主机
        } else {          
          System.out.println("The host is null.");   
        }

        System.out.println("The port is " + u.getPort()); //端口
        System.out.println("The path is " + u.getPath()); //路径和文件部分(包含查询字符串)
        System.out.println("The ref is " + u.getRef()); //片段
        System.out.println("The query string is " + u.getQuery());  //查询字符串
      } catch (MalformedURLException ex) {
        System.err.println(args[i] + " is not a URL I understand.");
      }
      System.out.println();
    }
  }
}