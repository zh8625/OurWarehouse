package water.cool.coolfish.service;

import java.util.List;

import water.cool.coolfish.bean.ChatRecord;
import water.cool.coolfish.bean.MessageTransfer;

public interface ChatService {

	// 发消息
	void send(ChatRecord c);

	// 收消息(根据touid)
	List<ChatRecord> receive(int i);

	// 根据TOUID查询最近十条消息
	List<MessageTransfer> getMessNear(int i);

}
