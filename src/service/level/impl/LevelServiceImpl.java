package service.level.impl;

import java.util.List;

import dao.level.LevelDao;
import dao.level.impl.LevelDaoImpl;
import entity.Level;
import service.level.LevelService;

public class LevelServiceImpl implements LevelService {
    //����һ��dao�����
	LevelDao ld=new LevelDaoImpl();
	@Override
	public List<Level> getall() {
		return ld.getall();
	}

}
