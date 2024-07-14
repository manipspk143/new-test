package httpMethods;

import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest_OlderWay {
  @Test
  public void singleUserGetRequest() {
	 Response res= RestAssured.get("https://reqres.in/api/users?page=2");
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getStatusLine());
	  System.out.println(res.getTime());
	  
	  int Actcode=res.getStatusCode();
	  Assert.assertEquals(Actcode, 200,"Assert fail:Status code should not be matched");
	  System.out.println("Assert Pass:Status code should be matched with 200");
  }
}
