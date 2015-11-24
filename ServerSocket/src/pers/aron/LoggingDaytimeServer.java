package pers.aron;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDaytimeServer {

	public final static int PORT = 13;
	private final static Logger auditLogger = Logger.getLogger("requests");
	private final static Logger errorLogger = Logger.getLogger("eros");
	
	
	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try{
					Socket connection = server.accept();
					Callable<Void> task = new DaytimeTask(connection);
					pool.submit(task);
				}catch(IOException ex){
					errorLogger.log(Level.SEVERE,"unexpected error " + ex.getMessage());
				}catch(RuntimeException ex){
					errorLogger.log(Level.SEVERE,"unexpected error " + ex.getMessage());
				}
			}
		}catch(IOException ex){
			errorLogger.log(Level.SEVERE,"Couldn't start server",ex);
		}catch(RuntimeException ex){
			errorLogger.log(Level.SEVERE,"Couldn't start server:" + ex.getMessage());
		}
	}
	
	private static class DaytimeTask implements Callable<Void>{
		private Socket connection;
		
		DaytimeTask(Socket connection){
			this.connection = connection;
		}
		
		@Override
		public Void call(){
			try{
				Date now = new Date();
				//先写入日志记录以防万一客户断开连接
				auditLogger.info(now + " " + connection.getRemoteSocketAddress());
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				
				out.write(now.toString() + "\r\n");
				out.flush();
			}catch(IOException ex){
				//从客户端断开，忽略
			}finally{
				try{
					connection.close();
				}catch(IOException ex){
					
				}
			}
			return null;
		}	
	}
}
