package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import chatting.model.MemberDTO;
import chatting.service.IMemberService;
import chatting.service.LayoutService;

public class JsTalkSingOutMember extends JFrame implements LayoutService {
	private JLabel lblMainImage;
	private JButton btnMemberOut;
	private String id;
	private IMemberService service;
	
	public JsTalkSingOutMember(String id, IMemberService service) {
		super("회원가입 탈퇴");
		this.id=id;
		this.service=service;
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		setSize(300,400);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void createComponent() {
		Image image=Toolkit.getDefaultToolkit().getImage("src/chatting/텔레그램이미지(in).jpg");
		image=image.getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		Icon icon = new ImageIcon(image);
		lblMainImage = new JLabel(icon, JLabel.CENTER);
		lblMainImage.setPreferredSize(new Dimension(300, 400));
		lblMainImage.setOpaque(true);
		btnMemberOut = new JButton("회원가입 탈퇴");
		
		
	}

	@Override
	public void addComponent() {
		JPanel pnlAll = new JPanel(null);
		btnMemberOut.setBounds(70, 280, 150, 50);
		pnlAll.add("South",btnMemberOut);
		pnlAll.setBackground(Color.WHITE);
		lblMainImage.setBounds(0, 0, 300, 400);
		pnlAll.add(lblMainImage);
		
		
		
		add(pnlAll);
	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		btnMemberOut.addActionListener(handler);
	}
	
	ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==btnMemberOut) {
				int option=JOptionPane.showConfirmDialog(
						btnMemberOut, 
						"정말로 회원 탈퇴 하시겠습니까?", 
						"회원탈퇴", 
						JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {//회원가입탈퇴를 눌렀을 시
					MemberDTO dto = new MemberDTO(id.toString().trim(), null, null, null, null, null, null);
					try {
						service.delete(dto);
						JOptionPane.showMessageDialog(JsTalkSingOutMember.this, "회원탈퇴가 완료되었습니다");
						System.exit(0);
					} catch (Exception e1) {}
				}
			}///
		}
	};
}////class
