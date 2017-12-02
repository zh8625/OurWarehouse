package water.cool.coolfish.service;

import java.util.List;

import water.cool.coolfish.bean.ChatRecord;
import water.cool.coolfish.bean.MessageTransfer;

public interface ChatService {

	// ����Ϣ
	void send(ChatRecord c);

	// ����Ϣ(����touid)
	List<ChatRecord> receive(int i);

	// ����TOUID��ѯ���ʮ����Ϣ
	List<MessageTransfer> getMessNear(int i);

}
