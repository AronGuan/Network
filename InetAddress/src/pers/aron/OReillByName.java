package pers.aron;

import java.net.InetAddress;
import java.net.UnknownHostException;
//
public class OReillByName {

	public static void main(String[] args){
		try {
			//查找名字和ip地址
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);
			InetAddress address1 = InetAddress.getByName("www.oreilly.com");
			System.out.println(address1.getHostName());
			InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
			for(InetAddress addr:addresses){
				System.out.println(addr);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
