package dao.level;
/**
 * 等级表
 */
import java.util.List;

import entity.Level;

public interface LevelDao {
      //查询所有数据
	  List<Level> getall();
}
