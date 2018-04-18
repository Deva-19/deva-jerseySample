/*package com.ofs.test.controller;

import static org.junit.Assert.assertEquals;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class LoginControllerTest extends JerseyTest {

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder("com.ofs.controller").build();
	}

	public LoginControllerTest() {
		super("com.ofs.controller");
	}

	@Test
	public void testUser() throws JSONException {

		WebResource webResource = client().resource("http://localhost:8080/");
		JSONArray userDetail = webResource.path("/login/rest/user/getUser/2").get(JSONArray.class);
		assertEquals("DevasenaS", userDetail.getJSONObject(0).getString("fullname"));
	}

}*/