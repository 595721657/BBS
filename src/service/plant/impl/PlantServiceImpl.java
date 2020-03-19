package service.plant.impl;

import java.util.List;

import dao.plant.PlantDao;
import dao.plant.impl.PlantDaoImpl;
import entity.Plate;
import service.plant.PlantService;

public class PlantServiceImpl implements PlantService {
	//创建一个dao层对象
	PlantDao pd=new PlantDaoImpl();
	int result=0;
    //得到所有板块
	@Override
	public List<Plate> getAllPlate() {
		return pd.getAllPlate();
	}
    //修改板块
	@Override
	public boolean updatePlate(Plate plate) {
		result=pd.updatePlate(plate);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //删除板块
	@Override
	public boolean delPlate(int plateid) {
		result=pd.delPlate(plateid);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //增加板块
	@Override
	public boolean addPlate(Plate plate) {
		result=pd.addPlate(plate);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
    //通过板块id查询信息
	@Override
	public Plate getByPlateid(int plateid) {
		return pd.getByPlateid(plateid);
	}
    //禁用板块
	@Override
	public boolean IsEnable(int able,int plateid) {
		result=pd.IsEnable(able,plateid);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
	//删除多个数据的方法
	public boolean delAllPlate(String[] id) {
		result=pd.delAllPlate(id);
		if(result>0) {
			return true;
		}else {
		    return false;
		}
	}
	//通过标题模糊查询
	@Override
	public List<Plate> getAllBytitlePlate(String title) {
		return pd.getAllBytitlePlate(title);
	}

}
