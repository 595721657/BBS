package service.plant.impl;

import java.util.List;

import dao.plant.PlantDao;
import dao.plant.impl.PlantDaoImpl;
import entity.Plate;
import service.plant.PlantService;

public class PlantServiceImpl implements PlantService {
	//����һ��dao�����
	PlantDao pd=new PlantDaoImpl();
	int result=0;
    //�õ����а��
	@Override
	public List<Plate> getAllPlate() {
		return pd.getAllPlate();
	}
    //�޸İ��
	@Override
	public boolean updatePlate(Plate plate) {
		result=pd.updatePlate(plate);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //ɾ�����
	@Override
	public boolean delPlate(int plateid) {
		result=pd.delPlate(plateid);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //���Ӱ��
	@Override
	public boolean addPlate(Plate plate) {
		result=pd.addPlate(plate);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //ͨ�����id��ѯ��Ϣ
	@Override
	public Plate getByPlateid(int plateid) {
		return pd.getByPlateid(plateid);
	}
    //���ð��
	@Override
	public boolean IsEnable(int able,int plateid) {
		result=pd.IsEnable(able,plateid);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
	//ɾ��������ݵķ���
	public boolean delAllPlate(String[] id) {
		result=pd.delAllPlate(id);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
	//ͨ������ģ����ѯ
	@Override
	public List<Plate> getAllBytitlePlate(String title) {
		return pd.getAllBytitlePlate(title);
	}

}
