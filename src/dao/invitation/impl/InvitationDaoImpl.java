package dao.invitation.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.invitation.InvitationDao;
import entity.Invitation;
import utils.DButils;

public class InvitationDaoImpl implements InvitationDao {
	 //��ѯ��������
		@Override
		public List<Invitation> getall() {
			List<Invitation> list=new ArrayList<Invitation>();
			String sql="SELECT * FROM bbs_invitation";
			try {
				ResultSet rs=DButils.queryAll(sql, null);
				while(rs.next()){
					list.add(new Invitation(rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getDate(9), rs.getDate(10)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	    //ͨ��������ѯ����
		@Override
		public Invitation getByid(String id) {
			Invitation in=null;
			Object params[]= {id};
			String sql="SELECT * FROM bbs_invitation WHERE invitationId=?";
			try {
				ResultSet rs=DButils.queryAll(sql, params);
				while(rs.next()) {
					in=new Invitation(rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getDate(9), rs.getDate(10));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return in;
		}
	    //�޸�����
		@Override
		public int updateInvitation(Invitation in) {
			Object params[]= {in.getInvitationmessage(),in.getPlateid(),in.getCategoryid(),in.getInvitationid()};
			String sql="UPDATE bbs_invitation SET invitationMessage=?,plateId=?,categoryId=? WHERE invitationId=?";
			return DButils.updateAll(sql, params);
		}
	    //��������
		@Override
		public int addInvitation(Invitation in) {
			Object params[]= {in.getInvitationid(),in.getInvitationmessage(),in.getUserid(),in.getPlateid(),in.getCategoryid(),in.getInvitationcreate()};
			String sql="INSERT INTO bbs_invitation(invitationId,invitationMessage,userId,plateId,categoryId,invitationCreate)\r\n" + 
					"VALUES(?,?,?,?,?,?)";
			return DButils.updateAll(sql, params);
		}
	    //ɾ����������
		@Override
		public int delInvitation(String id) {
			Object params[]= {id};
			String sql="DELETE FROM bbs_invitation WHERE invitationId=?";
			return DButils.updateAll(sql, params);
		}
	    //ɾ���������
		@Override
		public int delAllInvitation(String[] params) {
			StringBuffer sql = new StringBuffer("DELETE FROM bbs_invitation WHERE invitationId IN(");
			// ���ݲ�������ĳ��ȣ�ƴ������Ҫ��?�Ÿ���
			for (int i = 0; i < params.length; i++) {
				sql.append("?");
				if (i != params.length-1) {
					sql.append(",");
				}
			}
			sql.append(")");
			return DButils.updateAll(sql.toString(), params);
		}
	    //ģ����ѯ
		@Override
		public List<Invitation> getInvitationById(String id) {
			List<Invitation> list=new ArrayList<Invitation>();
		    Object	params[]= {id};
			String sql="SELECT * FROM bbs_invitation where invitationId LIKE CONCAT('%',?,'%')";
			try {
				ResultSet rs=DButils.queryAll(sql, params);
				while(rs.next()){
					list.add(new Invitation(rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),rs.getDate(9), rs.getDate(10)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//�Ƿ�ͨ��
		@Override
		public List<Invitation> getInvitationByPass(int pass) {
			// TODO Auto-generated method stub
			return null;
		}
		//���ͨ��
		@Override
		public int isPass(String id) {
			Object params[]= {id};
			String sql="UPDATE bbs_invitation SET isPass=1 WHERE invitationId=?";
			return DButils.updateAll(sql, params);
		}
}		
