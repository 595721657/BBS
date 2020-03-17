package entity;
/**
 * °å¿éĞÅÏ¢±í
 * @author »ÆÁú
 *
 */
public class Plate {
    private int plateid;
    private String platetitle;
    private String platemessage;
    private int isenable;
	public int getPlateid() {
		return plateid;
	}
	public void setPlateid(int plateid) {
		this.plateid = plateid;
	}
	public String getPlatetitle() {
		return platetitle;
	}
	public void setPlatetitle(String platetitle) {
		this.platetitle = platetitle;
	}
	public String getPlatemessage() {
		return platemessage;
	}
	public void setPlatemessage(String platemessage) {
		this.platemessage = platemessage;
	}
	public int getIsenable() {
		return isenable;
	}
	public void setIsenable(int isenable) {
		this.isenable = isenable;
	}
	public Plate(int plateid, String platetitle, String platemessage, int isenable) {
		super();
		this.plateid = plateid;
		this.platetitle = platetitle;
		this.platemessage = platemessage;
		this.isenable = isenable;
	}
	public Plate() {
		super();
	}
	public Plate(String platetitle, String platemessage) {
		super();
		this.platetitle = platetitle;
		this.platemessage = platemessage;
	}
    
}
