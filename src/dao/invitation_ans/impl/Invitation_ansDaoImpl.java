package dao.invitation_ans.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.invitation_ans.Invitation_ansDao;
import entity.InvitationAns;
import utils.DButils;

public class Invitation_ansDaoImpl implements Invitation_ansDao {

	@Override
	public List<InvitationAns> getall() {
		List<InvitationAns> list=new ArrayList<InvitationAns>();
		String sql="SELECT * FROM bbs_invitation_ans";
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new InvitationAns(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
    //通过主贴编号查询数据
	public List<InvitationAns> getById(String id) {
		List<InvitationAns> list=new ArrayList<InvitationAns>();
		Object params[]= {id};
		String sql="SELECT * FROM bbs_invitation_ans WHERE invitationId=?";
		try {
			ResultSet rs=DButils.queryAll(sql, params);
			while(rs.next()) {
				list.add(new InvitationAns(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//增加回帖
	public int addInvitation_ans(InvitationAns ins) {
		String sql="INSERT INTO bbs_invitation_ans() VALUES(?,?,?,?,?)";
		Object params[]= {ins.getAnsid(),ins.getAnsmessage(),ins.getInvitationid(),ins.getUserid(),ins.getAnsdate()};
		return DButils.updateAll(sql, params);
	}

}
