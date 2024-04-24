package api.testsForRegister;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpointsforRegister.RegisterEndPoint;
import api.payloadForRegister.Register;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterTest {

	Faker faker;
	Register registerPayload;
	
	
//	@BeforeTest
//	public void setUp()
//	{
//		faker = new Faker();
//		registerPayload =new Register();
//		
//		registerPayload.setFname(faker.name().firstName());
//		registerPayload.setLname(faker.name().lastName());
//		registerPayload.setEmail(faker.internet().emailAddress());
//		registerPayload.setPassword(faker.internet().password(5,10));
//		
//	}
	
	
	//test for one request using faker
//	@Test
//	public void testForOneUser()
//	{
//
//		   faker = new Faker();
//
//		    Map<String, Object> data = new HashMap<>();
//		    data.put("fname", faker.name().firstName());
//		    data.put("lname", faker.name().lastName());
//		    data.put("email", faker.internet().emailAddress());
//		    data.put("password", faker.internet().password(5, 10));
//
//		    given()
//		        .contentType("application/json")
//		        .body(data)
//		    .when()
//		        .post("https://2829-2402-8100-31b8-3061-69e2-f32b-ec86-199b.ngrok-free.app/register")
//		    .then()
//		        .statusCode(200)
//		        .header("Content-Type", "application/json;charset=utf-8")
//		        .log().all();
//		}
		

	
	//test for one request but manually
//	@Test
//	public void createUserWithCustomObject_thenSuccess() {
//	    Map<String, Object> data = new HashMap<>();
//	    data.put("fname", "Scott");
//	    data.put("lname", "Shetty");
//	    data.put("email", "scott@gmail.com");
//	    data.put("password", "2345");
//
//	    given()
//	        .contentType("application/json")
//	        .body(data)
//	    .when()
//	  //need to be changed everytime when want to execute
//	        .post("https://2829-2402-8100-31b8-3061-69e2-f32b-ec86-199b.ngrok-free.app/register")
//	    .then()
//	        .statusCode(200)
////	        .body("fname", equals("Scott"))
////	        .body("lname", equals("Shetty"))
////	        .body("email", equals("scott@gmail.com"))
////	        .body("password", equals("2345"))
//	        .header("Content-Type", "application/json;charset=utf-8")
//	        .log().all();
//	}
	


	//test for multiple Api Requests in parallel
@Test
public void testMultipleeApiRequestsInParallel() throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newFixedThreadPool(5); // Create a fixed thread pool with 5 threads

  //need to be changed everytime when want to execute
    String apiUrl = "https://f848-2402-8100-31b8-3061-9535-f8b9-383a-7f11.ngrok-free.app/register";
    List<Map<String, Object>> requestDataList = new ArrayList<>();

    Faker faker = new Faker();
    for (int i = 0; i < 150; i++) {
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("fname", faker.name().firstName());
        requestData.put("lname", faker.name().lastName());
        requestData.put("email", faker.internet().emailAddress());
        requestData.put("password", faker.internet().password());
        requestDataList.add(requestData);
    }

  //callable helsp in parrallel execution
    List<Callable<Response>> tasks = new ArrayList<>();

    for (Map<String, Object> requestData : requestDataList) {
        tasks.add(() -> makeeApiRequest(apiUrl, requestData));
    }

  //future helps in checking computation of the task ,if not done waits for its completion and then retriev its result
    List<Future<Response>> futures = executor.invokeAll(tasks);

    for (Future<Response> future : futures) {
        Response response = future.get(5, TimeUnit.SECONDS); // Wait for 5 seconds for the task to complete
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json;charset=utf-8");
        System.out.println("API response: " + response.asString());
    }

    executor.shutdown();
}

private Response makeeApiRequest(String url, Map<String, Object> data) {
    return given()
            .contentType("application/json")
            .body(data)
            .when()
            .post(url)
            .then()
            .extract()
            .response();
}
}

