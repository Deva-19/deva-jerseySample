package com.ofs.dao;

import java.util.List;

import com.ofs.model.LoginModel;

/**
 * interface for LoginDaoImpl class
 * @author devasena.s
 *
 */
public interface LoginDao {

	public String createUser(LoginModel user);

	public List<LoginModel> getUser();

	public String deleteUser(int userId);

	public String updateUser(LoginModel user);

	public LoginModel findUserByUserName(String username);

}
