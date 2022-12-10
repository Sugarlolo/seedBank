package VIEW;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class main_view extends JFrame {
	
	public main_view() {
		setTitle("종자은행메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x 누르면 프로세스 종료		
		Container Main_CP = getContentPane(); // 컨텐트팬 생성
		setSize(400, 800);
		Main_CP.setLayout(null); // 화면구성 자유롭게 세팅
		centerWindow(this);
		setVisible(true); // 메인프레임 보이게 하기(true)

		JButton btn1, btn2;

		Main_CP.add(btn1 = new JButton("종자검색"));
		btn1.setBounds(66, 200, 100, 100); // 가로위치,세로위치,폭,넓이

		Main_CP.add(btn2 = new JButton("자원분양"));
		
		//직원 자원관리 탭
		JButton btn3 = new JButton("자원관리...");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_ManagementUI();
				setVisible(true);
			}
		});
		btn3.setBounds(150, 332, 97, 23);
		getContentPane().add(btn3);
		btn2.setBounds(220, 200, 100, 100);


		//  종자검색 버튼처리
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_search_write();
				dispose();
				
			}
		});

		// 자원분양 버튼 처리
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seed_devide_view(); 
				dispose();
			}
		});
	}

	// 모니터 중간에 프레임 출력
	public static void centerWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}
}