package water.cool.coolfish.dao;

import java.util.List;

import water.cool.coolfish.bean.Friend;

public interface FriendDao extends BaseDao<Friend> {

	// 继承增删,修改不实现
	// 查看是否存在某数据(是否是好友)
	boolean isExistByFUIDOAndFUIDT(int i, int j);

	// 删除好友关系

	void deleteFriend(int i, int j);

	List<Integer> friendList(int i);

}
