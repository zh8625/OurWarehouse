package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.ChatRecord;

public interface ChatRecordDao extends BaseDao<ChatRecord> {
	
	//�̳�  ��ɾ,�޸Ĳ�ʵ��
	
	//��
	//����touid��ѯ��Ϣ
	List<ChatRecord> getChatRecordByTOUID(int i);
	

}
