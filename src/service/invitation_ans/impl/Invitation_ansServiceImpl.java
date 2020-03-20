package service.invitation_ans.impl;

import java.util.List;

import dao.invitation_ans.impl.Invitation_ansDaoImpl;
import entity.InvitationAns;
import service.invitation_ans.Invitation_ansService;

public class Invitation_ansServiceImpl implements Invitation_ansService {
    //����һ��dao�����
	Invitation_ansDaoImpl itd=new Invitation_ansDaoImpl();
	int result=0;
	@Override
	public List<InvitationAns> getInvitation_ans() {
		return itd.getall();
	}
	//ͨ��������Ų�ѯ����
	public List<InvitationAns> getById(String id) {
		return itd.getById(id);
	}
	//���ӻ���
	public boolean addInvitation_ans(InvitationAns ins) {
		result=itd.addInvitation_ans(ins);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

}
