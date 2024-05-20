package Model.BEAN;

public class Grade {
	private int id;
	private String name;
	private int faculityId;
	public Grade(int id, String name, int faculityId) {
		super();
		this.id = id;
		this.name = name;
		this.faculityId = faculityId;
	}
	public Grade() {
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
	
}
