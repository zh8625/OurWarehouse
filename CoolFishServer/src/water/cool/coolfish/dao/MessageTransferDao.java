package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.MessageTransfer;

public interface MessageTransferDao extends BaseDao<MessageTransfer>{
	
	//�̳�  ��ɾ , �޸Ĳ�ʵ��
	//����TOUID��ѯ���ʮ����Ϣ
	List<MessageTransfer> getMessageTransferByTOUID(int i);
	

}
