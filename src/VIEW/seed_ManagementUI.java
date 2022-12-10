package VIEW;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

import oracle.jdbc.OracleTypes;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ldap.PagedResultsResponseControl;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.DB_Conn_Query;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class seed_ManagementUI extends JFrame {
	private int s_Id;
	private String s_Name;
	private int s_Stack;
	private String s_origin;
	private String s_h_legion;
	private String s_div;
	private int s_avg_life;
	private String s_m_number;
	private int s_supply;
	private String s_date;
	DefaultTableModel model;
	private JLabel totalLabel2 = new JLabel("-");
	
	DB_Conn_Query db = new DB_Conn_Query();
	
	public seed_ManagementUI() {
		this.setSize(900,500);
		this.setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel manageLabel1 = new JLabel("자원 현황");
		manageLabel1.setBounds(40, 33, 57, 15);
		getContentPane().add(manageLabel1);
		
		//자원현황 불러오기
		
		JComboBox dateComboBox = new JComboBox();
		dateComboBox.setBounds(12, 68, 121, 23);
		getContentPane().add(dateComboBox);
		SimpleDateFormat sp = new SimpleDateFormat("yy/MM/dd");
		
		ResultSet rs = db.executeQuery("select distinct 공급일자 from 종자 order by 공급일자");
		try {
			while (rs.next()) {
				String ds = sp.format(rs.getDate(1));
				dateComboBox.addItem(ds);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		/////////////////////////////////////
		JLabel manageLabel2 = new JLabel("자원 회수");
		manageLabel2.setBounds(40, 228, 57, 15);
		getContentPane().add(manageLabel2);
		
		// 현황 테이블 만들기
		
		String[] headings = new String[] {"자원번호","자원명","수량","원산지","수집지","자원구분","평균수명","공급직원번호","공급일자","공급량"};
		model = new DefaultTableModel(headings, 0);
		JTable table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFillsViewportHeight(true);
		getContentPane().add(jsp);

		jsp.setBounds(145, 26, 715, 186);
		
		
		//자원현황 확인
		
		JButton dateCheckBtn = new JButton("검색하기");
		dateCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String selectedItem;
				selectedItem=dateComboBox.getSelectedItem().toString();
				System.out.println(selectedItem);
				String sql = "select * from 종자 where 공급일자='"+selectedItem+"'";
				ResultSet rs2 = db.executeQuery(sql);
				try {
					String row[] = new String[10];
					while(rs2.next()){
						String t=rs2.getString(9);
						t=t.substring(0,10);
						row[0] = Integer.toString(rs2.getInt(1));
						row[1] = rs2.getString(2);
						row[2] = Integer.toString(rs2.getInt(3));
						row[3] = rs2.getString(4);
						row[4] = rs2.getString(5);
						row[5] = rs2.getString(6);
						row[6] = Integer.toString(rs2.getInt(7));
						row[7] = rs2.getString(8);
						row[8] = t;
						row[9] = Integer.toString(rs2.getInt(10));
						model.addRow(row);
					}
					rs2.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				try {
				CallableStatement cstmt = db.getConnection().prepareCall("{call 일자별공급량합계 (?,?)}");
				cstmt.setString(1, selectedItem);
				cstmt.registerOutParameter(2, Types.INTEGER);
				cstmt.executeQuery();
				System.out.println(cstmt.getInt(2));
				int r = cstmt.getInt(2);
				cstmt.close();
				totalLabel2.setText(Integer.toString(r));
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		dateCheckBtn.setBounds(22, 119, 97, 23);
		getContentPane().add(dateCheckBtn);
		
		JLabel totalLabel = new JLabel("총합 :");
		totalLabel.setBounds(12, 179, 40, 15);
		getContentPane().add(totalLabel);
		
		
		totalLabel2.setBounds(62, 179, 57, 15);
		getContentPane().add(totalLabel2);
		
		
	}
}
