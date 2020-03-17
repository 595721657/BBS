package dao.user;

import java.util.List;

import entity.User;

public interface UserDao {
     
	/**
	 * //��֤��¼����
	 * @param userid  �û���
	 * @param userpsd ����
	 * @return �û�����������ͬ�ĸ���
	 */
	int validation(String userid,String userpsd);
	//����û��ķ���
	int addUser(User user);
	//��ѯ�����û��ķ���
	List<User> getUserAll();
	//��ѯ���ݿ��ж���������
	int getAll();
	//ͨ��userid��ѯ���ݵķ���
	User getById(String id);
	//�޸�����ķ���
	int updatePsw(String psw,String id);
	//�޸��˻���Ϣ�ķ���
	int updateUser(User user);
	//ɾ���û��ķ���
	int deleteUser(String userid);
	//ɾ������û��ķ���
	int deleteUserAll(String[] id);
	//ģ����ѯ
	List<User> getUserByUserid(String userid);
}
