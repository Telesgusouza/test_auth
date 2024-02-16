package com.example.demo.entity.enums;

public enum UserRole {

	USER("user"),
	ADMIN("admin");
	
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}
	
	String getRole() {
		return role;
	}
	
}
