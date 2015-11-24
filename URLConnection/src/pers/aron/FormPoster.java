package pers.aron;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//�ύһ����
public class FormPoster {

	private URL url;
	
	private QueryString query = new QueryString();
	public FormPoster(URL url){
		if(!url.getProtocol().toLowerCase().startsWith("http")){
			throw new IllegalArgumentException(""
					+ "Posting only works for http URLs");
		}
		this.url = url;
	}
	
	public void add(String name,String value){
		query.add(name,value);
	}
	
	public URL getURL(){
		return this.url;
	}
	
	public InputStream post() throws IOException{
		//�����ӣ�׼��POST
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);
		try(OutputStreamWriter out
				= new OutputStreamWriter(uc.getOutputStream(),"UTF-8")){
			//post�У�Content-type�ײ���Content-length�ײ�
			//��URLConnection����
			//����ֻ��Ҫ�������ݡ�
			System.out.println(query.toString());
			out.write(query.toString());
			out.write("\r\n");
			out.flush();
		}
		//������Ӧ
		return uc.getInputStream();
	}

	public static void main(String[] args) {
		URL url;
		if(args.length > 0){
			try{
				url = new URL(args[0]);
			}catch(MalformedURLException ex){
				System.err.println("Usage:java FormPoster url");
				return;
			}
		}else{
			try{
				url = new URL(
						"http://www.cafeaulait.org/books/jnp4/postquery.phtml");
			}catch(MalformedURLException ex){ //��Ӧ�÷���
				System.err.println(ex);
				return;
			}
		}
		
		FormPoster poster = new FormPoster(url);
		poster.add("name", "Elliotte Rusty Harold");
		poster.add("email", "elharo@ibiblio.org");
		
		try(InputStream in = poster.post()){
			//��ȡ��Ӧ
			Reader r = new InputStreamReader(in,"utf-8");
			int c;
			while((c = r.read()) != -1){
				System.out.print((char)c);
			}
			System.out.println();
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
