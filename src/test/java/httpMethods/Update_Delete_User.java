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


public class Update_Delete_User {
  @Test
  public void UpdateRequest() {
	  
	  //Payload
	  PojoData data=new PojoData();
	  data.setName("Mani");
	  data.setJob("Developer");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  .when().put("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log().body();
	   }
  
  @Test
  public void DeleteRequest() {
	  
	  
	  given()
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(204);
  }
}
