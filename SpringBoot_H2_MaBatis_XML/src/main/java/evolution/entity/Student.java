package evolution.entity;

public class Student {
	private int id;
	private String gender;
	private String name;
	private int courseId;
	
	public int getCourseId() {
		return courseId;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", gender=" + gender + ", name=" + name + ", courseId=" + courseId + "]";
	}
}
