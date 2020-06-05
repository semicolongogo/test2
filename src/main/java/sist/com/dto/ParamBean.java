package sist.com.dto;

public class ParamBean {
	private String msg;
	private int no;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "ParamBean [msg=" + msg + ", no=" + no + "]";
	}
	public ParamBean(String msg, int no) {
		super();
		this.msg = msg;
		this.no = no;
	}
	public ParamBean() {
		super();
	}
	
}
