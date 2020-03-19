package service.invitation.impl;

import java.util.List;

import dao.invitation.InvitationDao;
import dao.invitation.impl.InvitationDaoImpl;
import entity.Invitation;
import service.invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {
    //创建一个dao层对象
	InvitationDao ids=new InvitationDaoImpl();
	int result=0;
	//查询所有的方法
	@Override
	public List<Invitation> getall() {
		return ids.getall();
	}
	//通过主键查询
	@Override
	public Invitation getByid(String id) {
		return ids.getByid(id);
	}
	//修改的方法
	@Override
	public boolean updateInvitation(Invitation in) {
		result=ids.updateInvitation(in);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//增加主贴
	@Override
	public boolean addInvitation(Invitation in) {
		result=ids.addInvitation(in);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//删除单个的方法
	@Override
	public boolean delInvitation(String id) {
		result=ids.delInvitation(id);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//删除多个的方法
	@Override
	public boolean delAllInvitation(String[] params) {
		result=ids.delAllInvitation(params);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//模糊查询
	@Override
	public List<Invitation> getInvitationById(String id) {
		return ids.getInvitationById(id);
	}

}
