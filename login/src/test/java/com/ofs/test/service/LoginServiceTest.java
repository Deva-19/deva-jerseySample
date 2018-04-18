package com.ofs.test.service;

import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.Assert;

import com.ofs.dao.LoginDao;
import com.ofs.exception.SQLException;
import com.ofs.model.LoginModel;
import com.ofs.service.LoginServiceImpl;

public class LoginServiceTest {
	LoginServiceImpl loginservice;
	LoginDao logindao;
	private int userId;
	private String result;
	private LoginModel user;
	private String createdUser;
	private String expectedUser;
	private List<LoginModel> actualValue;
	private List<LoginModel> expectedValue;

	@Before
	public void SetUp() {

		logindao = Mockito.mock(LoginDao.class);
		when(logindao.deleteUser(userId)).thenReturn("deleted");
		when(logindao.createUser(user)).thenReturn(createdUser);
		//when(logindao.getUsers(userId)).thenReturn(actualValue);
		loginservice = new LoginServiceImpl();
		loginservice.setLogindao(logindao);
	}

	@Test
	public void loginServiceTestClass() throws SQLException {

		result = loginservice.deleteUser(userId);
		expectedUser = loginservice.createUser(user);
		//expectedValue = loginservice.getUsers(userId);
		Assert.assertNull(logindao);
		Assert.assertEquals("deleted", result);
		Assert.assertEquals(expectedUser, createdUser);
		Assert.assertEquals(expectedValue, actualValue);
	
	}
}
