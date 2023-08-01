package ru.netology.model;

import ru.netology.authority.Authorities;
import java.util.List;
import java.util.Collections;

public class Account {
	private long userId;
	private String user;
	private String password;
	private List<Authorities> authorities;
	//private List<Authorities> authorities  = Collections.emptyList();  

	public Account(String user, String password) {
		this.userId = 0;
		this.user = user;
		this.password = password;
		this.authorities  = Collections.emptyList();  
	}

	public Account(long userId, String user, String password, List<Authorities> authorities) {
		this.userId = userId;
		this.user = user;
		this.password = password;
		this.authorities = authorities;
	}

	public long getUserId() {
		return userId;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "{ " + userId + " " + user + " " + authorities + " }";
	}
}
