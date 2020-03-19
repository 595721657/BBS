package service.invitation;

import java.util.List;

import entity.Invitation;

public interface InvitationService {
    //查询所有的信息
	List<Invitation> getall();
	//根据id查询数据
	Invitation getByid(String id);
	//修改主贴
	boolean updateInvitation(Invitation in);
	//增加主题
	boolean addInvitation(Invitation in);
	//删除单个主帖
	boolean delInvitation(String id);
	//删除多个主帖
	boolean delAllInvitation(String[] params);
	//模糊查询
	List<Invitation> getInvitationById(String id);
}
