package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.Friend;

public interface FriendDao extends BaseDao<Friend> {

	// �̳���ɾ,�޸Ĳ�ʵ��
	// �鿴�Ƿ����ĳ����(�Ƿ��Ǻ���)
	boolean isExistByFUIDOAndFUIDT(int i, int j);

	// ɾ�����ѹ�ϵ

	void deleteFriend(int i, int j);

	List<Integer> friendList(int i);

}
