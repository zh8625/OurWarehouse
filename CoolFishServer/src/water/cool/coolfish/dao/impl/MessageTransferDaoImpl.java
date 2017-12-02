package water.cool.coolfish.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import water.cool.coolfish.bean.MessageTransfer;
import water.cool.coolfish.dao.MessageTransferDao;
@Repository("messageTransferDaoImpl")
public class MessageTransferDaoImpl implements MessageTransferDao {

	private SessionFactory sessionFactory;
	@Override
	public void insertObj(MessageTransfer t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void deleteObj(int i) {
		Session session = sessionFactory.getCurrentSession();
		Object o = session.get(MessageTransfer.class, i);
		if(o!=null) {
			session.delete((MessageTransfer)o);
		}

	}

	@Override
	public void updateObj(MessageTransfer t) {
		//修改不实现

	}

	@Override
	public List<MessageTransfer> getMessageTransferByTOUID(int i) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MessageTransfer m where m.touid = ? order by m.mdate");
		query.setInteger(0, i);
		query.setFirstResult(0);
		query.setMaxResults(10);
		return query.list();
	}

}
