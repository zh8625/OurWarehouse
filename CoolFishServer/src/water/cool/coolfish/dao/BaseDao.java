package water.cool.coolfish.dao;

public interface BaseDao<T> {
	//��
	void insertObj(T t);
	//ɾ
	void deleteObj(int i);
	//��
	void updateObj(T t);

}
