#URLConnection  
С����:SourceViewer2:��URLConnection����һ��webҳ��  

��ȡ�ײ��ֶ�  
getContentType():��ȡContent-type��  
getContentLength():��ȡContent-length.  
getContentEncoding():��ȡContent-encoding.  
getDate():��ȡDate,ָ���ĵ���ʱ����  
getExpriation():Expires��ָ��Ӧ����ʱ�ӻ�����ɾ���ĵ���
getLastModified():last-modified,�����ĵ������޸����ڡ�  

��ȡ�����ײ��ֶ�  
getHeaderField(String name):����ָ���ֶε�ֵ��  
getHeaderFieldKey(int n):���ص�n���ײ��ֶεļ���  
getHeaderFieldField(int n):���ص�n���ײ��ֶε�ֵ��  

���ÿͻ�������HTTP�ײ�  
1. setRequestProperty(String name,String value)  
2. addRequestProperty(String name,String value)
