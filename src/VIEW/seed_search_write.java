package VIEW;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class seed_search_write extends JFrame {
	   private JPanel contentPane;
	   private JLabel lblJoin;
	   private JButton joinCompleteBtn;
	   private JTextField tfUserID;
	   private JTextField tfUsername;
	   private JTextField tfPassword;
	   private JTextField tfBirth;
	   private JTextField tfPhone;
	   private JFrame frame;

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
	    frame.setSize(600,500);
	    
	    lblJoin = new JLabel("자원정보검색");
	    lblJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
	      lblJoin.setBounds(159, 43, 148, 20);
	      contentPane.add(lblJoin);
	      
	      JLabel lblUsername = new JLabel("작물명");
	      lblUsername.setBounds(69, 113, 69, 20);
	      contentPane.add(lblUsername);

	      JLabel lblPassword = new JLabel("자원명");
	      lblPassword.setBounds(69, 163, 69, 20);
	      contentPane.add(lblPassword);

	      JLabel lblName = new JLabel("원산지");
	      lblName.setBounds(69, 213, 52, 15);
	      contentPane.add(lblName);

	      JLabel lblBirth = new JLabel("원산지");
	      lblBirth.setBounds(69, 267, 69, 20);
	      contentPane.add(lblBirth);

	      JLabel lblPhone = new JLabel("수집지");
	      lblPhone.setBounds(69, 319, 69, 20);
	      contentPane.add(lblPhone);
	      
	      JLabel lblteam = new JLabel("자원구분");
	      lblteam.setBounds(69, 373, 69, 20);
	      contentPane.add(lblteam);

	      tfUserID = new JTextField();
	      tfUserID.setColumns(10);
	      tfUserID.setBounds(159, 106, 186, 35);
	      contentPane.add(tfUserID);

	      tfPassword = new JTextField();
	      tfPassword.setColumns(10);
	      tfPassword.setBounds(159, 203, 186, 35);
	      contentPane.add(tfPassword);

	      tfUsername = new JTextField();
	      tfUsername.setColumns(10);
	      tfUsername.setBounds(159, 257, 186, 35);
	      contentPane.add(tfUsername);

	      tfBirth = new JTextField();
	      tfBirth.setColumns(10);
	      tfBirth.setBounds(159, 156, 186, 35);
	      contentPane.add(tfBirth);

	      tfPhone = new JTextField();
	      tfPhone.setColumns(10);
	      tfPhone.setBounds(159, 312, 186, 35);
	      contentPane.add(tfPhone);

	      joinCompleteBtn = new JButton("찾기");
	      joinCompleteBtn.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.setVisible(false);
	      		new seed_search_view();
	      	}
	      });
	      joinCompleteBtn.setBounds(269, 450, 139, 29);
	      contentPane.add(joinCompleteBtn);
	      
	      JCheckBox chckbxNewCheckBox = new JCheckBox("약료작물");
	      chckbxNewCheckBox.setBounds(146, 372, 111, 23);
	      contentPane.add(chckbxNewCheckBox);
	      
	      JCheckBox chckbxNewCheckBox_1 = new JCheckBox("기호료작물");
	      chckbxNewCheckBox_1.setBounds(269, 421, 111, 23);
	      contentPane.add(chckbxNewCheckBox_1);
	      
	      JCheckBox chckbxNewCheckBox_2 = new JCheckBox("섬유로작물");
	      chckbxNewCheckBox_2.setBounds(146, 425, 111, 23);
	      contentPane.add(chckbxNewCheckBox_2);
	      
	      JCheckBox chckbxNewCheckBox_3 = new JCheckBox("향료작물");
	      chckbxNewCheckBox_3.setBounds(269, 372, 111, 23);
	      contentPane.add(chckbxNewCheckBox_3);
	      
	      JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("당료작물");
	      chckbxNewCheckBox_2_1.setBounds(146, 397, 111, 23);
	      contentPane.add(chckbxNewCheckBox_2_1);
	      
	      JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("유료작물");
	      chckbxNewCheckBox_1_1.setBounds(269, 397, 111, 23);
	      contentPane.add(chckbxNewCheckBox_1_1);
	      
	      JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("식용작물");
	      chckbxNewCheckBox_2_2.setBounds(146, 453, 111, 23);
	      contentPane.add(chckbxNewCheckBox_2_2);
	      
	      
	}
	
}
