##����1  
�ö��̵߳ķ�ʽ�ҳ�һ���ܴ�����������е����ֵ  

��ϰ����:Future Callable��Exceutor������  

1. ʵ��Callable�ӿڣ�ʵ��call()����  
```
public class FindMaxTask implements Callable<Integer>

```  

2. �����߳�  
```
//����2���߳�
		ExecutorService service = Executors.newFixedThreadPool(2);
```  

3. ��ExecutorService�ύ����  
```
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
```  

4. ���ؽ��  
```
return Math.max(future1.get(), future2.get());
```  
future1.get():���û����֮ǰ��������  

##����2  
����GZIOutputStream�Ե�ǰĿ¼�е�ÿһ���ļ����gzipѹ����  

pool.shutdown();  
������ֹ�ȴ��Ĺ�������ֻ��֪ͨ�̳߳���û�и���������Ҫ���ӵ������ڲ����У�����һ��������еȴ��Ĺ�������Ӧ���رա�


