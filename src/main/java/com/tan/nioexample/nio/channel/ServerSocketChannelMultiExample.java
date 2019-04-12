package com.tan.nioexample.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelMultiExample {
 public static void main(String[] args) throws IOException {
	ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
	Selector selector=Selector.open();
	serverSocketChannel.socket().bind(new InetSocketAddress(9999));
	serverSocketChannel.configureBlocking(false);
	serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	
	Thread accept= new Thread(new Runnable() {
		@Override
		public void run() {
			while(true){
				SocketChannel socketChannel;
				try {
					socketChannel = serverSocketChannel.accept();
					/*System.out.println("socketChannel"+socketChannel);*/
					if(socketChannel!=null){
						System.out.println("accept channel");
						socketChannel.configureBlocking(false);
						socketChannel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	});
	accept.start();

	
	Thread read= new Thread(new Runnable() {
		@Override
		public void run() {
			while(true){
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
				while(keyIterator.hasNext()) {
				    SelectionKey key = keyIterator.next();
				    if(key.isAcceptable()) {
				        // a connection was accepted by a ServerSocketChannel.
				    	System.out.println("a connection was accepted by a ServerSocketChannel");
				    } else if (key.isConnectable()) {
				        // a connection was established with a remote server.

				    } else if (key.isReadable()) {
				        // a channel is ready for reading
				    	System.out.println("a channel is ready for reading");
				    	SocketChannel channel=(SocketChannel) key.channel();
				    	try {
				    		byteBuffer.clear();
							channel.read(byteBuffer);
							System.out.println(new String(byteBuffer.array()));
						} catch (IOException e) {
							e.printStackTrace();
						}
				    } else if (key.isWritable()) {
				        // a channel is ready for writing
				    	System.out.println("a channel is ready for writing");
				    }

				    keyIterator.remove();
				}
			}
		}
	});
	
	read.start();
}
}
