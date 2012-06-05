package cn.therichcity.entity;

import java.util.Date;

public abstract class BaseEntity {
	private Date lastUpdateTime;

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
