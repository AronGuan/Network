#URL��URI    
URL(URL base,String relative):����ǹ������URL  

##��ȡ����  
1. openStream():����һ��InputStream,���Զ�ȡ���ݣ����Ǽٶ�URLָ���ı������Բ���֪����ȡ�����͡�  
2. openConnection():����URLConnection���󣬿��Է��ʷ��������͵��������ݣ�Ҳ���Է������ݡ�  
3. getContent():����ĳ�����͵Ķ���  
4. getContent(Class[] classes)  


URL�����Ƕ�Ӧ�����ȡ��Ӧ�ò�Э���һ����ʾ����URI���󴿴����ڽ����ʹ����ַ�����

URLEncoder���URLDecode�࣬���ԶԸ�ʽ���б���  

URLEncoder��:�Ƚϻ�����������з���ĸ�����ַ�ת����%����(���˿ո��»��ߣ����ַ�����ţ��Ǻ��ַ�����)�����Բ��ʺ�һ���԰�URL�����ȥ��  

������URLDecoder��,����x-www-form-url-encoded��ʽ������ַ������б��롣  
URLDecoder.decode(URL,"utf-8")  

С����  
DMoz:ͨ��URL����ύ��ѯ���ݣ�����ȡ�������ݡ�