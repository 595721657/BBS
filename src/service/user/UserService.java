package service.user;

import java.util.List;

import entity.User;

/**
 * 操作用户的业务接口
 * @author 黄龙
 *
 */
public interface UserService {
	//验证登录的方法
	boolean validation(String userid,String userpsd);
	//添加用户的方法
    boolean addUser(User user);
	//查询所有用户的方法
	List<User> getUserAll();
	//查询数据库有多少条数据
	int getAll();
	//通过userid查询数据的方法
	User getById(String id);
	//修改密码的方法
	boolean updatePsw(String psw,String id);
	//修改账户信息的方法
	boolean updateUser(User user);
	//删除用户的方法
	boolean deleteUser(String userid);
	
}
