package service.user.impl;

import java.util.List;

import dao.user.UserDao;
import dao.user.impl.UserDaoImpl;
import entity.User;
import service.user.UserService;

public class UserServiceImpl implements UserService {
    //创建一个dao用户对象
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
	//添加用户
	@Override
	public boolean addUser(User user) {
		int result=ud.addUser(user);
		if(result>0) {
			 return true;
		}else {
		   return false;
		}
	}
	//得到所有用户信息进行展示
	@Override
	public List<User> getUserAll() {
		return ud.getUserAll();
	}
	//查询数据库里面有多少条数据
	@Override
	public int getAll() {
		return ud.getAll();
	}
	//通过用户编号查询数据
	@Override
	public User getById(String id) {
		return ud.getById(id);
	}
	//修改密码的方法
	@Override
	public boolean updatePsw(String psw, String id) {
		int result=ud.updatePsw(psw, id);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//修改用户信息的方法
	@Override
	public boolean updateUser(User user) {
		int result=ud.updateUser(user);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//删除用户的方法
	@Override
	public boolean deleteUser(String userid) {
		int result=ud.deleteUser(userid);
		if(result>0) {
			//删除成功
			return true;
		}else {
			//删除失败
		    return false;
		}
	}
	//删除多个的方法
	public boolean deleteUserAll(String[] id) {
		int result=ud.deleteUserAll(id);
		if(result>0) {
			//删除成功
			return true;
		}else {
			//删除失败
		    return false;
		}
	}
	//模糊查询的方法
	public List<User> getUserByUserid(String userid) {
		return ud.getUserByUserid(userid);
	}

}
