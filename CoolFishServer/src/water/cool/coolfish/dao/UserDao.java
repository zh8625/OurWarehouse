package water.cool.coolfish.dao;

import water.cool.coolfish.bean.User;

public interface UserDao extends BaseDao<User> {
	
	//�̳�   ��ɾ��
	
	//��
	//�����û�����ѯ����
	String getPWDByUSERNAME(String username);
	//�����û�����ѯ�û���Ϣ
	User getUserByUSERNAME(String username);
	//�����û�����ѯ�û��Ƿ����
	boolean isExistByUSERNAME(String username);
	//����uid��ѯ�û�
	User getUserByUID(Integer integer);

}
