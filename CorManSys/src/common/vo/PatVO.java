package common.vo;

public class PatVO {
	
	private String name;
	private String gender;
	private int    age;
	private String phone;
	private String sido;
	private String gugun;
	private String address;
	private String memo;
	
	public PatVO() {}
	
	public PatVO(String name, String gender, int age, String phone, String sido, String gugun, String address, String memo) {this.name = name; this.gender = gender; this.age = age; this.phone = phone; this.sido = sido; this.gugun = gugun; this.address = address; this.memo = memo;}

	public String getName   () {return name   ;}
	public String getGender () {return gender ;}
	public int    getAge    () {return age    ;}
	public String getPhone  () {return phone  ;}
	public String getSido   () {return sido   ;}
	public String getGugun  () {return gugun  ;}
	public String getAddress() {return address;}
	public String getMemo   () {return memo   ;}

	public void setName   (String name   ) {this.name    = name   ;}
	public void setGender (String gender ) {this.gender  = gender ;}
	public void setAge    (int    age    ) {this.age     = age    ;}
	public void setPhone  (String phone  ) {this.phone   = phone  ;}
	public void setSido   (String sido   ) {this.sido    = sido   ;}
	public void setGugun  (String gugun  ) {this.gugun   = gugun  ;}
	public void setAddress(String address) {this.address = address;}
	public void setMemo   (String memo   ) {this.memo    = memo   ;}
	
}