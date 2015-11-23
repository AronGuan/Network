package pers.aron;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SourceViewer2 {

	public static void main(String[] args){
		if(args.length>0){
			try{
				//打开URLConnection进行读取
				URL u = new URL(args[0]);
				URLConnection uc = u.openConnection();
				try(InputStream raw = uc.getInputStream()){  //自动关闭
					InputStream buffer = new BufferedInputStream(raw);
					//将InputStream串链到一个Reader
					Reader reader = new InputStreamReader(buffer);
					int c;
					while((c = reader.read()) != -1){
						System.out.println((char)c);
					}
				}
			}catch(MalformedURLException e){
				System.err.println(args[0] + "is not parseable URL");
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
	}
}
