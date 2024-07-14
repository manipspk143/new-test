package httpMethods;

public class PojoData {
	/*POJO=Plain Old Java Object
	 * it follows Encapsulation principle using getter and setter methods
	 * Encapsulation=Private data+ Public function
*/
	private String name;
	private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
