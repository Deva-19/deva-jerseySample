package com.ofs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.ofs.exception.SQLException;
import com.ofs.model.LoginModel;
import com.ofs.service.LoginService;
import com.ofs.service.LoginServiceImpl;

@Path("/user")
/**
 * UserAuthenticationController class is a rest layer to perform CRUD operations
 * 
 * @author devasena.s
 *
 */
public class LoginController {

	LoginService loginservice = new LoginServiceImpl();

	/**
	 * post call for creating a user
	 * 
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	@POST
	@Path("/createUser")
	@Produces("application/json")
	public String createUser(LoginModel user) throws SQLException {
		try {
			return loginservice.createUser(user);
		} catch (SQLException e) {
			
			throw new SQLException(e.toString());
		}
	}

	/**
	 * get call to get a particular user by passing user Id in pathParam
	 * 
	 * @param userID
	 * @return
	 */
	@GET
	@Path("/getUser")
	@Produces("application/json")
	public Response getUser() {
		Response response = null;
		List<LoginModel> userDetails = new ArrayList<LoginModel>(); 
		try{
		userDetails = loginservice.getUser();
		ResponseBuilder responsebuilder = Response.status(Status.OK);
		response = responsebuilder.entity(userDetails).build();
		}
		catch (Exception e){
			Response.ok().entity(e).build();
		}
		return response;
	}

	/**
	 * delete call to delete a particular user by passing the user Id through
	 * pathParam
	 * 
	 * @param userId
	 * @return
	 */
	@DELETE
	@Path("/{userId}")
	@Produces("application/json")
	public String deleteUser(@PathParam("userId") int userId) {
		return loginservice.deleteUser(userId);
	}

	/**
	 * put call to update the user details
	 * 
	 * @param user
	 * @return
	 */
	@PUT
	@Path("/updateUser")
	@Produces("appliation/json")
	public String updateUser(LoginModel user) {
		return loginservice.updateUser(user);
	}
	
}
