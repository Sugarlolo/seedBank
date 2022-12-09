package VIEW;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class seed_search_view {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-6,1039
	 */
	private JTextField tf;
	private JTable table_1;
	DefaultTableModel model;
	JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seed_search_view window = new seed_search_view();
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
	public seed_search_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("자원현황");
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("자원목록");
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		title.setBounds(479, 10, 136, 63);
		frame.getContentPane().add(title);
		
		
		String[] headings = new String[] {"자원번호","자원명","수량","원산지","자원구분","평균수명"};
		Object[][] data = new Object[][] {
			{"1","옥수수","4500","멕시코","식용작물","3"},
			{"2","콩","4500","멕시코","식용작물","4"},
			{"3","팥","4500","멕시코","식용작물","5"}
		};
		table = new JTable(data, headings);
		table.setFillsViewportHeight(true);
		frame.add(new JScrollPane(table));
		frame.add(table);
		
		
		table.setBounds(187, 96, 717, 384);
		frame.getContentPane().add(title);
		
		
		
		

		
		tf = new JTextField();
		tf.setBounds(315, 491, 355, 21);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		//검색 목록
		String[] search_list = { "자원명", "원산지","자원구분","평균수명" };
		JComboBox search = new JComboBox(search_list);
		search.setBounds(210, 491, 100, 23);
		frame.add(search);
		
		
		//검색버튼
		JButton list_search_btn = new JButton("검색");
		list_search_btn.setBounds(673, 490, 59, 23);
		frame.getContentPane().add(list_search_btn);
		

		//신청버튼
		JButton apply_btn = new JButton("신청하기");
		apply_btn.setBounds(735, 490, 92, 23);
		frame.getContentPane().add(apply_btn);		
		
		
		//-----------------왼쪽 메뉴-----------------
		JButton main_btn = new JButton("메인메뉴");
		main_btn.setBounds(2, 96, 173, 106);
		frame.getContentPane().add(main_btn);
		
		main_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main_view();
				frame.setVisible(false);
			}
		});
		
		JButton search_btn = new JButton("종자검색");
		search_btn.setBounds(2, 223, 173, 106);
		frame.getContentPane().add(search_btn);
		
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_search_write();
				frame.setVisible(false);
				
			}
		});
		//------------------------------------------

	}
}
