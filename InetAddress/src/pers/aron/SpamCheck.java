package pers.aron;

import java.net.InetAddress;
//检查地址是否是一个已知的垃圾邮件发送者
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
	//方式查找主机名  ip地址+"sbl.spamhaus.org",成功返回地址,是垃圾邮件发送者，失败抛出UnknownHostException,就不是垃圾邮件发送者
	private static boolean isSpammer(String arg){
		try{
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for(byte octet : quad){
				int unsignedByte = octet < 0 ? octet + 256 : octet; //把负变成正的。
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
