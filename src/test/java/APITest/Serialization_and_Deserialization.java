package APITest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import httpMethods.PojoData;

/*
 * Serialization-It is a conversion of java object to JSON
 * Deserialization-It is conversion of JSON to java object
 * */

public class Serialization_and_Deserialization {
  @Test
  public void Serializationtest() throws JsonProcessingException {
	  PojoData data=new PojoData();
	  data.setName("Mani");
	  data.setJob("Automation");
	  
	  ObjectMapper mapper=new ObjectMapper(); 
	  String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	  System.out.println(json);
  }
  @Test
  public void DeSerialization() throws JsonMappingException, JsonProcessingException{
		String jsondata="{\n"
				+ "  \"name\" : \"Mani\",\n"
				+ "  \"job\" : \"Automation\"\n"
				+ "}";
		 ObjectMapper mapper=new ObjectMapper(); 
		 PojoData data=mapper.readValue(jsondata,PojoData.class);
	System.out.println(data.getName());	
	System.out.println(data.getJob());
  
}
}