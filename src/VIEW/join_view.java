package VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.DB_Conn_Query;
import java.util.*;
public class join_view extends JFrame {

	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JButton duplicateBtn;
	private JTextField tfUserID;
	private JTextField tfAge;
	private JTextField tfNAME;
	private JTextField tfPW;
	private JTextField tfPhone;
	private JTextField tfDiv;
	DB_Conn_Query db = new DB_Conn_Query();
	
	private boolean OK;

	// 실행
	public class Joinrun {
		
		public Joinrun() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						join_view frame = new join_view();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	// 회원가입 창
	public join_view() {
		
		super("회원가입");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(463, 526);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblJoin = new JLabel("회원가입");
		lblJoin.setBounds(159, 41, 101, 20);
		contentPane.add(lblJoin);

		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(69, 113, 69, 20);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 163, 69, 20);
		contentPane.add(lblPassword);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(69, 213, 52, 15);
		contentPane.add(lblName);

		JLabel lblBirth = new JLabel("나이");
		lblBirth.setBounds(69, 267, 69, 20);
		contentPane.add(lblBirth);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(69, 319, 69, 20);
		contentPane.add(lblPhone);
		
		JLabel lblteam = new JLabel("회원소속");
		lblteam.setBounds(69, 373, 69, 20);
		contentPane.add(lblteam);

		tfUserID = new JTextField();
		tfUserID.setColumns(10);
		tfUserID.setBounds(159, 106, 186, 35);
		contentPane.add(tfUserID);

		tfNAME = new JTextField();
		tfNAME.setColumns(10);
		tfNAME.setBounds(159, 203, 186, 35);
		contentPane.add(tfNAME);

		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(159, 257, 186, 35);
		contentPane.add(tfAge);

		tfPW = new JTextField();
		tfPW.setColumns(10);
		tfPW.setBounds(159, 156, 186, 35);
		contentPane.add(tfPW);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(159, 312, 186, 35);
		contentPane.add(tfPhone);

		joinCompleteBtn = new JButton("회원가입완료");
		joinCompleteBtn.setBounds(298, 420, 139, 29);
		contentPane.add(joinCompleteBtn);

		// 회원가입시 중복 확인버튼
		
		duplicateBtn = new JButton("중복");
		duplicateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = tfUserID.getText(); // 체크할 아이디
				System.out.println(inputId);
				String checkId=""; // sql문에서 받아올 아이디
				ResultSet rs  = db.executeQuery("SELECT 회원아이디 FROM 회원 WHERE 회원아이디 = '"+inputId+"'");
				System.out.println("SELECT 회원아이디 FROM 회원 WHERE 회원아이디 = '"+inputId+"'");
				try {
					while(rs.next()) {
						checkId = rs.getString(1);
						if (checkId==inputId) {
							JOptionPane.showMessageDialog(null,"중복됩니다.");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (inputId.equals(checkId)) {
					JOptionPane.showMessageDialog(null,"중복됩니다.");
				}
				else {
					JOptionPane.showMessageDialog(null,"사용가능") ;
					OK = true;
				}
				System.out.println(checkId);
			}
		});
		duplicateBtn.setBounds(350, 110, 70, 29);
		contentPane.add(duplicateBtn);
		
		tfDiv = new JTextField();
		tfDiv.setColumns(10);
		tfDiv.setBounds(159, 366, 186, 35);
		contentPane.add(tfDiv);

		// 회원가입 완료
		
		joinCompleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//user user = new user(tfUserID.getText(), tfPassword.getText(), tfUsername.getText(), tfBirth.getText(),
				//		tfPhone.getText());
				String idStr = tfUserID.getText();
				String pasStr = tfPW.getText();
				String nameStr = tfNAME.getText();
				int y_old = Integer.parseInt(tfAge.getText());
				String phoneStr = tfPhone.getText();
				String div = tfDiv.getText();
				if (OK == true) {
					
					// PreparedStatement 사용					
					String sql = "INSERT INTO 회원 VALUES (?,?,?,?,?,?)";
						try {
							PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
							pstmt.setString(1, idStr);
							pstmt.setString(2, pasStr);
							pstmt.setString(3, nameStr);
							pstmt.setInt(4, y_old);
							pstmt.setString(5,phoneStr);
							pstmt.setString(6, div);
							pstmt.executeQuery();
							pstmt.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						dispose();
						new login_view();
						
				}
				else JOptionPane.showMessageDialog(null, "아이디 중복 체크를 하세요.");


			}
		});
		setVisible(true);
	}
}
