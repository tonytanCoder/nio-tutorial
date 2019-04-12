package com.tan.nioexample.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelExample {
 public static void main(String[] args) throws IOException {
	 ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
	SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("localhost", 9998));
	/*socketChannel.configureBlocking(false);*/
/*	socketChannel.connect(new InetSocketAddress("localhost", 9999));*/
   while(socketChannel.isConnected()){
	   byteBuffer.clear();
	   socketChannel.write(byteBuffer.put("pingpong".getBytes()));
   }
 }
}
