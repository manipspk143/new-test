package APITest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

/*given ()-PreRequsite

 * ------------
 * headers/cookies/path/query/param/requestPayload(resource)/Authentication
 * 
 * when ()-Send Request
 * -----------
 * GET/POST/PUT/PATCH/DELETE
 * 
 * then ()-Validate Response
 * -----------
 * Status code/responsePayload/responseMsg
 * 
 *Methods
 *equalTo()-test quality for data
 *hasItems()->check all elements are in a collection
 * contains->check all elements are in a collection are in a strict order
 * 
 * 
 * */
//restassured site on click on static imports copt that and paste
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.junit.Assert;

//get all cookies
public class Cookies {
  @Test
  public void getallCookies() {
	  //without response method
	  given()
	  
	  .when()
	  .get("https://www.google.com/")
	  .then()
	  .statusCode(200)
	  .log().cookies(); 
  }
  
  //single cookie with a validation part also //it is a response from the request and it is a validation part it is not used in then method
  
  @Test
  public void SingleCookie() {
	 Response res= given()
	  .when()
	  .get("https://www.google.com/");
	 String actvalue= res.getCookie("AEC");
	 System.out.println(actvalue);
	 String exp="AQTF6HwJ1NGbd_DJb4-uEK5rkA-8ZS57nclFfTjokpPSS9EcVZxmExUW1g";
	 
	 //validation as are cookies are dynamic that should not be same
	 Assert.assertFalse("TestFails:as values for cookies are same",actvalue.contains(exp)); 
	 System.out.println("Test Pass:As cookies values are different");
  }
  
 // get all cookies with key pair and value pair
  @Test
  public void getSetofCookies() {
	  Response res= given()
	  
	  .when()
	  .get("https://www.google.com");
	  Map<String,String>map=res.getCookies();
	  System.out.println(map);
	  
	  //iteration
	  for(Map.Entry<String,String>i:map.entrySet()) {
		  System.out.println(i.getKey() + ":" + i.getValue());
	  }

  }
}
