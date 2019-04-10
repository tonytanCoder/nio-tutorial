package com.tan.nioexample.javaniotutorial.buffers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**用于以字节方式读取字符流或文件
 * @author LS-0323
 *
 */
public class ByteBufferExample {
 public static void main(String[] args) throws FileNotFoundException {
	 RandomAccessFile aFile;
	try {
		/*aFile = new RandomAccessFile("E://insert.sql", "rw");
		 FileChannel inChannel = aFile.getChannel();
		 ByteBuffer buf = ByteBuffer.allocate(48);
		 inChannel.read(buf);*/
		 
		 aFile = new RandomAccessFile("E://insert.sql", "rw");
		 FileChannel inChannel = aFile.getChannel();
		 //create buffer with capacity of 48 bytes
		 ByteBuffer buf = ByteBuffer.allocate(48);
		 /*
		 ByteBuffer.allocateDirect(12);*/
		 
		 int bytesRead = inChannel.read(buf); //read into buffer.
		 while (bytesRead != -1) {

		   buf.flip();  //make buffer ready for read

		   while(buf.hasRemaining()){
		       System.out.print((char) buf.get()); // read 1 byte at a time
		   }

		   buf.clear(); //make buffer ready for writing
		   bytesRead = inChannel.read(buf);
		 }
		 aFile.close();
		 
		 
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
