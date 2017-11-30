package water.cool.coolfish.bean;

import java.util.Date;

public class MessageTransfer {
	
	//消息中转
	private Integer mid;//主键
	
	private Integer fromuid;//发消息的用户
	
	private Integer touid;//收消息的用户
	
	private String message;//信息
	
	private String mdate;//时间
	
	

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
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

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}


	
	
	

}
