package view.pat;

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
import common.vo.PatVO;
import controller.PatController;

public class PatDelDialog extends JDialog {
	
	JPanel panelBtn;
	
	JButton btnRead, btnDelete;
	
	JTable     table;
	TableModel model;
	
	String[][] patCols;
	String[]   patColsNames = {"이름", "성별", "나이", "전화번호", "시도", "구군", "상세주소", "특이사항"};

	PatController patController;
	
	public PatDelDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		
		btnRead   = new JButton("조회");
		btnDelete = new JButton("삭제");
	}
	
	public void initFrame() {
		patController = new PatController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<PatVO> patList = new ArrayList<PatVO>();
				
				patList = patController.listPatData();
				loadData(patList);
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<PatVO> patList = new ArrayList<PatVO>();
				PatVO            patVO   = new PatVO();
				
				int close = table.getRowCount();

				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				String phone = (String) data.getValueAt(row, 3);
				patVO.setPhone(phone);
				patController.deletePatData(patVO);
				
				showMessage("데이터가 삭제되었습니다 !");
				
				if (close == 1 && row == 0) {
					setVisible(false);
				}
				
				patList = patController.listPatData();
				loadData(patList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		panelBtn.add(btnDelete);

		add(panelBtn, BorderLayout.SOUTH);
		
		patCols = new String[0][8];
		model = new TableModel(patCols, patColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation(400, 250);
		setSize    (1000, 550);
		setModal   (true);
		setVisible (true);
	}

	private void loadData(ArrayList<PatVO> patList) {
		patCols = new String[patList.size()][8];
		
		for (int i = 0; i < patList.size(); i++) {
			PatVO patVO = patList.get(i);
			
			patCols[i][0] = patVO.getName();
			patCols[i][1] = patVO.getGender();
			patCols[i][2] = Integer.toString(patVO.getAge());
			patCols[i][3] = patVO.getPhone();
			patCols[i][4] = patVO.getSido();
			patCols[i][5] = patVO.getGugun();
			patCols[i][6] = patVO.getAddress();
			patCols[i][7] = patVO.getMemo();
			
			model = new TableModel(patCols, patColsNames);
			table.setModel(model);
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}

}