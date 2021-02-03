package view.dea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import common.table.TableModel;
import common.vo.DeaVO;
import controller.DeaController;

public class DeaDelDialog extends JDialog {
	
	JPanel     panelBtn;
	JButton    btnRead, btnDelete;
	JTable     table;
	TableModel model;
	
	String[][] deaCols;
	String[]   deaColsNames = {"이름", "성별", "나이", "전화번호", "시도", "구군", "상세주소", "특이사항"};

	DeaController deaController;
	
	public DeaDelDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		btnRead   = new JButton("조회");
		btnDelete = new JButton("삭제");
	}
	
	public void initFrame() {
		deaController = new DeaController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<DeaVO> deaList = new ArrayList<DeaVO>();
				
				deaList = deaController.listDeaData();
				loadData(deaList);
			}
		});
				
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<DeaVO> deaList = new ArrayList<DeaVO>();
				DeaVO            deaVO   = new DeaVO();
				
				int close = table.getRowCount();
				
				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				String phone = (String) data.getValueAt(row, 3);
				deaVO.setPhone(phone);
				deaController.deleteDeaData(deaVO);
				
				showMessage("데이터가 삭제되었습니다 !");
				
				if (close == 1 && row == 0) {
					setVisible(false);
				}
				
				deaList = deaController.listDeaData();
				loadData(deaList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		panelBtn.add(btnDelete);

		add(panelBtn, BorderLayout.SOUTH);
		
		deaCols = new String[0][8];
		model = new TableModel(deaCols, deaColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation (400 , 250);
		setSize     (1000, 550);
		setModal    (true);
		setVisible  (true);
	}

	private void loadData(ArrayList<DeaVO> deaList) {
		deaCols = new String[deaList.size()][8];
		
		for (int i = 0; i < deaList.size(); i++) {
			DeaVO deaVO = deaList.get(i);
			
			deaCols[i][0] = deaVO.getName();
			deaCols[i][1] = deaVO.getGender();
			deaCols[i][2] = Integer.toString(deaVO.getAge());
			deaCols[i][3] = deaVO.getPhone();
			deaCols[i][4] = deaVO.getSido();
			deaCols[i][5] = deaVO.getGugun();
			deaCols[i][6] = deaVO.getAddress();
			deaCols[i][7] = deaVO.getMemo();
			
			model = new TableModel(deaCols, deaColsNames);
			table.setModel(model);
		}
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
	
}