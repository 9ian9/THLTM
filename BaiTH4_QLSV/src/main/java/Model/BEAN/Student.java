package Model.BEAN;

import java.time.LocalDate;

public class Student {
	private int id;
	private String name;
	private LocalDate birthday;
	private String gender;
	private String tel;
	private String email;
	private int yearOfStudent;
	private int classId;
	private int accountId;
	public Student(int id, String name, LocalDate birthday, String gender, String tel, String email, int yearOfStudent,
			int classId, int accountId) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.tel = tel;
		this.email = email;
		this.yearOfStudent = yearOfStudent;
		this.classId = classId;
		this.accountId = accountId;
	}
	public Student() {
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYearOfStudent() {
		return yearOfStudent;
	}
	public void setYearOfStudent(int yearOfStudent) {
		this.yearOfStudent = yearOfStudent;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
