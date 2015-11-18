##程序1  
用多线程的方式找出一个很大的数组数组中的最大值  

练习内容:Future Callable和Exceutor的运用  

1. 实现Callable接口，实现call()方法  
```
public class FindMaxTask implements Callable<Integer>

```  

2. 创建线程  
```
//创建2个线程
		ExecutorService service = Executors.newFixedThreadPool(2);
```  

3. 向ExecutorService提交任务  
```
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
```  

4. 返回结果  
```
return Math.max(future1.get(), future2.get());
```  
future1.get():结果没出来之前会阻塞。  

##程序2  
运用GZIOutputStream对当前目录中的每一个文件完成gzip压缩。  

pool.shutdown();  
不会终止等待的工作，它只是通知线程池在没有更多任务需要增加到它的内部队列，而且一旦完成所有等待的工作，就应当关闭。


