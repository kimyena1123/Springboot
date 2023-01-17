package com.yena.test.jsp.model;

import java.util.Date;

public class Seller {
	private int id;
	private String nickname;
	private String temperature;
	private String profileImgae;
	private Date createdAt;
	private Date updatedAt;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getProfileImgae() {
		return profileImgae;
	}
	public void setProfileImgae(String profileImgae) {
		this.profileImgae = profileImgae;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
