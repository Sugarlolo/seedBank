package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.loginSystem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import DB.DB_Conn_Query;

import java.awt.Font;
public class seed_devide_write {
	public static String ID;
	private JFrame frame;
	private JTextField txSeedName1;
	private JTextField txSeedName2;
	private JTextField txSeedLeft;
	String idstr = loginSystem.getInstance().getId();
	DB_Conn_Query db = new DB_Conn_Query();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seed_devide_write window = new seed_devide_write();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public seed_devide_write() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("종자분양신청하기");
		frame.setBounds(100, 100, 605, 561);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String ID;

		JLabel lblNewLabel = new JLabel("분양검색");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 16, 88, 15);
		frame.getContentPane().add(lblNewLabel);

		// 검색용 테이블
		String[] headings = new String[] { "자원번호", "분양번호", "자원명", "담당자", "분양수량" };
		DefaultTableModel model = new DefaultTableModel(headings, 0);
		JScrollPane jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(jsp);
		jsp.setBounds(12, 41, 562, 170);
		JTable table = new JTable(model);
		jsp.setViewportView(table);
		table.setFillsViewportHeight(true);

		JLabel SeedName1 = new JLabel("종자이름");
		SeedName1.setBounds(58, 235, 53, 15);
		frame.getContentPane().add(SeedName1);

		txSeedName1 = new JTextField();
		txSeedName1.setBounds(114, 232, 106, 21);
		frame.getContentPane().add(txSeedName1);
		txSeedName1.setColumns(10);

		// 검색버튼
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(232, 231, 95, 23);
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnameStr = txSeedName1.getText();
				// PreparedStatement 사용
				String sql = "select 자원번호,분양번호,자원명,담당자,분양수량 from 분양 where 자원명 = (?)";
				try {
					String row[] = new String[5];
					PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
					pstmt.setString(1, SnameStr);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						row[0] = Integer.toString(rs.getInt(1));
						row[1] = Integer.toString(rs.getInt(2));
						row[2] = rs.getString(3);
						row[3] = rs.getString(4);
						row[4] = Integer.toString(rs.getInt(5));
						model.addRow(row);
					}
					rs.close();
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// frame.setVisible(false);
			}
		});

		// 썻던 문장 초기화 하고 다시 쓸수있게
		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(339, 231, 95, 23);
		frame.getContentPane().add(btnReset);

//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});

		// 종료누르면 분양게시판?으로 넘어가기
		JButton btnExit = new JButton("종료");
		btnExit.setBounds(448, 231, 95, 23);
		frame.getContentPane().add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main_view();
				frame.setVisible(false);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("분양신청");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 276, 88, 15);
		frame.getContentPane().add(lblNewLabel_1);

		// 신청용 테이블
		String[] headings2 = new String[] { "회원아이디", "자원번호", "분양번호", "자원명", "분양신청인", "분양신청일", "담당자", "분양수량" };
		DefaultTableModel model2 = new DefaultTableModel(headings2, 0);
		JScrollPane jsp2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(jsp2);
		jsp2.setBounds(12, 302, 562, 170);
		JTable table2 = new JTable(model2);
		jsp2.setViewportView(table2);
		table2.setFillsViewportHeight(true);

		JLabel SeedName2 = new JLabel("종자이름");
		SeedName2.setBounds(58, 485, 53, 15);
		frame.getContentPane().add(SeedName2);

		txSeedName2 = new JTextField();
		txSeedName2.setColumns(10);
		txSeedName2.setBounds(114, 482, 106, 21);
		frame.getContentPane().add(txSeedName2);

		JLabel seedLeft = new JLabel("수량");
		seedLeft.setBounds(232, 485, 31, 15);
		frame.getContentPane().add(seedLeft);

		txSeedLeft = new JTextField();
		txSeedLeft.setColumns(10);
		txSeedLeft.setBounds(261, 482, 53, 21);
		frame.getContentPane().add(txSeedLeft);

		// 등록버튼
		JButton btnAdd = new JButton("신청");
		btnAdd.setBounds(339, 481, 95, 23);
		frame.getContentPane().add(btnAdd);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SeedName_str = txSeedName2.getText(); // 종자이름
				String SeedLeft_str = txSeedLeft.getText(); // 분양수량
				int num = 0; // 분양번호 카운트
				String s_number ="";
				
				// PreparedStatement 사용
				String sql = "select COUNT(*) from 분양";
				// 분양번호 카운트
				ResultSet rs = db.executeQuery(sql);
				try {
					while(rs.next()) {
					num = rs.getInt(1);
					}rs.close();
					num++;
					
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				
				// 자원번호 구하기
				
				String sql2 = "SELECT 자원번호 FROM 종자 WHERE 자원명 = '"+SeedName_str+"'";
				ResultSet rs2 = db.executeQuery(sql2);
				try {
					while(rs2.next()) {
						s_number = rs2.getString(1);
					}rs2.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
				
				String sql3 = "INSERT INTO 분양 VALUES('qwer',"+s_number+","+num+",'"+SeedName_str+"',"
						+ "'이원석','22/12/11','001',"+Integer.parseInt(SeedLeft_str)+")";
				ResultSet rs3 = db.executeQuery(sql3);
				try {
					rs3.next();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
				System.out.println(sql3);
			
			}
		});

		frame.setVisible(true);
	}
}
