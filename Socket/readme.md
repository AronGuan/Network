#Socket  
С����  
1. ��Socket�ӷ�������ȡ  

2. ��Socketд�������  

��ر�Socket  
shutdownInput()  
shutdownOutput()  

���������  
```
ʹ��λ��myproxy.example.com��Socks�������������������login.ibiblio.org
		SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com",1080);
		Proxy proxy = new Proxy(Proxy.Type.SOCKS,proxyAddress);
		Socket s = new Socket(proxy);
		SocketAddress remote = new InetSocketAddress("login.ibiblio.org",25);
		s.connect(remote);
```
