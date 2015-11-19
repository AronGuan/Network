package pers.aron;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DMoz {

	public static void main(String[] args){
		String target = "";
		for(int i = 0;i < args.length;i++){
			target += args[i] + " ";
		}
		target = target.trim();
		
		QueryString query = new QueryString();
		query.add("wd", target);
		try{
			URL u = new URL("http://www.baidu.com/s?" + query);
			System.out.println(query);
			try(InputStream in = new BufferedInputStream(u.openStream())){
				InputStreamReader theHTML = new InputStreamReader(in,"utf-8");
				int c;
				while((c = theHTML.read()) != -1){
					System.out.print((char)c);
				}
			}
		}catch (MalformedURLException ex) {
		      System.err.println(ex);
	    } catch (IOException ex) {
	      System.err.println(ex);
	    }
	}
}
