package cn.amychris.therichcity.security;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;

/*
 * @author Chen Haoming
 */
public interface SecurityManager {

	/*
	 * Verify that if user has login, with Session(sessionID).
	 * @param user -- <code>UserEntity</code>
	 * @param sessionID -- <code>String</code>
	 * @return List of Security Messages, or null if verify successfully.
	 */
	List<SecurityMessage> verifyUser(UserEntity user, String sessionID);
	
	/*
	 * Login a user.
	 * @param user <code>UserEntity</code>
	 * @return the <code>Session</code> that this user login to.
	 */
	Session login(UserEntity user);
	
	/*
	 * Logout and end the <code>Session</code>
	 * @param gameSession <code>Session</code>
	 */
	void logout(Session session);
}
