package mdaros.labs.spring.boot.contract.testing.service.provider.test.support;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import mdaros.labs.spring.boot.contract.testing.service.provider.ServiceProviderApplication;

@SpringBootTest ( classes = ServiceProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server.port=0" )
@RunWith ( SpringRunner.class )
public class BaseContractVerifier {

	@LocalServerPort
	private int serverPort;

	@Before
	public void before () {

		RestAssured.baseURI = "http://localhost:" + this.serverPort;
	}
}