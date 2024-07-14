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


public class New_GetRequest {
  @Test(priority=1)
  public void SingleUSerRequest() {
	  
	  //the methods  are not imported it is not working
	  //https://reqres.in/api/users/2
	  
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .body("data.last_name",equalTo("Weaver"))
	  .body("data.email", equalTo("janet.weaver@reqres.in"))
	  .log().all();
	  System.out.println("Single user validation is done !"); 
  }
  
@Test(priority=2)
public void listOfUsers() {
	given()
	.when().get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200)
	
	//it means the page is correct or not
	.body("page",equalTo(2))
	//the id index of the id  is right or not
	.body("data.id[2]",equalTo(9))
	//all id's from json body
	.body("data.id",hasItems(7,8,9,10,11,12))
	//changing the order of items
	.body("data.id",hasItems(10,9,12,8,11,7))
	//Partial ids it means some of ids are mentioned
	.body("data.id",hasItems(8,11,12))
	//contains it allows only order of elements
	.body("data.id",contains(7,8,9,10,11,12))
	.log().body();
	
	
	//it means the page is correct or not
	//.body("Page",equalTo("2"))
	
	//the id index of the id  is right or not
	//.body("data.id[2]",equalTo(9))
	
	//hasItem()->check all elements are in a collection
	//all id's from json body
	//.body("data.id",hasItems(7,8,9,10,11,12));
	
	//changing the order of items
	//.body("data.id",hasItems(10,9,12,8,11,7))
	
	//Partial ids it means some of ids are mentioned
	//.body("data.id",hasItems(8,11,12))
	
	//contains->check all elements are in a collection are in a strict order
	//partial
		//.body("data.id",contains(8,11,12))
			
		//order not matched
		//.body("data.id",contains("10,9,12,8,11,7"))

	//contains it allows only order of elements
	//it not allows partial elements and changing of elements not allowed
        //.body("data.id",contains(7,8,9,10,11,12))
	
	//partial
	//.body("data.id",contains("8,11,12"))
		
	//order not matched
	//.body("data.id",contains("10,9,12,8,11,7"))
	
	
}
}
