package water.cool.coolfish.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import water.cool.coolfish.bean.Friend;
import water.cool.coolfish.dao.FriendDao;

@Repository("friendDaoImpl")
public class FriendDaoImpl implements FriendDao {
	private SessionFactory sessionFactory;

	@Override
	public void insertObj(Friend t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);

	}

	@Override
	public void deleteObj(int i) {
		Session session = sessionFactory.getCurrentSession();
		Object o = session.get(Friend.class, i);
		if (o != null) {
			session.delete((Friend) o);
		}

	}

	@Override
	public void updateObj(Friend t) {
		// 修改不实现

	}

	@Override
	public boolean isExistByFUIDOAndFUIDT(int i, int j) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Friend f where f.fuido = ? and f.fuidt = ?");
		query.setInteger(0, i);
		query.setInteger(1, j);
		Object o = query.uniqueResult();
		if (o != null) {
			return true;
		} else {
			query.setInteger(0, i);
			query.setInteger(1, j);
			Object ob = query.uniqueResult();
			if (ob != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteFriend(int i, int j) {
		Session session = sessionFactory.getCurrentSession();
		//
		Friend f = null;
		//

		Query query = session.createQuery("from Friend f where f.fuido = ? and f.fuidt = ?");
		query.setInteger(0, i);
		query.setInteger(1, j);
		Object o = query.uniqueResult();
		if (o != null) {
			f = (Friend) o;
		} else {
			query.setInteger(0, i);
			query.setInteger(1, j);
			Object ob = query.uniqueResult();
			if (ob != null) {
				f = (Friend) o;
			}
		}
		if (f != null) {
			//删除好友关系
			session.delete(f);
		}

	}

	@Override
	public List<Integer> friendList(int i) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> fuids = new ArrayList<>();
		
		Query query = session.createQuery("from Friend f where f.fuido = ?");
		query.setInteger(0, i);
		List<Friend> fl = query.list();
		for (Friend friend : fl) {
			fuids.add(friend.getFuidt());
		}
		query = session.createQuery("from Friend f where f.fuidt = ?");
		query.setInteger(0, i);
		fl = query.list();
		for (Friend friend : fl) {
			fuids.add(friend.getFuidt());
		}
		return fuids;
	}

}
