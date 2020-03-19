package dao.category.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.category.CategoryDao;
import entity.Category;
import utils.DButils;

public class CategoryDaoImpl implements CategoryDao {
    //查询所有主题
	@Override
	public List<Category> getAll() {
		List<Category> list=new ArrayList<Category>();
		String sql="SELECT * FROM bbs_category";
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
