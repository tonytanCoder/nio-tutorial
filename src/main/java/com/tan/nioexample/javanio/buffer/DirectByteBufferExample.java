package com.tan.nioexample.javanio.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


public class DirectByteBufferExample {
 public static void main(String[] args) throws IOException {
	 /**
	  * 2M内存
	  */
	   ByteBuffer tbuffer=ByteBuffer.allocateDirect(2*1024*1024);
	 
		long startTime = new Date().getTime();

		Path path = Paths.get("e://TAccountBalanceOnthewayMapper.xml");
		FileChannel fileChannel = FileChannel.open(path);

		ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
		
		/*ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);*/

		System.out.println("Is a direct buffer: " + buffer.isDirect());
		System.out.println("Buffer has a backing array: " + buffer.hasArray());
		System.out.println("Reading file... ");

		int noOfBytesRead = fileChannel.read(buffer);
   
		for (int i = 0; i < 25; i++) {

			while (noOfBytesRead != -1) {
				String content = new String(buffer.array());
				System.out.println(content);
				buffer.clear();
				noOfBytesRead = fileChannel.read(buffer);
			}

			buffer.clear();
			fileChannel.position(0);
			noOfBytesRead = fileChannel.read(buffer);
		}

		fileChannel.close();

		long endTime = new Date().getTime();
		System.out.println("");
		System.out.println("Time taken (millis): " + (endTime - startTime));

	}
}
