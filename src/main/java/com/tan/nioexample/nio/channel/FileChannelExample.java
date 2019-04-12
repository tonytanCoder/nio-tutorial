package com.tan.nioexample.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class FileChannelExample {
 public static void main(String[] args) throws IOException {
	 RandomAccessFile aFile = new RandomAccessFile("e://TAccountBalanceOnthewayMapper.xml","rw");
	 FileChannel inChannel = aFile.getChannel();
	/* Path inpath = Paths.get("e://TAccountBalanceOnthewayMapper.xml");
	 FileChannel.open(inpath, StandardOpenOption.READ);*/
	 System.out.println(inChannel.size()/1024);
	 
}
}
