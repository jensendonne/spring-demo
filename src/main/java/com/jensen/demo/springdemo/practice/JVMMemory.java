package com.jensen.demo.springdemo.practice;

public class JVMMemory {

	public static void stringCompare() {
		String str1 = new StringBuilder("刘雅丽").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("董").append("正生").toString();
		System.out.println(str2.intern() == str2);
		System.out.println(str2.intern() == str2);

		String str3 = new StringBuilder("董正").append("生").toString();
		System.out.println();
		System.out.println(str3.intern() == str3);
		System.out.println(str3.intern() == str2);
		System.out.println(str3 == str2);
		System.out.println();

		String str4 = new StringBuilder("ja").append("va").toString();
		System.out.println(str4.intern() == str4);
	}

	public static void main(String[] args) {
		stringCompare();
	}

}
