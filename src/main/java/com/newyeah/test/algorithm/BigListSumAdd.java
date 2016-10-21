package com.newyeah.test.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 大集合List<Integer>求和，SIZE>1亿
 * @Author LiuYang
 * @Date 2016年10月21日
 * @Description : 
 *
 */
public class BigListSumAdd {
	private static List<Integer> bigList = new ArrayList<Integer>() ;
	static {
		long curTime = System.currentTimeMillis() ;
		for(int i=0;i<10000000;i++){
			bigList.add(i) ;
		}
		System.out.println("初始BIGLIST费时毫秒："+(curTime = System.currentTimeMillis() - curTime));
	}
	public static List<Integer> getBigList(){
		List<Integer> bigList = new ArrayList<Integer>() ;
		long curTime = System.currentTimeMillis() ;
		for(int i=0;i<10000000;i++){
			bigList.add(i) ;
		}
		System.out.println("初始BIGLIST费时毫秒："+(curTime = System.currentTimeMillis() - curTime));
		return bigList ;
	}
	public static void main(String[] args) {
		long sum = 0 ;
		long curTime = System.currentTimeMillis() ;
		for(Integer i : bigList){
			sum += i ;
		}
		System.out.println(sum);
		System.out.println("BIGLIST求和费时毫秒："+(curTime = System.currentTimeMillis() - curTime));
	}
}
