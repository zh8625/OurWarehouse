package water.cool.coolfish.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import water.cool.coolfish.bean.ChatRecord;
import water.cool.coolfish.dao.ChatRecordDao;
@Repository("chatRecordDaoImpl")
public class ChatRecordDaoImpl implements ChatRecordDao {

	private SessionFactory sessionFactory;
	@Override
	public void insertObj(ChatRecord t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);

	}

	@Override
	public void deleteObj(int i) {
		Session session = sessionFactory.getCurrentSession();
		Object o = session.get(ChatRecord.class, i);
		if(o!=null) {
			session.delete((ChatRecord)o);
		}

	}

	@Override
	public void updateObj(ChatRecord t) {
		//修改不实现

	}

	@Override
	public List<ChatRecord> getChatRecordByTOUID(int i) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ChatRecord c where c.touid = ?");
		query.setInteger(0, i);
		return query.list();
	}

}
