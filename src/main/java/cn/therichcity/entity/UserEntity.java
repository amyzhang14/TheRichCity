package cn.therichcity.entity;

import java.math.BigInteger;
import java.util.Date;

public class UserEntity extends BaseEntity {
	private BigInteger uuid;
	private String name;
	private String password;
	private String email;
	private Long score;
	private Date registerDate;

	public BigInteger getUuid() {
		return uuid;
	}

	public void setUuid(BigInteger uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
