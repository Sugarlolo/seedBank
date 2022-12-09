package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class seed_devide_write {

	private JFrame frame;
	private JTextField textField;

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
		frame.setBounds(100, 100, 600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel Label = new JLabel("신청내용");
		Label.setBounds(153, 23, 53, 15);
		frame.getContentPane().add(Label);
		
		textField = new JTextField();
		textField.setBounds(218, 20, 219, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 57, 516, 413);
		frame.getContentPane().add(textArea);
		
		
		//등록버튼
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(145, 493, 95, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_devide_view();
				frame.setVisible(false);
			}
		});
		
		
		//썻던 문장 초기화 하고 다시 쓸수있게
		JButton btnNewButton_1 = new JButton("초기화");
		btnNewButton_1.setBounds(252, 493, 95, 23);
		frame.getContentPane().add(btnNewButton_1);
		
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		//종료누르면 분양게시판?으로 넘어가기
		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.setBounds(359, 493, 95, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_devide_view();
				frame.setVisible(false);
			}
		});
		frame.setVisible(true);

	}
}
