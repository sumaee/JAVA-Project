package com.ssafy.fit.util;

import java.util.Scanner;

public class SsafitUtil {
	private static Scanner sc=new Scanner(System.in);
	private SsafitUtil() {}
	public static String input(String msg) {
		System.out.printf("%s : ", msg);
		return sc.nextLine();
	}
	
	public static int inputInt(String msg) {
		System.out.printf("%s : ", msg);
		int num=sc.nextInt();
		sc.nextLine();
		return num;
	}

	public static void printLine() {
		System.out.println("----------------------------------------------");
	}
	
}
