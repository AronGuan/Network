#URLConnection  
小程序:SourceViewer2:用URLConnection下载一个web页面  

获取首部字段  
getContentType():获取Content-type。  
getContentLength():获取Content-length.  
getContentEncoding():获取Content-encoding.  
getDate():获取Date,指出文档何时发送  
getExpriation():Expires，指出应当何时从缓存中删除文档。
getLastModified():last-modified,返回文档最后的修改日期。  

获取任意首部字段  
getHeaderField(String name):返回指定字段的值。  
getHeaderFieldKey(int n):返回第n个首部字段的键。  
getHeaderFieldField(int n):返回第n个首部字段的值。  

配置客户端请求HTTP首部  
1. setRequestProperty(String name,String value)  
2. addRequestProperty(String name,String value)

向服务器写入数据  
setDoOutput(true),然后使用getOutputStream()方法  

小程序:将查询字符串写入到输出流。然后返回包含服务器响应的输入流。  
使用Post方法   

HttpURLConnection用于处理http URL  
GET  
POST  
HEAD  
PUT  
DELETE  
OPTIONS  
TRACE  

设置请求方法  
public void setRequestMethod()
