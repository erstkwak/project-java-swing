package view.iso;

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
import common.vo.IsoVO;
import controller.I_IsoController;
import controller.IsoController;

public class IsoCreDialog extends JDialog {

	JPanel     panel;
	JLabel     lblName, lblGender, lblAge, lblPhone, lblSido, lblGugun, lblAddress, lblMemo;
	JTextField tfName , tfGender , tfAge , tfPhone , tfSido , tfGugun , tfAddress , tfMemo ;
	JButton    btnChoice;
	
	I_IsoController isoController;
	
	public IsoCreDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		lblName    = new JLabel("자가격리자 이름 (필수)"    ); tfName    = new JTextField(20);
		lblGender  = new JLabel("자가격리자 성별"           ); tfGender  = new JTextField(20);
		lblAge     = new JLabel("자가격리자 나이 (숫자)"    ); tfAge     = new JTextField(20);
		lblPhone   = new JLabel("자가격리자 전화번호 (필수 & 중복 X)"); tfPhone   = new JTextField(20);
		lblSido    = new JLabel("자가격리자 시도"           ); tfSido    = new JTextField(20);
		lblGugun   = new JLabel("자가격리자 구군"           ); tfGugun   = new JTextField(20);
		lblAddress = new JLabel("자가격리자 상세주소"       ); tfAddress = new JTextField(20);		
		lblMemo    = new JLabel("특이사항"                  ); tfMemo    = new JTextField(20);		
		
		btnChoice  = new JButton("입력");
	}
	
	public void initFrame() {
		panel = new JPanel(new GridLayout(0, 2));
		
		panel.add(lblName   ); panel.add(tfName   );
		panel.add(lblGender ); panel.add(tfGender );
		panel.add(lblAge    ); panel.add(tfAge    );
		panel.add(lblPhone  ); panel.add(tfPhone  );
		panel.add(lblSido   ); panel.add(tfSido   );
		panel.add(lblGugun  ); panel.add(tfGugun  );
		panel.add(lblAddress); panel.add(tfAddress);
		panel.add(lblMemo   ); panel.add(tfMemo   );
		
		add(panel    , BorderLayout.NORTH);
		add(btnChoice, BorderLayout.SOUTH);
		
		setLocation(650, 350);
		setSize    (450, 250);
		setModal   (true);
		setVisible (true);
	}
	
	public void updateData() {
		isoController = new IsoController();
		
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name    = tfName   .getText().trim();
				String gender  = tfGender .getText().trim();
				int    age     = Integer.parseInt(tfAge.getText().trim());
				String phone   = tfPhone  .getText().trim();
				String sido    = tfSido   .getText().trim();
				String gugun   = tfGugun  .getText().trim();
				String address = tfAddress.getText().trim();
				String memo    = tfMemo   .getText().trim();
				
				IsoVO isoVO = new IsoVO(name, gender, age, phone, sido, gugun, address, memo);
				
				isoController.updateIsoData(isoVO);
				showMessage("데이터가 수정되었습니다 !");
				setVisible(false);
			}
		});
	}

	public void createData() {	
		isoController = new IsoController();
		
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name    = tfName   .getText().trim();
				String gender  = tfGender .getText().trim();
				int    age     = Integer.parseInt(tfAge.getText().trim());
				String phone   = tfPhone  .getText().trim();
				String sido    = tfSido   .getText().trim();
				String gugun   = tfGugun  .getText().trim();
				String address = tfAddress.getText().trim();
				String memo    = tfMemo   .getText().trim();
				
				IsoVO isoVO = new IsoVO(name, gender, age, phone, sido, gugun, address, memo);
				
				isoController.createIsoData(isoVO);
				showMessage("데이터가 추가되었습니다 !");
				
				tfName   .setText("");
				tfGender .setText("");
				tfAge    .setText("");
				tfPhone  .setText("");
				tfSido   .setText("");
				tfGugun  .setText("");
				tfAddress.setText("");
				tfMemo   .setText("");		
			}
		});
		
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
	
}