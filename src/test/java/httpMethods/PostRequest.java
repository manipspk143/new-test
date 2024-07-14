package httpMethods;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PostRequest {
  @Test
  public void PostwithHashMap(){
	  //payload request
	  HashMap<String,Object>data=new HashMap<String,Object>();
	  data.put("name","Mani");
	  data.put("job","Tester");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  .when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .body("name",equalTo("Mani"))
	  .log().body();  
  }
  
  @Test
  public void Post_Pojo(){
	  
	  //pojo means  create a class is private and the class is accepted to create the object like inheritance conecpt like
	  //create the object
	  PojoData data=new PojoData();
	  data.setName("Mani");
	  data.setJob("QA");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  .when().post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	 .body("job",equalTo("QA"))
	 .body("name",equalTo("Mani"))
	 
	  .log().body();
	 
	  System.out.println(data.getName());
	  System.out.println(data.getJob());
	  Assert.assertTrue(data.getName().equals("Mani"),"Assert fail:Name is not matching");
	 System.out.println("Assert pass:Name is matching");
  }
}
