package VIEW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DB_Conn_Query;

public class seed_devide_view {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-6,1039
	 */
	private JTable table;
	private JTextField tf;
	private JTable table_1;
	DB_Conn_Query db = new DB_Conn_Query();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					seed_devide_view window = new seed_devide_view();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public seed_devide_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("자원분양");
		frame.setBounds(100, 100, 950, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] headings = new String[] {"회원아이디","자원번호","분양번호","자원명","분양신청인","분양신청일","담당자","분양수량"};
		DefaultTableModel model = new DefaultTableModel(headings, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
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
		table.setFillsViewportHeight(true);
		frame.add(jsp);
		jsp.setBounds(187, 96, 717, 384);
		
		JLabel title = new JLabel("자원분양");
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		title.setBounds(479, 10, 136, 63);
		frame.getContentPane().add(title);
		
		
		table = new JTable();
		table.setBounds(187, 96, 717, 384);
		frame.getContentPane().add(title);
		
		table_1 = new JTable();
		table_1.setBounds(237, 98, 672, 382);
		frame.getContentPane().add(table_1);
		
		JComboBox search_list = new JComboBox();
		search_list.setModel(new DefaultComboBoxModel(new String[] {"분양번호", "담당자", "자원번호", "신청인"}));
		search_list.setBounds(237, 490, 75, 23);
		frame.getContentPane().add(search_list);
		
		tf = new JTextField();
		tf.setBounds(315, 491, 355, 21);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		JButton list_search_btn = new JButton("검색");
		list_search_btn.setBounds(673, 490, 59, 23);
		frame.getContentPane().add(list_search_btn);
		
		
		JButton apply_btn = new JButton("신청하기");
		apply_btn.setBounds(735, 490, 92, 23);
		frame.getContentPane().add(apply_btn);
		apply_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				frame.setVisible(false);		
				new seed_devide_write();
				
			}
		});
	
		JButton main_btn = new JButton("메인메뉴");
		main_btn.setBounds(2, 96, 173, 106);
		frame.getContentPane().add(main_btn);
		main_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new main_view();
			}
		});
		
		
		JButton search_btn = new JButton("종자검색");
		search_btn.setBounds(2, 223, 173, 106);
		frame.getContentPane().add(search_btn);		
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new seed_search_write();
				
			}
		});
		frame.setVisible(true);
		

	}
}
