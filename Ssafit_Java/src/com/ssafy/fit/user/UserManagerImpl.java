package com.ssafy.fit.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserManagerImpl implements IUserManager {
	private List<User> userList = new ArrayList<>();
	private static IUserManager instance = new UserManagerImpl();
	private static User loginUser;

	private UserManagerImpl() {
		Gson gson = new Gson();
		try (BufferedReader reader = new BufferedReader(new FileReader("data/user.json"))) {
			User[] user = gson.fromJson(reader, User[].class);
			for (User u : user) {
				userList.add(u);
			}
		} catch (Exception e) {
			// 내용 없어도 그냥 스킵
		}
	}

	public static IUserManager getInstance() {
		return instance;
	}

	@Override
	public void addUser(User u) {
		userList.add(u);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		User[] user = new User[userList.size()];
		try (FileWriter writer = new FileWriter("data/user.json")) {
			for (int i = 0; i < userList.size(); i++) {
				user[i] = userList.get(i);
			}
			gson.toJson(user, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getListUser() {
		return userList;
	}

	@Override
	public User searchByname(String name) {
		for(User u: userList) {
			if(u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean login(String id, String password) {
		for(User u: userList) {
			if(id.equals(u.getId())&&password.equals(u.getPassword())) {
				loginUser=u;
				return true;
			}
		}
		return false;
	}

	@Override
	public String getLoginName() {
		
		return loginUser.getName();
	}

	@Override
	public User checkId(String id) {
		for(User u: userList) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

}
