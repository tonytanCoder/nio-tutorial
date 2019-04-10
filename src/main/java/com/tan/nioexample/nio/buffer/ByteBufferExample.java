package com.tan.nioexample.nio.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteBufferExample {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 容量:可以存储的数据大小
		 */
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		/**
		 * 存取
		 */
		String str=new String("tanzl");
		System.out.println(str.getBytes().length);
		buffer.put(str.getBytes());
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		
		buffer.flip();
		System.out.println((char)buffer.get());
		
		System.out.println((char)buffer.get(0));
		/*buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');*/
		buffer.rewind();
		/**
		 * Limit =不得读取或写入的元素的索引。
		 */
		System.out.println(buffer.limit());
		/**
		 * Position =要读取或写入的下一个元素的索引。
		 */
		System.out.println(buffer.position());
        System.out.println((char)buffer.get());
		
		System.out.println((char)buffer.get(0));
		buffer.clear();
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
	}
	
}
