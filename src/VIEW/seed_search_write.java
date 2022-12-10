package VIEW;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	public seed_search_write() {
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

		// 누락되어있었음
		frame.setVisible(true);
		frame.setSize(486, 421);

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
		cb_list.setModel(new DefaultComboBoxModel(new String[] {"약료작물", "기호료작물", "섬유로작물", "향료작물", "당료작물", "유료작물", "식용작물"}));
		cb_list.setBounds(159, 209, 95, 23);
		contentPane.add(cb_list);
		
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnameStr = tfSname.getText();
				String FromStr = tfFrom.getText();
				String checksearch = cb_list.getSelectedItem().toString();
				// PreparedStatement 사용

				frame.setVisible(false);
				new seed_search_view();
			}
		});



	}
}
