package entity;
/**
 * 帖子分类表
 * @author 黄龙
 *
 */
public class Category {
      private int categoryid;
      private String category;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Category(int categoryid, String category) {
		super();
		this.categoryid = categoryid;
		this.category = category;
	}
	public Category() {
		super();
	}
      
}
