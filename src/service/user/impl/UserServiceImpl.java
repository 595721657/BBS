package service.user.impl;

import java.util.List;

import dao.user.UserDao;
import dao.user.impl.UserDaoImpl;
import entity.User;
import service.user.UserService;

public class UserServiceImpl implements UserService {
    //����һ��dao�û�����
	UserDao ud=new UserDaoImpl();
	@Override
	public boolean validation(String userid, String userpsd) {
		int result= ud.validation(userid, userpsd);
	    if(result>0) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
	//����û�
	@Override
	public boolean addUser(User user) {
		int result=ud.addUser(user);
		if(result>0) {
			 return true;
		}else {
		   return false;
		}
	}
	//�õ������û���Ϣ����չʾ
	@Override
	public List<User> getUserAll() {
		return ud.getUserAll();
	}
	//��ѯ���ݿ������ж���������
	@Override
	public int getAll() {
		return ud.getAll();
	}
	//ͨ���û���Ų�ѯ����
	@Override
	public User getById(String id) {
		return ud.getById(id);
	}
	//�޸�����ķ���
	@Override
	public boolean updatePsw(String psw, String id) {
		int result=ud.updatePsw(psw, id);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//�޸��û���Ϣ�ķ���
	@Override
	public boolean updateUser(User user) {
		int result=ud.updateUser(user);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//ɾ���û��ķ���
	@Override
	public boolean deleteUser(String userid) {
		int result=ud.deleteUser(userid);
		if(result>0) {
			//ɾ���ɹ�
			return true;
		}else {
			//ɾ��ʧ��
		    return false;
		}
	}
	//ɾ������ķ���
	public boolean deleteUserAll(String[] id) {
		int result=ud.deleteUserAll(id);
		if(result>0) {
			//ɾ���ɹ�
			return true;
		}else {
			//ɾ��ʧ��
		    return false;
		}
	}
	//ģ����ѯ�ķ���
	public List<User> getUserByUserid(String userid) {
		return ud.getUserByUserid(userid);
	}

}
