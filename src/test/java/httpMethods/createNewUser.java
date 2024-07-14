package httpMethods;

import org.testng.annotations.Test;
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



public class createNewUser {
//  @Test(priority=1)
//  
//	  public void createNewUSer() {
//		  PojoData data=new PojoData();
//		  data.setName("Mani");
//		  data.setJob("Automation");
//		  
//	  given()
//	 .contentType("application/json")
//		.body(data)
//	  .when().post("https://reqres.in/api/users")
//	  .then()
//	  .statusCode(201)
//	  .log().body();
//	  
//  }
//  @Test(priority=2)
//public void DeleteRequest() {
//	  
//	  
//	  given()
//	 
//              .when()
//	  .delete("https://reqres.in/api/users/2")
//	 
//                 .then()
//	  .statusCode(204)
//	  .log().all();
//	  
//}
//  @Test(priority=3)
//  public void listOfUsers() {
//
//		given()
//		
//	            .when().get("https://reqres.in/api/users?page=1")
//		
//	            .then()
//		.statusCode(200)
//	            .log().body();
//
//	}
  @Test(priority=4)
  public void OAuth2() {
	  
      given()
.auth().oauth2("12345")

       .when().get("https://postman-echo.com")

       .then()
.statusCode(200)


      .log().body();

    System.out.println("OAuth-2  token Authentication is completed"); 

}



}
