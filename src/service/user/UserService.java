package service.user;

import java.util.Date;
import java.util.List;

import entity.User;

/**
 * �����û���ҵ��ӿ�
 * @author ����
 *
 */
public interface UserService {
	//��֤��¼�ķ���
	boolean validation(String userid,String userpsd);
	//����û��ķ���
    boolean addUser(User user);
	//��ѯ�����û��ķ���
	List<User> getUserAll();
	//��ѯ���ݿ��ж���������
	int getAll();
	//ͨ��userid��ѯ���ݵķ���
	User getById(String id);
	//�޸�����ķ���
	boolean updatePsw(String psw,String id);
	//�޸��˻���Ϣ�ķ���
	boolean updateUser(User user);
	//ɾ���û��ķ���
	boolean deleteUser(String userid);
	//ɾ�����
	boolean deleteUserAll(String[] id);
	//�ж��Ƿ����
	boolean disableUser(Date now,Date end);
	//����
	boolean DisableUser(String userid, Date new_date);
	//����
	boolean UpgradeUser(String userid);
	//����
	boolean DemotionUser(String userid, Date date);
	//ģ����ѯ
	List<User> getUserByUserid(String userid);
}
