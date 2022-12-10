package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DB.DB_Conn_Query;


public class loginSystem {
	static loginSystem loginuser;
	String id;

	public String loginSystem(String id, String pw) {
		DB_Conn_Query db = new DB_Conn_Query();
		String sql = "SELECT 회원아이디, 비밀번호 FROM 회원";
		ResultSet rs = db.executeQuery(sql);
		boolean success = false;
		String m = "일반";
		try {
			while (rs.next()) {
				if (id.equals(rs.getString("회원아이디")) && pw.equals(rs.getString("비밀번호"))) {
					success = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (success)
			return m;
		else
			return null;

	}

	public static loginSystem getInstance() {
		if (loginuser == null) {
			loginuser = new loginSystem();
		}
		return loginuser; // 하나라도 값이 있으면 LoginUser의 그값을 리턴
	}
	   public String getId() {
		      return id;
		   }
		   public void setId(String id) {
		      this.id = id;
		   }
}
