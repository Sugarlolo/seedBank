package VIEW;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class seed_devide_view {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-6,1039
	 */
	private JTable table;
	private JTextField tf;
	private JTable table_1;

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
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(907, 96, 17, 384);
		frame.getContentPane().add(scrollBar);
		
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
