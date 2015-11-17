package pers.aron;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Weblog {

	  public static void main(String[] args) {
		    try (FileInputStream fin =  new FileInputStream(args[0]);
		     Reader in = new InputStreamReader(fin);
		    		BufferedReader bin = new BufferedReader(in);) {
		      
		      for (String entry = bin.readLine(); entry != null;entry = bin.readLine()) {
		        // 切分ip地址
		        int index = entry.indexOf(' ');
		        String ip = entry.substring(0, index);
		        String theRest = entry.substring(index);
		        
		        // 请求DNS来查找主机名并且打印
		        try {
		          InetAddress address = InetAddress.getByName(ip);
		          System.out.println(address.getHostName() + theRest);
		        } catch (UnknownHostException ex) {
		          System.err.println(entry);
		        }
		      }
		    } catch (IOException ex) {
		      System.out.println("Exception: " + ex);
		    }
		  }
}
