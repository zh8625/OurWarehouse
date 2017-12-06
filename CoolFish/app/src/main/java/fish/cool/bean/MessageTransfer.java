package fish.cool.bean;

import java.util.Date;

public class MessageTransfer {
	
	//��Ϣ��ת
	private Integer mid;//����
	
	private Integer fromuid;//����Ϣ���û�
	
	private Integer touid;//����Ϣ���û�
	
	private String message;//��Ϣ
	
	private Date mdate;//ʱ��
	
	

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

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}


}
