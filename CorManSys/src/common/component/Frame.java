package common.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.DeaDAO;
import model.IsoDAO;
import model.PatDAO;
import model.TreDAO;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Frame {
	
	public static JFrame frame;
	
	JPanel  panel;
	JLabel  lblTitle;
	JLabel  lblHead1, lblHead2, lblHead3, lblHead4;
	JLabel  lblCont1, lblCont2, lblCont3, lblCont4; 
	JButton btnRefresh;
	
	public Frame() {
		frame = new JFrame("코로나 위기 대응 관리 시스템");
		
		initFrame();
	}
	
	public void initFrame() {
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		frame.setIconImage(icon);
		
		final PatDAO patDAO = new PatDAO();
		final IsoDAO isoDAO = new IsoDAO();
		final TreDAO treDAO = new TreDAO();
		final DeaDAO deaDAO = new DeaDAO();
		
		String count1 = Integer.toString(patDAO.listPatData().size()) + " 명";
		String count2 = Integer.toString(isoDAO.listIsoData().size()) + " 명";
		String count3 = Integer.toString(treDAO.listTreData().size()) + " 명";
		String count4 = Integer.toString(deaDAO.listDeaData().size()) + " 명";
		
		lblTitle = new JLabel("코로나19 현황");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(210, 105, 30));
		lblTitle.setBounds(400, 30, 200, 60);
		
		lblHead1 = new JLabel("확진자 수");
		lblHead1.setBounds(0, 100, 250, 150);
		lblHead1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblHead1.setForeground(new Color(210, 105, 30));
		lblHead1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHead2 = new JLabel("자가격리자 수");
		lblHead2.setBounds(250, 100, 250, 150);
		lblHead2.setForeground(new Color(210, 105, 30));
		lblHead2.setFont(new Font("굴림", Font.PLAIN, 30));
		lblHead2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHead3 = new JLabel("피검사자 수");
		lblHead3.setBounds(500, 100, 250, 150);
		lblHead3.setForeground(new Color(210, 105, 30));
		lblHead3.setFont(new Font("굴림", Font.PLAIN, 30));
		lblHead3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHead4 = new JLabel("사망자 수");
		lblHead4.setBounds(750, 100, 250, 150);
		lblHead4.setForeground(new Color(210, 105, 30));
		lblHead4.setFont(new Font("굴림", Font.PLAIN, 30));
		lblHead4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCont1 = new JLabel("수치1");
		lblCont1.setBounds(0, 250, 250, 150);
		lblCont1.setForeground(new Color(255, 69, 0));
		lblCont1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblCont1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCont2 = new JLabel("수치2");
		lblCont2.setBounds(250, 250, 250, 150);
		lblCont2.setForeground(new Color(255, 69, 0));
		lblCont2.setFont(new Font("굴림", Font.PLAIN, 30));
		lblCont2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCont3 = new JLabel("수치3");	
		lblCont3.setBounds(500, 250, 250, 150);
		lblCont3.setForeground(new Color(255, 69, 0));
		lblCont3.setFont(new Font("굴림", Font.PLAIN, 30));
		lblCont3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCont4 = new JLabel("수치4");
		lblCont4.setBounds(750, 250, 250, 150);
		lblCont4.setForeground(new Color(255, 69, 0));
		lblCont4.setFont(new Font("굴림", Font.PLAIN, 30));
		lblCont4.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnRefresh = new JButton("새로고침");
		btnRefresh.setIcon(null);
		btnRefresh.setForeground(new Color(210, 105, 30));
		btnRefresh.setBounds(400, 420, 200, 30);
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCont1.setText(Integer.toString(patDAO.listPatData().size()) + " 명");
				lblCont2.setText(Integer.toString(isoDAO.listIsoData().size()) + " 명");
				lblCont3.setText(Integer.toString(treDAO.listTreData().size()) + " 명");
				lblCont4.setText(Integer.toString(deaDAO.listDeaData().size()) + " 명");
			}
		});
		
		lblCont1.setText(count1);
		lblCont2.setText(count2);
		lblCont3.setText(count3);
		lblCont4.setText(count4);
		
		panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setLayout(null);
		
		panel.add(lblTitle);
		
		panel.add(lblHead1);
		panel.add(lblHead2);
		panel.add(lblHead3);
		panel.add(lblHead4);
		
		panel.add(lblCont1);
		panel.add(lblCont2);
		panel.add(lblCont3);
		panel.add(lblCont4);
		
		panel.add(btnRefresh);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setJMenuBar(MenuBar.menuBar);
		frame.setLocation(400 , 250);
		frame.setSize    (1000, 550);
		frame.setVisible (true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}