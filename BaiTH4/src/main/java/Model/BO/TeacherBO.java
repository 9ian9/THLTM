package Model.BO;


public class TeacherBO {
	private int id;
	private String name;
	private String email;
	private int faculityId;
	private int accountId;
	
	public TeacherBO() {
		
	}
	
	public TeacherBO(int id, String name, String email, int faculityId, int accountId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.faculityId = faculityId;
		this.accountId = accountId;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getFaculityId() {
		return this.accountId;
	}
	
	public void setFaculityId(int faculityId) {
		this.faculityId = faculityId;
	}
	
	public int getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
