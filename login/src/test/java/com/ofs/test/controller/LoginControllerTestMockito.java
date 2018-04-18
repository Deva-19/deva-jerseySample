/*package com.ofs.test.controller;

import javax.ws.rs.ext.Provider;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import junit.framework.Assert;

import com.ofs.controller.LoginController;
import com.ofs.service.LoginService;

public class LoginControllerTestMockito extends JerseyTest {

	LoginService loginservice = Mockito.mock(LoginService.class);
	List expectedValue = new ArrayList();
	private int userId;

	@Override
	public WebAppDescriptor configure() {
		return new WebAppDescriptor.Builder()
				.initParam(WebComponent.RESOURCE_CONFIG_CLASS, ClassNamesResourceConfig.class.getName())
				.initParam(ClassNamesResourceConfig.PROPERTY_CLASSNAMES,
						LoginController.class.getName() + ";" + MockServiceProvider.class.getName())
				.build();
	}

	@Provider
	public class MockServiceProvider extends SingletonTypeInjectableProvider {
		public MockServiceProvider() {
			super(LoginService.class, loginservice);
		}
	}

	@Before
	public void SetUp() {
		Mockito.reset(loginservice);
		when(loginservice.getUser(userId)).thenReturn(expectedValue);
		expectedValue.add("DevasenaS");
		expectedValue.add("devsen");
	}

	@Test
	public void LoginControllerTestCase() throws JSONException {
		WebResource webResource = client().resource("http://localhost:8080/");
		JSONArray userDetail = webResource.path("/login/rest/user/getUser/2").get(JSONArray.class);
		Assert.assertEquals(expectedValue.get(0), userDetail.getJSONObject(0).getString("fullname"));
		Assert.assertEquals(expectedValue.get(1), userDetail.getJSONObject(0).getString("username"));

	}

}*/