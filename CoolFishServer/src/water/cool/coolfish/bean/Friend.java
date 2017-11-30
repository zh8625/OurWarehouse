package water.cool.coolfish.bean;

public class Friend {
	//好友表
	private Integer fid;//主键
	
	private Integer fuido;//用户1(两人互为好友)
	
	private Integer fuidt;//用户2(两人互为好友)

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getFuido() {
		return fuido;
	}

	public void setFuido(Integer fuido) {
		this.fuido = fuido;
	}

	public Integer getFuidt() {
		return fuidt;
	}

	public void setFuidt(Integer fuidt) {
		this.fuidt = fuidt;
	}

	

	
	

}
