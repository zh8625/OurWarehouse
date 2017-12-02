package water.cool.coolfish.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import water.cool.coolfish.bean.ChatRecord;
import water.cool.coolfish.bean.MessageTransfer;
import water.cool.coolfish.dao.ChatRecordDao;
import water.cool.coolfish.dao.MessageTransferDao;
import water.cool.coolfish.service.ChatService;

@Service("chatServiceImpl")
public class ChatServiceImpl implements ChatService {
	private ChatRecordDao chatRecordDao;
	private MessageTransferDao messageTransferDao;

	@Override
	public void send(ChatRecord c) {
		//将消息添加到临时表
		chatRecordDao.insertObj(c);
		
		//将消息添加到聊天记录
		MessageTransfer m = new MessageTransfer();
		m.setFromuid(c.getFromuid());
		m.setTouid(c.getTouid());
		m.setMessage(c.getMessage());
		m.setMdate(c.getCdate());
		messageTransferDao.insertObj(m);

	}

	@Override
	public List<ChatRecord> receive(int i) {
		//接收消息
		List<ChatRecord> lc = chatRecordDao.getChatRecordByTOUID(i);
		//接收消息后，根据id，将临时表中的数据删除
		for (ChatRecord chatRecord : lc) {
			chatRecordDao.deleteObj(chatRecord.getCid());
		}
		
		return lc;
	}
	

	@Override
	public List<MessageTransfer> getMessNear(int i) {
		//查询最近十条消息
		List<MessageTransfer> lm = messageTransferDao.getMessageTransferByTOUID(i);
		return lm;
	}

}
