package service.invitation.impl;

import java.util.List;

import dao.invitation.InvitationDao;
import dao.invitation.impl.InvitationDaoImpl;
import entity.Invitation;
import service.invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {
    //����һ��dao�����
	InvitationDao ids=new InvitationDaoImpl();
	int result=0;
	//��ѯ���еķ���
	@Override
	public List<Invitation> getall() {
		return ids.getall();
	}
	//ͨ��������ѯ
	@Override
	public Invitation getByid(String id) {
		return ids.getByid(id);
	}
	//�޸ĵķ���
	@Override
	public boolean updateInvitation(Invitation in) {
		result=ids.updateInvitation(in);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//��������
	@Override
	public boolean addInvitation(Invitation in) {
		result=ids.addInvitation(in);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//ɾ�������ķ���
	@Override
	public boolean delInvitation(String id) {
		result=ids.delInvitation(id);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//ɾ������ķ���
	@Override
	public boolean delAllInvitation(String[] params) {
		result=ids.delAllInvitation(params);
		if(result>0) {
			return true;
		}else {
		    return false;
		} 
	}
	//ģ����ѯ
	@Override
	public List<Invitation> getInvitationById(String id) {
		return ids.getInvitationById(id);
	}

}
