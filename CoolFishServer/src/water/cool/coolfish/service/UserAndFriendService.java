package water.cool.coolfish.service;

import java.util.List;
import java.util.Map;

import water.cool.coolfish.bean.User;

public interface UserAndFriendService {

	// ��¼ע��,�鿴��Ϣ

	User login(String username, String password);

	void reg(User u) throws Exception;
	
	User search(String username);

	//��ѯ�����û��Ƿ�Ϊ����
	boolean isFriend(int i ,int j);
	
	// �Ӻ���
	void addFriend(int i, int j);

	// ɾ������
	void deleteFriend(int i, int j);
	//�����б�
	List<Map<String, Object>> friendList(int i);

}
