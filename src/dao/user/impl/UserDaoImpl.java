package dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.user.UserDao;
import entity.User;
import utils.DButils;

public class UserDaoImpl implements UserDao {

	@Override
	public int validation(String userid, String userpsd) {
		//����sql����
		String sql="SELECT COUNT(1) FROM bbs_user WHERE userId=? AND userpsw=?";
		//������������
		Object params[]= {userid,userpsd};
		ResultSet rs=DButils.queryAll(sql, params);
		int result=0;
		try {
			while(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButils.closeAll(rs, null, null);
		}
	    return result;
	}
    //����û��ķ���
	@Override
	public int addUser(User user) {
		String sql="INSERT INTO bbs_user(userId,userpsw,userEmail,userSex,userPhoto) VALUES(?,?,?,?,?)";
		Object params[]= {user.getUserid(),user.getUserpsw(),user.getUsermail(),user.getUsersex(),user.getUserphoto()};
		return DButils.updateAll(sql, params);
	}
	//��ѯ�����û�
	@Override
	public List<User> getUserAll() {
		List<User> user=new ArrayList<User>();
		String sql="SELECT * FROM bbs_user";
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
				user.add(new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getDate(10)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	//��ѯ�����û��ж�����
	@Override
	public int getAll() {
		String sql="SELECT COUNT(1) FROM bbs_user";
		int result=0;
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
			     result =rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//ͨ��userid��ѯ���ݵķ���
	@Override
	public User getById(String id) {
	    User user=new User();
	    Object params[]= {id};
		try {
			String sql="SELECT * FROM bbs_user WHERE userId=?";
			ResultSet rs=DButils.queryAll(sql, params);
			while(rs.next()) {
				user=new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getDate(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	//�޸�����ķ���
	@Override
	public int updatePsw(String psw, String id) {
		String sql="UPDATE  bbs_user SET userpsw=? WHERE userId=?";
		Object params[]= {psw,id};
		return DButils.updateAll(sql, params);
	}
	//�޸��û���Ϣ�ķ���
	@Override
	public int updateUser(User user) {
		String sql="UPDATE  bbs_user SET userEmail=?,userSex=?,userPhoto=? WHERE userId=?";
		Object params[]= {user.getUsermail(),user.getUsersex(),user.getUserphoto(),user.getUserid()};
		return DButils.updateAll(sql, params);
	}
	//ɾ���û��ķ���
	@Override
	public int deleteUser(String userid) {
		String sql="DELETE FROM bbs_user WHERE userId=?";
		Object params[]= {userid};
		return DButils.updateAll(sql, params);
	}
	//ɾ�����
	@Override
	public int deleteUserAll(String[] id) {
		StringBuffer sql = new StringBuffer("DELETE FROM bbs_user WHERE userId IN(");
		// ���ݲ�������ĳ��ȣ�ƴ������Ҫ��?�Ÿ���
		for (int i = 0; i < id.length; i++) {
			sql.append("?");
			if (i != id.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		return DButils.updateAll(sql.toString(), id);
	}
	//ģ����ѯ
	@Override
	public List<User> getUserByUserid(String userid) {
		List<User> user=new ArrayList<User>();
	    Object parmars[]= {userid};
		String sql="SELECT * FROM bbs_user WHERE userId LIKE CONCAT('%',?,'%')";
		try {
			ResultSet rs=DButils.queryAll(sql, parmars);
			while(rs.next()) {
				user.add(new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getDate(10)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
