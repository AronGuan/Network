package pers.aron;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PooledWeblog {

	private final static int NUM_THREADS = 4;
	
	public static void main(String[] args) throws IOException {
	    ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
	    Queue<LogEntry> results = new LinkedList<LogEntry>();
	    
	    try (BufferedReader in = new BufferedReader(
	      new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
	      for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
	    	//为每一行创建一个LookupTask
	    	LookupTask task = new LookupTask(entry);
	        Future<String> future = executor.submit(task);
	        LogEntry result = new LogEntry(entry, future);
	        //存储在队列中
	        results.add(result);
	      }
	    }
	    
	    // 开始打印结果，每次结果未准备就绪时就会阻塞，按顺序打印
	    for (LogEntry result : results) {
	      try {
	        System.out.println(result.future.get());
	      } catch (InterruptedException | ExecutionException ex) {
	        System.out.println(result.original);
	      }
	    }
	    //关闭
	    executor.shutdown();
	  }
	
	private static class LogEntry {

		String original;
		Future<String> future;
		
		public LogEntry(String original, Future<String> future) {
			this.original = original;
			this.future = future;
		}
			
	}
}
