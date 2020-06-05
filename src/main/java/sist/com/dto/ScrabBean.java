package sist.com.dto;

public class ScrabBean {
	private int no;
	private String id;
	private String subject;
	private String author;
	private String contents;
	private int hit;
	private String fileName;
	private String regdate;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFilename(String fileName) {
		this.fileName = fileName;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ScrabBean [no=" + no + ", id=" + id + ", subject=" + subject + ", author=" + author + ", contents="
				+ contents + ", hit=" + hit + ", fileName=" + fileName + ", regdate=" + regdate + "]";
	}
	public ScrabBean(int no, String id, String subject, String author, String contents, int hit, String fileName,
			String regdate) {
		super();
		this.no = no;
		this.id = id;
		this.subject = subject;
		this.author = author;
		this.contents = contents;
		this.hit = hit;
		this.fileName = fileName;
		this.regdate = regdate;
	}
	public ScrabBean() {
		super();
	}
	

}
