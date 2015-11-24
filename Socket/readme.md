#Socket  
小程序  
1. 用Socket从服务器读取  

2. 用Socket写入服务器  

半关闭Socket  
shutdownInput()  
shutdownOutput()  

代理服务器  
```
使用位于myproxy.example.com的Socks代理服务器来连接主机login.ibiblio.org
		SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com",1080);
		Proxy proxy = new Proxy(Proxy.Type.SOCKS,proxyAddress);
		Socket s = new Socket(proxy);
		SocketAddress remote = new InetSocketAddress("login.ibiblio.org",25);
		s.connect(remote);
```
获取Socket信息  
getInetAddress():远程地址  
getPort():远程端口  
getLocalAddress():本地地址  
getLocalPort():本地端口
