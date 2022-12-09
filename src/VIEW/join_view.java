package VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class join_view extends JFrame {

	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JButton duplicateBtn;
	private JTextField tfUserID;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField textField;

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

		JLabel lblBirth = new JLabel("생년월일");
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

		joinCompleteBtn = new JButton("회원가입완료");
		joinCompleteBtn.setBounds(298, 420, 139, 29);
		contentPane.add(joinCompleteBtn);

		duplicateBtn = new JButton("중복");
		duplicateBtn.setBounds(350, 110, 70, 29);
		contentPane.add(duplicateBtn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(159, 366, 186, 35);
		contentPane.add(textField);

//		duplicateBtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String idstr = tfUserID.getText();
//				if (dao.isIDCheck(idstr) == true) {
//					System.out.println("중복이 있습니다.. 다시 입력하세요!");
//					// new main_view();
//					// setvisible(false);
//				} else {
//					System.out.println("사용가능한 아이디 입니다!");
//				}
//
//			}
//		});

		joinCompleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//user user = new user(tfUserID.getText(), tfPassword.getText(), tfUsername.getText(), tfBirth.getText(),
				//		tfPhone.getText());
				String idstr = tfUserID.getText();
				String passtr = tfPassword.getText();
				String Namestr = tfUsername.getText();
				String Birthstr = tfBirth.getText();
				String Phonestr = tfPhone.getText();
			//	dao.insert_user(user);

				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				dispose();

			}
		});
		setVisible(true);

	}
}
