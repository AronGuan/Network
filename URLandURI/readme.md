#URL和URI    
URL(URL base,String relative):这个是构造相对URL  

##获取数据  
1. openStream():返回一个InputStream,可以读取数据，但是假定URL指向文本，所以不能知道读取的类型。  
2. openConnection():返回URLConnection对象，可以访问服务器发送的所有数据，也可以发送数据。  
3. getContent():返回某种类型的对象  
4. getContent(Class[] classes)  


URL对象是对应网络获取的应用层协议的一个表示，而URI对象纯粹用于解析和处理字符串。

URLEncoder类和URLDecode类，可以对格式进行编码  

URLEncoder类:比较积极，会对所有非字母数字字符转换成%序列(除了空格，下划线，连字符，点号，星号字符以外)，所以不适合一次性把URL传入进去。  

所以用URLDecoder类,对用x-www-form-url-encoded格式编码的字符串进行编码。  
URLDecoder.decode(URL,"utf-8")  

小程序  
DMoz:通过URL向表单提交查询数据，并获取返回数据。