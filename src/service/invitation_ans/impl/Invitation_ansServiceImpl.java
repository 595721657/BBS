package service.invitation_ans.impl;

import java.util.List;

import dao.invitation_ans.impl.Invitation_ansDaoImpl;
import entity.InvitationAns;
import service.invitation_ans.Invitation_ansService;

public class Invitation_ansServiceImpl implements Invitation_ansService {
    //创建一个dao层对象
	Invitation_ansDaoImpl itd=new Invitation_ansDaoImpl();
	int result=0;
	@Override
	public List<InvitationAns> getInvitation_ans() {
		return itd.getall();
	}
	//通过主贴编号查询数据
	public List<InvitationAns> getById(String id) {
		return itd.getById(id);
	}
	//增加回帖
	public boolean addInvitation_ans(InvitationAns ins) {
		result=itd.addInvitation_ans(ins);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

}
