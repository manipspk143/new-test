package APITest;

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


public class Authenticationtypes {
  @Test(priority=1)
  public void BasicAuth() {
	  //Base64algorithm it is internally used by basic algorithm
	  //it is nothing but encrypted and decrypted form
	  //it is client  send the request to the server the server response to the client
	  given()
	  .auth().basic("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().body();
	  System.out.println("Basic Authentication is completed"); 
  }
  
  @Test (priority=2)
  public void DigestAuth() {
	//Base MD5 (MesageDigest)algorithm it is internally used by Digest algorithm 
	  //it is same as basic but little bit secret
	  //it is nothing but encrypted and decrypted form
	  //it is client  send the request to the server the server response to the client
	  
	  given()
	  .auth().digest("postman","password")
	  .when().get("https://postman-echo.com/digest-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().body();
	  System.out.println("Digest Authentication is completed"); 
	    
  }
  @Test (priority=3)
  public void BearerAuth() {
	//Base MD5 (MesageDigest)algorithm it is internally used by Digest algorithm 
	  //it is client  send the request to the server the server generates token to send the client the client pass the token to the server it is validate to acess the application
	  //it is nothing but token generating
	  given()
	  .header("Authorization","Bearer 12345")
	  .when().get("https://postman-echo.com")
	  .then()
	  .statusCode(200)
	  .log().body();
	  System.out.println("Bearer  token Authentication is completed"); 
	  
  }
  @Test (priority=4)
  public void BearergorestPutAuth() {
	  //gorets.co.in token updating
	  given()
	  .header("Authorization","Bearer 883b955aff22a398bec4b41028d5d4a90deff3e0533d732b7a7d9e580ef5af98")
	  .when().put("https://gorest.co.in/public/v2/users/6940117")
	  .then()
	  .statusCode(200)
	  .log().body();
	  System.out.println("Bearer gorest.co.in put token Authentication is completed"); 
	  
  }
  
  @Test (priority=5)
  public void BearergorestgetAuth() {
	  //gorets.co.in token updating
	  given()
	 .header("Authorization","Bearer 883b955aff22a398bec4b41028d5d4a90deff3e0533d732b7a7d9e580ef5af98")
	  .when().get("https://gorest.co.in/public/v2/users/6940117")
	  .then()
	  .statusCode(200)
	  .log().body();
	  System.out.println("Bearer gorest.co.in  get token Authentication is completed"); 
	  
  }

  @Test (priority=6)
  public void OAuth2() {
	  //OAuth 2 means open authorization and authentication and it is more secure than others authorizations
	  //it is a small process it is additionally form in authorization server the user send the request the authorization server receive and generate the token to the application
	// it means any web site  direct login google thats called simple o auth 2 authorization 
	  //OAuth 1 is a very large process and it is used in 2 tokens like temporary token and main token it is between 3 users are formed like user client server
	 //the tokens are generating successfully its granted a permission otherwise not allowed
	  given()
	  .auth().oauth2("12345")
	  .when().get("https://postman-echo.com")
	  .then()
	  .statusCode(200)
	  
	  .log().body();
	  System.out.println("OAuth-2  token Authentication is completed"); 
	  
  }

 }






