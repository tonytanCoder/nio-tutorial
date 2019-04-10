package com.tan.nioexample.jenkov.tutorials.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelExample {
 public static void main(String[] args) throws IOException {
	 ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
	 SocketChannel socketChannel=SocketChannel.open();
	 socketChannel.connect(new InetSocketAddress("localhost", 8080));
     socketChannel.write(ByteBuffer.wrap("pingpong".getBytes()));
     socketChannel.read(byteBuffer);
     while (byteBuffer.hasRemaining()) {
         System.out.println(byteBuffer.get());                   
      }
 }
 
 
 public static ByteBuffer putStringBuf(ByteBuffer byteBuffer,String content){
	 byteBuffer.clear();
	 byte[] bytes=content.getBytes();
	 byteBuffer.put(bytes);
	 return byteBuffer;
 }
 
}
