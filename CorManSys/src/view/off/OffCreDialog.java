package view.off;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import common.vo.OffVO;
import controller.I_OffController;
import controller.OffController;

public class OffCreDialog extends JDialog {

	JPanel panel;
	
	JLabel     lblName, lblClasz, lblPosition, lblDept, lblTel, lblId, lblResp, lblMemo;
	JTextField tfName , tfClasz , tfPosition , tfDept , tfTel , tfId , tfResp , tfMemo ;
	
	JButton btnChoice;
	
	I_OffController offController;
	
	public OffCreDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		lblName     = new JLabel("담당 공무원 이름 (필수)"            ); tfName     = new JTextField(20);
		lblClasz    = new JLabel("담당 공무원 직급"                   ); tfClasz    = new JTextField(20);
		lblPosition = new JLabel("담당 공무원 직위"                   ); tfPosition = new JTextField(20);
		lblDept     = new JLabel("담당 공무원 부서"                   ); tfDept     = new JTextField(20);
		lblTel      = new JLabel("담당 부서 전화 번호"                ); tfTel      = new JTextField(20);
		lblResp     = new JLabel("담당 업무"                          ); tfResp     = new JTextField(20);
		lblId       = new JLabel("담당 공무원 식별 번호 (필수 & 중복 X)"); tfId       = new JTextField(20);		
		lblMemo     = new JLabel("특이사항"                    		  ); tfMemo     = new JTextField(20);		
		
		btnChoice  = new JButton("입력");
	}
	
	public void initFrame() {
		panel = new JPanel(new GridLayout(0, 2));
		
		panel.add(lblName    ); panel.add(tfName    );
		panel.add(lblClasz   ); panel.add(tfClasz   );
		panel.add(lblPosition); panel.add(tfPosition);
		panel.add(lblDept    ); panel.add(tfDept    );
		panel.add(lblTel     ); panel.add(tfTel     );
		panel.add(lblResp    ); panel.add(tfResp    );
		panel.add(lblId      ); panel.add(tfId      );
		panel.add(lblMemo    ); panel.add(tfMemo    );
		
		add(panel    , BorderLayout.NORTH);
		add(btnChoice, BorderLayout.SOUTH);
		
		setLocation(650, 350);
		setSize    (450, 250);
		setModal   (true);
		setVisible (true);
	}
	
	public void updateData() {
		offController = new OffController();
		
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name     = tfName    .getText().trim();
				String clasz    = tfClasz   .getText().trim();
				String position = tfPosition.getText().trim();
				String dept     = tfDept    .getText().trim();
				String tel      = tfTel     .getText().trim();
				String resp     = tfResp    .getText().trim();
				int    id       = Integer.parseInt(tfId.getText().trim());
				String memo     = tfMemo    .getText().trim();
				
				OffVO offVO = new OffVO(name, clasz, position, dept, tel, resp, id, memo);
				
				offController.updateOffData(offVO);
				showMessage("데이터가 수정되었습니다.");
				setVisible(false);
			}
		});
	}

	public void createData() {	
		offController = new OffController();
		
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name     = tfName    .getText().trim();
				String clasz   = tfClasz   .getText().trim();
				String position = tfPosition.getText();
				String dept     = tfDept    .getText().trim();
				String tel      = tfTel     .getText().trim();
				String resp     = tfResp    .getText().trim();
				int    id       = Integer.parseInt(tfId.getText().trim());
				String memo     = tfMemo    .getText().trim();
				
				OffVO offVO = new OffVO(name, clasz, position, dept, tel, tel, id, memo);
				
				offController.createOffData(offVO);
				showMessage("데이터가 추가되었습니다.");
				
				tfName    .setText("");
				tfClasz   .setText("");
				tfPosition.setText("");
				tfDept    .setText("");
				tfTel     .setText("");
				tfResp    .setText("");
				tfId      .setText("");
				tfMemo    .setText("");		
			}
		});
		
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
	
}