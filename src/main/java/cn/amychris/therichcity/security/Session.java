package cn.amychris.therichcity.security;

import java.util.Date;

import cn.amychris.therichcity.entity.UserEntity;

public class Session {

	private String sessionID;
	
	private UserEntity user;
	
	private Date startTime;

	Date getStartTime() {
		return startTime;
	}

	void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getSessionID() {
		return sessionID;
	}

	void setUser(UserEntity user) {
		this.user = user;
	}

	void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public UserEntity getUser() {
		return user;
	}

	
}
