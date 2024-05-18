package Model.BEAN;

public class Teacher {
	private int id;
	private String name;
	private int faculityId;
	private String email;
	public Teacher(int id, String name, int faculityId, String email) {
		super();
		this.id = id;
		this.name = name;
		this.faculityId = faculityId;
		this.email = email;
	}
	public Teacher() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFaculityId() {
		return faculityId;
	}
	public void setFaculityId(int faculityId) {
		this.faculityId = faculityId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
