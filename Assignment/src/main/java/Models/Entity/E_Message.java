package Models.Entity;

public class E_Message {
	
	private int id;
	private String message;
	private String senderName;
	private String Email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public E_Message(int id, String message, String senderName, String email) {
		this.id = id;
		this.message = message;
		this.senderName = senderName;
		Email = email;
	}
	public E_Message() {}
}
