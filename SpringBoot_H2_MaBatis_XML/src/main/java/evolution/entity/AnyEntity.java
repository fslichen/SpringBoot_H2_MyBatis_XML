package evolution.entity;

public class AnyEntity {
	private int id;
	private String name;
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AnyEntity [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
}
