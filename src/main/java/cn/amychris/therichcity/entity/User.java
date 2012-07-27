package cn.amychris.therichcity.entity;

import java.util.Date;

public class User extends BaseEntity implements Cloneable {
	private Long	uuid;
	private String	name;
	private String	password;
	private String	email;
	private Long	score;
	private Date	registerDate;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid( Long uuid ) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public Long getScore() {
		return score;
	}

	public void setScore( Long score ) {
		this.score = score;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate( Date registerDate ) {
		this.registerDate = registerDate;
	}

	@Override
	public Object clone() {
		User copy = new User();

		copy.email = this.email;
		copy.name = this.name;
		copy.password = this.password;
		copy.registerDate = this.registerDate;
		copy.score = this.score;
		copy.uuid = this.uuid;

		return copy;
	}

}
