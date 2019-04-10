package com.tan.nioexample.jenkov.tutorials.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelExample {
 public static void main(String[] args) throws IOException {
	 ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
	 ServerSocketChannel serversocketChannel=ServerSocketChannel.open();
	 serversocketChannel.bind(new InetSocketAddress(8080));
	 while(true){
		 SocketChannel sc =
				 serversocketChannel.accept();
		 sc.read(byteBuffer);
		  String response = new String(byteBuffer.array()).trim();
		  System.out.println("response=" + response);
	 }
 }
 
}
