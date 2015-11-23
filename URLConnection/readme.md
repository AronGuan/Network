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
