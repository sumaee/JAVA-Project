package com.ssafy.fit.ui;

import com.ssafy.fit.util.SsafitUtil;

public class MainUi {
	public static void service() {
		while(true) {
			SsafitUtil.printLine();
			System.out.println("1. 영상 정보");
			System.out.println("0. 로그아웃");
			SsafitUtil.printLine();
			int number=SsafitUtil.inputInt("메뉴를 선택하세요");
			if(number==1) {
				while(true) {
					SsafitUtil.printLine();
					System.out.println("1. 영상 목록");
					System.out.println("0. 이전으로");
					SsafitUtil.printLine();
					int n= SsafitUtil.inputInt("메뉴를 선택하세요");
					if(n==1) {
						VideoUi.getInstance().service();
					}else if(n==0) {
						break;
					}else {
						System.out.println("잘못된 입력입니다.");
					}
				}
			}
			else if(number==0) {
				System.out.println("안전하게 로그아웃되었습니다.");
				return;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
			
			
			
		}
	}
}
