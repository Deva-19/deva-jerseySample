package com.ofs.service;

import java.util.List;

import com.ofs.dao.LoginDao;
import com.ofs.dao.LoginDaoImpl;
import com.ofs.exception.SQLException;
import com.ofs.model.LoginModel;

/**
 * LoginService class that implements the methods of LoginService interface
 * 
 * @author devasena.s
 *
 */
public class LoginServiceImpl implements LoginService {

	LoginDao logindao = new LoginDaoImpl();

	/* LoginDao logindao; */
	/**
	 * method for creating new user
	 * 
	 * @throws SQLException
	 */
	public String createUser(LoginModel user) throws SQLException {

		LoginModel exsistingUserName = logindao.findUserByUserName(user.getUsername());
		
		if (exsistingUserName == null)
			return logindao.createUser(user);
		else
			throw new SQLException("User Name Already Exists!!! Please Provide Unique User Name");
	}

	/**
	 * method for getting particular user details
	 */
	public List<LoginModel> getUser() {

		return logindao.getUser();
	}

	/**
	 * method for deleting particular user
	 */
	public String deleteUser(int userId) {

		return logindao.deleteUser(userId);
	}

	/**
	 * method to update user details
	 */
	public String updateUser(LoginModel user) {

		return logindao.updateUser(user);
	}

	/**
	 * getters and setters for service test class
	 * 
	 * @return
	 */
	public LoginDao getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}

}
