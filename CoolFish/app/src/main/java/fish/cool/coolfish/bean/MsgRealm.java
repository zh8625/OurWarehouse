package fish.cool.coolfish.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MsgRealm extends RealmObject{
	public static final int TYPE_RECRIVED=0;
	public static final int TYPE_SENT=1;

	@PrimaryKey
	private int mid;
	private String content;
	private int type;


	public MsgRealm() {
	}

	public MsgRealm(String content, int type){
		this.content=content;
		this.type=type;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
