package APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
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

public class HeadersTest {
  @Test
  public void getallheaders() {
	  
	  given()
	  .when()
	  .get("https://www.google.com")
	  .then()
	  .log().headers();  
  }
  
  //Single header it is a response from the request and it is a validation part it is not used in then method
  @Test
  public void SingleHeader() {
	 Response res=given()
	  .when()
	  .get("https://www.google.com");
	 String header= res.getHeader("Content-Type");
	  System.out.println(header);
	  
	  //validation
	  Assert.assertEquals(header,"text/html; charset=ISO-8859-1","Test fail:The header does not matched");
	  System.out.println("Test pass:The header is matched");
	 
  }
  @Test
  public void TestHeaders() {
		 Response res=given()
		  .when()
		  .get("https://www.google.com");
		Headers hd=res.getHeaders();
		  System.out.println(hd);
		  
  }}
