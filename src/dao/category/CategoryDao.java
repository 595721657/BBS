package dao.category;

import java.util.List;

import entity.Category;

/**
 * 主题
 * @author 黄龙
 *
 */
public interface CategoryDao {
       //查询所有数据
	   List<Category> getAll();
}
