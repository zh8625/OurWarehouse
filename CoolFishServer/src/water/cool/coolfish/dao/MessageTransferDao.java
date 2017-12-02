package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.MessageTransfer;

public interface MessageTransferDao extends BaseDao<MessageTransfer>{
	
	//继承  增删 , 修改不实现
	//根据TOUID查询最近十条消息
	List<MessageTransfer> getMessageTransferByTOUID(int i);
	

}
