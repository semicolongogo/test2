package sist.com.dto;

public class Scrab1 {
	private int no;
	private String id;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Scrab1 [no=" + no + ", id=" + id + "]";
	}
	public Scrab1(int no, String id) {
		super();
		this.no = no;
		this.id = id;
	}
	public Scrab1() {
		super();
	}
	
	

}
