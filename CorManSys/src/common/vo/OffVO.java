package common.vo;

public class OffVO {
	
	private String name;
	private String clasz;
	private String position;
	private String dept;
	private String tel;
	private String resp;
	private int    id;
	private String memo;
	
	public OffVO() {}
	
	public OffVO(String name, String clasz, String position, String dept, String tel, String resp, int id, String memo) {
		this.name     = name;
		this.clasz    = clasz;
		this.position = position;
		this.dept     = dept;
		this.tel      = tel;
		this.resp     = resp;
		this.id       = id;
		this.memo     = memo;
	}
	
	public String getName    () {return name    ;}
	public String getClasz   () {return clasz   ;}
	public String getPosition() {return position;}
	public String getDept    () {return dept    ;}
	public String getTel     () {return tel     ;}
	public String getResp    () {return resp    ;}
	public int    getId      () {return id      ;}
	public String getMemo    () {return memo    ;}
	
	public void setName    (String name    ) {this.name     = name    ;}
	public void setClasz   (String clasz   ) {this.clasz    = clasz   ;}
	public void setPosition(String position) {this.position = position;}
	public void setDept    (String dept    ) {this.dept     = dept    ;}
	public void setTel     (String tel     ) {this.tel      = tel     ;}
	public void setResp    (String resp    ) {this.resp     = resp    ;}
	public void setId      (int    id      ) {this.id       = id      ;}
	public void setMemo    (String memo    ) {this.memo     = memo    ;}
		
}