package service.category.impl;

import java.util.List;

import dao.category.CategoryDao;
import dao.category.impl.CategoryDaoImpl;
import entity.Category;
import service.category.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    //创建一个service对象
    CategoryDao cd=new CategoryDaoImpl();
    //查询所有数据的方法
	@Override
	public List<Category> getall() {
		return cd.getAll();
	}

}
