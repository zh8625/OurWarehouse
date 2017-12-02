package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.ChatRecord;

public interface ChatRecordDao extends BaseDao<ChatRecord> {
	
	//继承  增删,修改不实现
	
	//查
	//根据touid查询消息
	List<ChatRecord> getChatRecordByTOUID(int i);
	

}
