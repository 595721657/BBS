package service.category.impl;

import java.util.List;

import dao.category.CategoryDao;
import dao.category.impl.CategoryDaoImpl;
import entity.Category;
import service.category.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    //����һ��service����
    CategoryDao cd=new CategoryDaoImpl();
    //��ѯ�������ݵķ���
	@Override
	public List<Category> getall() {
		return cd.getAll();
	}

}
