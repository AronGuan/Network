package pers.aron;

import java.net.InetAddress;
//����ַ�Ƿ���һ����֪�������ʼ�������
public class SpamCheck {

	public static final String BLACKHOLE = "sbl.spamhaus.org";
	
	public static void main(String[] args){
		for(String arg:args){
			if(isSpammer(arg)){
				System.out.println(arg + " is a known spammer.");
			}else{
				System.out.println(arg + " appears legitimate.");
			}
		}
	}
	//��ʽ����������  ip��ַ+"sbl.spamhaus.org",�ɹ����ص�ַ,�������ʼ������ߣ�ʧ���׳�UnknownHostException,�Ͳ��������ʼ�������
	private static boolean isSpammer(String arg){
		try{
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for(byte octet : quad){
				int unsignedByte = octet < 0 ? octet + 256 : octet; //�Ѹ�������ġ�
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
