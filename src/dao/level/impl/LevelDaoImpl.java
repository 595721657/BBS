package dao.level.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.level.LevelDao;
import entity.Level;
import utils.DButils;

public class LevelDaoImpl implements LevelDao {

	@Override
	public List<Level> getall() {
		List<Level> list=new ArrayList<Level>();
		String sql="SELECT * FROM bbs_level";
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new Level(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
