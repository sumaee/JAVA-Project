package com.ssafy.fit.user;

import java.util.List;

public interface IUserManager {
	void addUser(User u);
	List<User> getListUser();
	User searchByname(String name);
	boolean login(String id, String password);
	String getLoginName();
	User checkId(String id);
}
