package Models.Entity;

import java.sql.Date;

public class E_Room {
	private int id;
	private String CheckIn;
	private String CheckOut;
	private int Adults;
	private int Kids;
	private int Status;
	private int RoomNo;
	private String RequestMadeBy;
	private Date dateNtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}
	public String getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}
	public int getAdults() {
		return Adults;
	}
	public void setAdults(int adults) {
		Adults = adults;
	}
	public int getKids() {
		return Kids;
	}
	public void setKids(int kids) {
		Kids = kids;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public String getRequestMadeBy() {
		return RequestMadeBy;
	}
	public void setRequestMadeBy(String requestMadeBy) {
		RequestMadeBy = requestMadeBy;
	}
	public Date getDateNtime() {
		return dateNtime;
	}
	public void setDateNtime(Date dateNtime) {
		this.dateNtime = dateNtime;
	}
	public E_Room(int id, String checkIn, String checkOut, int adults, int kids, int status, int roomNo,
			String requestMadeBy, Date dateNtime) {
		this.id = id;
		CheckIn = checkIn;
		CheckOut = checkOut;
		Adults = adults;
		Kids = kids;
		Status = status;
		RoomNo = roomNo;
		RequestMadeBy = requestMadeBy;
		this.dateNtime = dateNtime;
	}
	public E_Room() {}
}
