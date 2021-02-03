package view.iso;

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
import common.vo.IsoVO;
import controller.IsoController;

public class IsoDelDialog extends JDialog {
	
	JPanel     panelBtn;
	JButton    btnRead, btnDelete;
	JTable     table;
	TableModel model;
	
	String[][] isoCols;
	String[]   isoColsNames = {"이름", "성별", "나이", "전화번호", "시도", "구군", "상세주소", "특이사항"};

	IsoController isoController;
	
	public IsoDelDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		btnRead   = new JButton("조회");
		btnDelete = new JButton("삭제");
	}
	
	public void initFrame() {
		isoController = new IsoController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<IsoVO> isoList = new ArrayList<IsoVO>();
				
				isoList = isoController.listIsoData();
				loadData(isoList);
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<IsoVO> isoList = new ArrayList<IsoVO>();
				IsoVO            isoVO   = new IsoVO();
				
				int close = table.getRowCount();

				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				String phone = (String) data.getValueAt(row, 3);
				isoVO.setPhone(phone);
				isoController.deleteIsoData(isoVO);
				
				showMessage("데이터가 삭제되었습니다 !");
				
				if (close == 1 && row == 0) {
					setVisible(false);
				}
				
				isoList = isoController.listIsoData();
				loadData(isoList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		panelBtn.add(btnDelete);

		add(panelBtn , BorderLayout.SOUTH);
		
		isoCols = new String[0][8];
		model = new TableModel(isoCols, isoColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation(400 , 250);
		setSize    (1000, 550);
		setModal   (true);
		setVisible (true);
	}

	private void loadData(ArrayList<IsoVO> isoList) {
		isoCols = new String[isoList.size()][8];
		
		for (int i = 0; i < isoList.size(); i++) {
			IsoVO isoVO = isoList.get(i);
			
			isoCols[i][0] = isoVO.getName();
			isoCols[i][1] = isoVO.getGender();
			isoCols[i][2] = Integer.toString(isoVO.getAge());
			isoCols[i][3] = isoVO.getPhone();
			isoCols[i][4] = isoVO.getSido();
			isoCols[i][5] = isoVO.getGugun();
			isoCols[i][6] = isoVO.getAddress();
			isoCols[i][7] = isoVO.getMemo();
			
			model = new TableModel(isoCols, isoColsNames);
			table.setModel(model);
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}

}