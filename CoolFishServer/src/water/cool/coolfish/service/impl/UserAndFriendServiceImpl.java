package water.cool.coolfish.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import water.cool.coolfish.bean.Friend;
import water.cool.coolfish.bean.User;
import water.cool.coolfish.dao.FriendDao;
import water.cool.coolfish.dao.UserDao;
import water.cool.coolfish.service.UserAndFriendService;

@Service("userAndFriendServiceImpl")
public class UserAndFriendServiceImpl implements UserAndFriendService {

	private UserDao userDao;
	private FriendDao friendDao;

	@Override
	public User login(String username, String password) {

		String pwd = userDao.getPWDByUSERNAME(username);
		if (password.equals(pwd)) {
			return userDao.getUserByUSERNAME(username);
		}
		// 登录成功返回用户信息,失败返回空
		return null;
	}

	@Override
	public void reg(User u) throws Exception {
		if (!userDao.isExistByUSERNAME(u.getUsername())) {
			//设置默认头像
			u.setUicon("/img/001.jpg");
			userDao.insertObj(u);
		} else {
			throw new Exception("注册失败");
		}

	}

	@Override
	public User search(String username) {
		return userDao.getUserByUSERNAME(username);
	}

	@Override
	public void addFriend(int i, int j) {
		// 如果不是好友添加好友关系
		boolean isFriend = friendDao.isExistByFUIDOAndFUIDT(i, j);
		if (!isFriend) {
			Friend f = new Friend();
			f.setFuido(i);
			f.setFuidt(j);
			friendDao.insertObj(f);
		}

	}

	@Override
	public void deleteFriend(int i, int j) {
		// 如果是好友删除好友关系
		boolean isFriend = friendDao.isExistByFUIDOAndFUIDT(i, j);
		if (isFriend) {
			friendDao.deleteFriend(i, j);
		}

	}

	@Override
	public boolean isFriend(int i, int j) {
		return friendDao.isExistByFUIDOAndFUIDT(i, j);
	}
	
	public List<User> friendList(int i){
		List<Map<String, Object>> friendList = new ArrayList<>();
		List<Integer> fuids =friendDao.friendList(i);
		for (Integer integer : fuids) {
			User u = new User();
			u = userDao.getUserByUID(integer);
			friendList.add(u);
		}
		
		return friendList;
	}

}
