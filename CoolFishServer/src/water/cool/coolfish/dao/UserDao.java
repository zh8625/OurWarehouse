package water.cool.coolfish.dao;

import water.cool.coolfish.bean.User;

public interface UserDao extends BaseDao<User> {
	
	//继承   增删改
	
	//查
	//根据用户名查询密码
	String getPWDByUSERNAME(String username);
	//根据用户名查询用户信息
	User getUserByUSERNAME(String username);
	//根据用户名查询用户是否存在
	boolean isExistByUSERNAME(String username);
	//根据uid查询用户
	User getUserByUID(Integer integer);

}
