package httpMethods;

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

/// id is created the same id is updated and deleted with these three conditions
public class CreateNew_User {
	String id;
  @Test(priority=1)
  public void createNewUSer() {
	  PojoData data=new PojoData();
	  data.setName("veera");
	  data.setJob("Automation");
	  
	  //json id--------->
	   id=given()
				.contentType("application/json")
				.body(data)
		  .when()
		  .post("https://reqres.in/api/users")
		.jsonPath().get("id");
		
	  System.out.println("User is created id:"+id);
	  
	  
	  
	  //full response
	  //Response is a interface in RestAssured its not creating the object
	  
//	Response res=given()
//			.contentType("application/json")
//			.body(data)
//	  .when()
//	  .post("https://reqres.in/api/users");
//	  
//	//System.out.println(res);
//	System.out.println(res.asString());  
  }
  @Test(priority=2,dependsOnMethods="createNewUSer")
  public void UpdateSameUser() {
	  PojoData data=new PojoData();
	  data.setName("Karthik");
	  data.setJob("Driver");
	  
	  //json id--------->
	   given()
				.contentType("application/json")
				.body(data)
		  .when()
		  .put("https://reqres.in/api/users/"+id)
	   .then()
	   .statusCode(200)
	  .log().body();		
	  System.out.println("User update same id:"+id);
	    
  }
  
  @Test(priority=3,dependsOnMethods="UpdateSameUser")
  public void DeleteSameUser() {
	 
	  given()
	  .when()
.delete("https://reqres.in/api/users/"+id)
.then()
.statusCode(204);
		
System.out.println("User Delete same id:"+id);

	  
  }
}
