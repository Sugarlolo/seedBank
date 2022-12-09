package DTO;

public class LoginUser {
	String id;
	String name;
	String birth;
	String password;
	String adress;
	String belong;
	String phone;
	public LoginUser(String id, String name, String birth, String password,
						String adress, String belong, String phone) {
		
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.password = password;
		this.adress = adress;
		this.belong = belong;
		this.phone = phone;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String id) {
		this.adress = adress;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String id) {
		this.belong = belong;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

