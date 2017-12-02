package water.cool.coolfish.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import water.cool.coolfish.bean.User;
import water.cool.coolfish.dao.UserDao;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	@Override
	public void insertObj(User t) {
		Session session = sessionFactory.getCurrentSession();

		session.save(t);

	}

	@Override
	public void deleteObj(int i) {
		Session session = sessionFactory.getCurrentSession();
		Object o =  session.get(User.class, i);
		if (o != null) {
			session.delete((User)o);
		}

	}

	@Override
	public void updateObj(User t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);

	}

	@Override
	public String getPWDByUSERNAME(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username = ?");
		query.setString(0, username);
		
		Object o = query.uniqueResult();
		if(o != null) {
			return ((User)o).getPassword();
		}
		return null;
	}

	@Override
	public User getUserByUSERNAME(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username = ?");
		query.setString(0, username);
		
		Object o = query.uniqueResult();
		if(o != null) {
			return (User)o;
		}
		return null;
	}

	@Override
	public boolean isExistByUSERNAME(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username = ?");
		query.setString(0, username);
		
		Object o = query.uniqueResult();
		if(o != null) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUID(Integer integer) {
		Session session = sessionFactory.getCurrentSession();
		
		return (User) session.get(User.class, integer);
	}

}
