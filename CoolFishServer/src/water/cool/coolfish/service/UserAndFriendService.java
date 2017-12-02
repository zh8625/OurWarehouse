package water.cool.coolfish.service;

import java.util.List;
import java.util.Map;

import water.cool.coolfish.bean.User;

public interface UserAndFriendService {

	// 登录注册,查看信息

	User login(String username, String password);

	void reg(User u) throws Exception;
	
	User search(String username);

	//查询两个用户是否为好友
	boolean isFriend(int i ,int j);
	
	// 加好友
	void addFriend(int i, int j);

	// 删除好友
	void deleteFriend(int i, int j);
	//好友列表
	List<Map<String, Object>> friendList(int i);

}
