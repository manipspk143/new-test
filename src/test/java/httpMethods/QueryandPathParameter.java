package httpMethods;

import org.testng.annotations.Test;

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


public class QueryandPathParameter {
  @Test
  public void PathQueryParameters() {
	  
//	  https://reqres.in/api           /users             ?page=2
	  //Protocol:domain resource       PathParameter       QueryParameter 
	  //pathquery means it is a header section so write in given
	 
	  given()
	  .pathParam("path","users")
	  .queryParam("page","2")
	  
	  .when()
	  .get("https://reqres.in/api/{path}")
	  
	  .then()
	  .statusCode(200)
	  .log().body();
	
  }
}
