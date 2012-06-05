package cn.therichcity.dao.hbm;

import java.math.BigInteger;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.therichcity.dao.UserDao;
import cn.therichcity.entity.UserEntity;

/*
 * @author Zhang Yanxia
 * 
 */

public class UserDaoHbm implements UserDao {

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getByEmail(String email) {

		if (null == email) {
			throw new NullPointerException("email cann't be null.");
		}
		
		UserEntity user = new UserEntity();
		user.setEmail(email);
		List<UserEntity> list = (List<UserEntity>) this.hibernateTemplate.findByExample(user);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int insert(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BigInteger uuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
