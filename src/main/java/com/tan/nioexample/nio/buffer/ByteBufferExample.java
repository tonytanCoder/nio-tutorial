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
		 * 上界:缓冲区的第一个不能被读或写的元素。或者说，缓冲区中现存元素的计数。
		 */
		buffer.limit();
		
		/**
		 * 位置（Position）:下一个要被读或写的元素的索引。位置会自动由相应的get( )和put( )函数更新。
		 */
		buffer.position();
		/**
		 * 标记（Mark）:一个备忘位置。调用mark( )来设定mark = postion。调用reset( )设定position = mark。标记在设定前是未定义的(undefined)。
		 * 
		 */
		buffer.mark();
	}
	
}
