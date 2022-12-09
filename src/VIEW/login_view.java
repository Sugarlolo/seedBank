package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.loginSystem;
import DB.DB_Conn_Query;

public class login_view extends JFrame {
	private Main main;
	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;
	JPanel panel;

	public static void main(String[] args) {
		new login_view();
	}

	public login_view() {

		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		placeLoginPanel(panel);

		getContentPane().add(panel);
		


		setVisible(true);
		setSize(300, 200);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);
		

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);

		btnInit = new JButton("Join");

		btnInit.setBounds(10, 80, 100, 25);

		panel.add(btnInit);

		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new join_view();
				setVisible(false);
			}
		});

		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 80, 100, 25);
		panel.add(btnLogin);
		
		String[] login_list = { "일반회원", "직원" };
		JComboBox login = new JComboBox(login_list);
		login.setBounds(10, 107, 100, 23);
		panel.add(login);
		

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = userText.getText();
				String pw = String.valueOf(passText.getPassword());
				
				loginSystem login = new loginSystem();
				String m = login.loginSystem(id,pw);
				if(m==null) {
					JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					new main_view();
					dispose();
				}
				
				
				
			}
		});
	}
}