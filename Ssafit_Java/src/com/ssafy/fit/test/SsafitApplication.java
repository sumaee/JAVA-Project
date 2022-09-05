package com.ssafy.fit.test;

import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.user.IUserManager;
import com.ssafy.fit.user.User;
import com.ssafy.fit.user.UserManagerImpl;
import com.ssafy.fit.util.SsafitUtil;

public class SsafitApplication {
	public static void main(String[] args) {
		SsafitUtil.printLine();
		System.out.println("자바로 구현하는 SSAFIT");
		SsafitUtil.printLine();

		while (true) {
			SsafitUtil.printLine();
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 비밀번호 찾기");
			System.out.println("0. 종료");
			SsafitUtil.printLine();
			IUserManager um = UserManagerImpl.getInstance();

			int number = SsafitUtil.inputInt("메뉴를 선택하세요");
			
			if (number == 1) {
				SsafitUtil.printLine();
				String id = SsafitUtil.input("id");
				String pw = SsafitUtil.input("비밀번호");
				if (um.login(id, pw) == true) {
					System.out.println("로그인이 완료되었습니다.");
					MainUi.service();
				} else {
					System.out.println("로그인 실패");
				}
			} else if (number == 2) {
				while (true) {
					SsafitUtil.printLine();
					String name = SsafitUtil.input("이름을 입력하세요");
					String id = SsafitUtil.input("아이디를 입력하세요");
					String pw = SsafitUtil.input("비밀번호를 입력하세요");
					String email = SsafitUtil.input("이메일을 입력하세요");
					
					User tmp = new User(name, id, pw, email);
					if (um.checkId(id) != null) {
						System.out.println("'" + id + "'" + "은 이미 존재하는 아이디입니다.");
					} else {
						um.addUser(tmp);
						System.out.println("회원가입이 완료되었습니다.");
						break;
					}

				}

			} else if (number == 3) {
				SsafitUtil.printLine();
				String name = SsafitUtil.input("이름을 입력하세요");
				if (um.searchByname(name) != null) {
					System.out.println("'" + name + "'" + "님의 비밀번호는 " + um.searchByname(name).getPassword() + "입니다.");
				} else {
					System.out.println("정보가 존재하지 않습니다.");
				}
			} else if (number == 0) {
				return;
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		}
	}
}
