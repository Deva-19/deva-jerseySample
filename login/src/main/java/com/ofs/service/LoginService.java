package com.ofs.service;

import java.util.List;

import com.ofs.exception.SQLException;
import com.ofs.model.LoginModel;

/**
 * interface for LoginService implementation class 
 * @author devasena.s
 *
 */
public interface LoginService {

	public String createUser(LoginModel user) throws SQLException;

	public List<LoginModel> getUser();

	public String deleteUser(int userId);

	public String updateUser(LoginModel user);
}
