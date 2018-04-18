/*package com.ofs.test.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ofs.dao.LoginDao;
import com.ofs.dao.LoginDaoImpl;
import com.ofs.service.LoginService;
import com.ofs.service.LoginServiceImpl;

public class ControllerTestExample {
	
	URI BASE_URI = getBaseUri();
	private HttpServer server;

	private URI getBaseUri() {
		return UriBuilder.fromUri("http://localhost").port(8080).build();
	}

	@Before
	public void startServer() throws IOException {
		 Injector injector = Guice.createInjector(new ServletModule() {
		@Override
		protected void configureServlets(){
			bind(LoginService.class).to(LoginServiceImpl.class);
			bind(LoginDao.class).to(LoginDaoImpl.class);
		}
	});
		 
		 ResourceConfig rc = new PackagesResourceConfig("ngdemo.rest");
	        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
	        server = GrizzlyServerFactory.createHttpServer(BASE_URI + "rest/", rc, ioc);
	}
	

    @After
    public void stopServer() {
        server.stop();
    }
    
    @Test
    public void testControllerClass(){
    	Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseUri());
        ClientResponse resp = service.path("rest").path("user")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got stuff: " + resp);
        assertEquals(200, resp.getStatus());
    }

}
*/*/