package dao.invitation;

import java.util.List;

import entity.Invitation;

public interface InvitationDao {
    //查询所有数据
	List<Invitation> getall();
	//根据id查询数据
	Invitation getByid(String id);
	//修改主贴
	int updateInvitation(Invitation in);
	//增加主题
	int addInvitation(Invitation in);
	//删除单个主帖
	int delInvitation(String id);
	//删除多个主帖
	int delAllInvitation(String[] params);
	//模糊查询
	List<Invitation> getInvitationById(String id);
	//查询再审核的帖子信息
	List<Invitation> getInvitationByPass(int pass);
}
