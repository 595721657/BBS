package dao.user;

import java.util.List;

import entity.User;

public interface UserDao {
     
	/**
	 * //验证登录方法
	 * @param userid  用户名
	 * @param userpsd 密码
	 * @return 用户名和密码相同的个数
	 */
	int validation(String userid,String userpsd);
	//添加用户的方法
	int addUser(User user);
	//查询所有用户的方法
	List<User> getUserAll();
	//查询数据库有多少条数据
	int getAll();
	//通过userid查询数据的方法
	User getById(String id);
	//修改密码的方法
	int updatePsw(String psw,String id);
	//修改账户信息的方法
	int updateUser(User user);
	//删除用户的方法
	int deleteUser(String userid);
	//删除多个用户的方法
	int deleteUserAll(String[] id);
	//模糊查询
	List<User> getUserByUserid(String userid);
}
