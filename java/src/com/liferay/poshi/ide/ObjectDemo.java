package com.liferay.poshi.ide;

public class ObjectDemo {

	public ObjectDemo(String username, String password) {
		_password = password;
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public String getUsername() {
		return _username;
	}

	private String _password;
	private String _username;
}