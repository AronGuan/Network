获取方法  
getHostName():主机名和ip地址  
getCanonicalHostName()：同上，不过都会联系DNS,知道主机名  
byte[] getAddress() ：返回ip地址的byte数组，可以通过length属性知道是IPV4还是IPv6 
getHostAddress()：返回ip地址  

##测试可达性  
isReachable(int timeout)  


两个小程序  
1. 检查地址是否是一个已知的垃圾邮件发送者(SpamCheck)  
2. (1)通过离线处理日志文件来提升Web服务器的性能(直白点就是把ip地址转换成主机名)(Weblog)  
    (2)利用线程池的方式实现(LookupTast,PooledWeblog)
