package VIEW;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DB_Conn_Query;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class seed_search_write extends JFrame {
	private JPanel contentPane;
	private JLabel lblJoin;
	JButton joinCompleteBtn;
	private JTextField tfFrom;
	private JTextField tfSname;
	private JFrame frame;
	public String ID;
	DB_Conn_Query db = new DB_Conn_Query();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					seed_search_write window = new seed_search_write();
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
	public seed_search_write(String id) {
		ID=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("자원정보검색");
		frame.setBounds(100, 100, 463, 526);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("메인 메뉴");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new main_view(ID);
            }
        });
        btnNewButton.setBounds(249, 242, 95, 23);
        contentPane.add(btnNewButton);

		// 누락되어있었음
		frame.setVisible(true);
		frame.setSize(1043, 321);

		lblJoin = new JLabel("자원정보검색");
		lblJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblJoin.setBounds(159, 43, 148, 20);
		contentPane.add(lblJoin);

		JLabel lblSname = new JLabel("자원명");
		lblSname.setBounds(68, 106, 69, 20);
		contentPane.add(lblSname);

		JLabel lblFrom = new JLabel("원산지");
		lblFrom.setBounds(68, 156, 52, 15);
		contentPane.add(lblFrom);

		JLabel lblDiv = new JLabel("자원구분");
		lblDiv.setBounds(68, 210, 69, 20);
		contentPane.add(lblDiv);

		tfSname = new JTextField();
		tfSname.setColumns(10);
		tfSname.setBounds(158, 99, 186, 35);
		contentPane.add(tfSname);

		tfFrom = new JTextField();
		tfFrom.setColumns(10);
		tfFrom.setBounds(158, 146, 186, 35);
		contentPane.add(tfFrom);

		JButton btnsearch = new JButton("찾기");
		btnsearch.setBounds(253, 209, 89, 23);
		contentPane.add(btnsearch);
		
		JComboBox cb_list = new JComboBox();
		cb_list.setModel(new DefaultComboBoxModel(new String[] {"약료작물", "기호료작물", "섬유료작물", "향료작물", "당료작물", "유료작물", "식용작물"}));
		cb_list.setBounds(159, 209, 95, 23);
		contentPane.add(cb_list);
		
		JLabel lblJoin_1 = new JLabel("자원목록");
		lblJoin_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblJoin_1.setBounds(620, 43, 148, 20);
		contentPane.add(lblJoin_1);
		
		String[] headings = new String[] {"자원명","수량","원산지","수집지","자원구분","평균수명"};
		DefaultTableModel model = new DefaultTableModel(headings, 0);
		JTable table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(jsp);
		jsp.setBounds(422, 73, 568, 180);
		
		//찾기 버튼 
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnameStr = tfSname.getText();
				String FromStr = tfFrom.getText();
				String checksearch = cb_list.getSelectedItem().toString();
				// PreparedStatement 사용
				

				String sql = "select 자원명,수량,원산지,수집지,자원구분,평균수명 from 종자 where 자원명 = (?) and 원산지 = (?) and 자원구분 = (?)";				
				
				try {
					String row[] = new String[6];
					PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
					pstmt.setString(1,SnameStr);
					pstmt.setString(2,FromStr);
					pstmt.setString(3,checksearch);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {			
						row[0] = rs.getString(1);
						row[1] = Integer.toString(rs.getInt(2)); 
						row[2] = rs.getString(3);
						row[3] = rs.getString(4);
						row[4] = rs.getString(5);
						row[5] = Integer.toString(rs.getInt(6)); 
						model.addRow(row);
					}
					rs.close();
					pstmt.close();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
	}
}

