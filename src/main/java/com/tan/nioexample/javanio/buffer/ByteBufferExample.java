package com.tan.nioexample.javanio.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteBufferExample {
	
	/**
	 * 不同的字符所占的字节是不同的。
	 * 
	 * ASCII码：
	 * 
	 * 一个英文字母（不分大小写）占一个字节的空间，一个中文汉字占两个字节的空间。一个二进制数字序列，在计算机中作为一个数字单元，一般为8位二进制数，
	 * 换算为十进制。最小值0，最大值255。如一个ASCII码就是一个字节。
	 * 
	 * UTF-8编码：
	 * 
	 * 一个英文字符等于一个字节，一个中文（含繁体）等于三个字节。
	 * 
	 * Unicode编码：
	 * 
	 * 一个英文等于两个字节，一个中文（含繁体）等于两个字节。
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	
	public static void main(String[] args) throws UnsupportedEncodingException {
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
