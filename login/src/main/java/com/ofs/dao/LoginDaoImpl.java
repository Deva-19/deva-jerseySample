package com.ofs.dao;

import com.ofs.util.HibernateUtil;

import java.util.List;

import com.ofs.model.LoginModel;

/**
 * Hitting database and  getting the data by creating hibernate query
 * 
 * @author devasena.s
 *
 */
public class LoginDaoImpl implements LoginDao {

	/**
	 * instantiating hibernateUtil class
	 */
	HibernateUtil hibernateUtil = new HibernateUtil();

	public String createUser(LoginModel user) {

		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(user);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "created a new user !!" + user.getFullname() + "email:" + user.getEmail();
		
	}

	public List<LoginModel> getUser() {

		hibernateUtil.openCurrentSession();
		List<LoginModel> userData = (List<LoginModel>) hibernateUtil.getCurrentSession()
				.createQuery("from LoginModel").list();
		hibernateUtil.closeCurrentSession();
		return userData;

	}

	public String deleteUser(int userId) {

		hibernateUtil.openCurrentSession();
		hibernateUtil.getCurrentSession().createQuery("delete from LoginModel where userId = " + userId)
				.executeUpdate();
		hibernateUtil.closeCurrentSession();
		return "deleted";
	}

	public String updateUser(LoginModel user) {
		
		String fullname = user.getFullname();
		int userId = user.getUserId();

		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession()
				.createQuery("update LoginModel set fullname='" + fullname + "' where userId='" + userId + "'")
				.executeUpdate();
		hibernateUtil.getCurrentTransaction().commit();
		return "updated fullname!! Fullname:" + user.getFullname();
	}

	@Override
	public LoginModel findUserByUserName(String username) {
		hibernateUtil.openCurrentSession();
		LoginModel user = (LoginModel)hibernateUtil.getCurrentSession()
				.createQuery("from LoginModel where username='"+ username+"'").uniqueResult();
		hibernateUtil.closeCurrentSession();
		return user;
	}
	
	
}
