package entity;
/**
 * 
 * �˻��ȼ���Ϣ��
 * @author ����
 *
 */
public class Level {
    private int levelid;
    private String levelmessage;
	public int getLevelid() {
		return levelid;
	}
	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}
	public String getLevelmessage() {
		return levelmessage;
	}
	public void setLevelmessage(String levelmessage) {
		this.levelmessage = levelmessage;
	}
	public Level(int levelid, String levelmessage) {
		super();
		this.levelid = levelid;
		this.levelmessage = levelmessage;
	}
	public Level() {
		super();
	}
    
}
