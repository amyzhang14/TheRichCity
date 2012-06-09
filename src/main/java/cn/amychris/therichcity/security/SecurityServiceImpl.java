package cn.amychris.therichcity.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.util.StringUtil;

public class SecurityServiceImpl implements SecurityService {

	private Map<UserEntity, Session> loginMap;

	private int maxLoginUsers;

	public SecurityServiceImpl(int maxLoginUsers) {
		this.maxLoginUsers = maxLoginUsers;
		loginMap = new HashMap<UserEntity, Session>();
	}

	@Override
	public List<SecurityMessage> verifyUser(UserEntity user, String sessionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session login(UserEntity user) {
		if (null == user) {
			throw new NullPointerException("User could not be null.");
		}

		if (loginMap.containsKey(user)) {
			throw new SecurityServiceException("User(" + user.toString() + ") has already logined.");
		}

		Session s;
		synchronized (loginMap) {
			if (loginMap.size() == maxLoginUsers) {
				throw new ExceedingMaxLoginUsersException("The maximum number of users can login is " + maxLoginUsers);
			}

			s = new Session();
			loginMap.put(user, s);
		}

		s.setSessionID(StringUtil.generateRandomUUID());
		s.setUser(user);
		s.setStartTime(new Date());
		return s;
	}

	@Override
	public void logout(Session session) {
		// TODO Auto-generated method stub

	}

}
