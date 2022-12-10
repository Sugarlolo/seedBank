package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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

public class seed_devide_write {

	private JFrame frame;
	private JTextField textField;
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
		frame.setBounds(100, 100, 600, 315);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		String[] headings = new String[] {"회원아이디","자원번호","분양번호","자원명","분양신청인","분양신청일","담당자","분양수량"};
		DefaultTableModel model = new DefaultTableModel(headings, 0);
		JScrollPane jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		String query = "select 회원아이디,자원번호,분양번호,자원명,분양신청인,분양신청일,담당자,분양수량 from 분양";
		ResultSet rs = db.executeQuery(query);
		try {
			String row[] = new String[8];
			while (rs.next()) {
				row[0] = rs.getString(1);
				row[1] = Integer.toString(rs.getInt(2));
				row[2] = Integer.toString(rs.getInt(3));
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				row[7] = Integer.toString(rs.getInt(8));
				model.addRow(row);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		frame.getContentPane().add(jsp);
		jsp.setBounds(12, 41, 562, 170);
		JTable table = new JTable(model);
		jsp.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		
		JLabel Label = new JLabel("종자이름");
		Label.setBounds(58, 235, 53, 15);
		frame.getContentPane().add(Label);
		
		textField = new JTextField();
		textField.setBounds(114, 232, 106, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//등록버튼
		JButton btnAdd = new JButton("등록");
		btnAdd.setBounds(232, 231, 95, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String SnameStr = tfSname.getText();
//				String FromStr = tfFrom.getText();
//				String checksearch = cb_list.getSelectedItem().toString();
//				// PreparedStatement 사용
//				String sql = "select 자원명,수량,원산지,수집지,자원구분,평균수명 from 종자 where 자원명 = (?) and 원산지 = (?) and 자원구분 = (?)";
//				try {
//					PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
//					pstmt.setString(1,SnameStr);
//					pstmt.setString(2,FromStr);
//					pstmt.setString(3,checksearch);
//					pstmt.executeQuery();
//					pstmt.close();
//				}catch(SQLException e1){
//					e1.printStackTrace();
//				}		
							
				new seed_devide_view();
				frame.setVisible(false);
			}
		});
		
		
		//썻던 문장 초기화 하고 다시 쓸수있게
		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(339, 231, 95, 23);
		frame.getContentPane().add(btnReset);
		
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		//종료누르면 분양게시판?으로 넘어가기
		JButton btnExit = new JButton("종료");
		btnExit.setBounds(448, 231, 95, 23);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_devide_view();
				frame.setVisible(false);
			}
		});
		frame.setVisible(true);

	}
}
