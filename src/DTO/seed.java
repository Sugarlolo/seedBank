package DTO;

public class seed {
	int id;
	String s_name;
	int num;
	String contry_of_og;
	String collect_region;
	
	 public seed(int id, String s_name, int num, String contry_of_og, String collect_region) {
	        this.id = id;
	        this.s_name = s_name;
	        this.num = num;
	        this.contry_of_og = contry_of_og;	  
	        this.collect_region = collect_region;
	}


	public int getId() {
		return id;
	}

	
	public String getS_Name() {
		return s_name;
	}
	
	public int getnum() {
		return num;
	}
	
	public String getContry() {
		return contry_of_og;
	}

	public String getCollect() {
		return collect_region;
	}


        public void setId(int id) {
		this.id = id;
	}

        public void setUser(String s_name) {
		this.s_name = s_name;
	}
        
        public void setNum(int num) {
		this.num = num;
	}        

       public void setTitle(String Contry) {
		this.contry_of_og = contry_of_og;
	}

       public void setContent(String Collect) {
		this.collect_region = collect_region;
	}

	
	
}