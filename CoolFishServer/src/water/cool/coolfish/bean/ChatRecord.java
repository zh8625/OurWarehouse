package water.cool.coolfish.bean;

import java.util.Date;

public class ChatRecord {
	//ÁÄÌì¼ÇÂ¼
	private Integer cid;
	
	private Integer fromuid;
	
	private Integer touid;
	
	private String message;
	
	private String cdate;
	
	

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getFromuid() {
		return fromuid;
	}

	public void setFromuid(Integer fromuid) {
		this.fromuid = fromuid;
	}

	public Integer getTouid() {
		return touid;
	}

	public void setTouid(Integer touid) {
		this.touid = touid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	

}
