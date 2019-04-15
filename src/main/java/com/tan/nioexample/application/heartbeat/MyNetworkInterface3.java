package com.tan.nioexample.application.heartbeat;

import java.net.NetworkInterface;
import java.util.Enumeration;
/**
 * 得到本机所有的网络接口
 * @author LS-0323
 *
 */
public class MyNetworkInterface3 {
	  public static void main(String[] args) throws Exception
	    {
	        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
	        while (nis.hasMoreElements())
	            System.out.println(nis.nextElement());
	    }
}
