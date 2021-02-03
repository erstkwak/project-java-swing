package view.iso;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import common.table.TableModel;
import common.vo.IsoVO;
import controller.IsoController;

public class IsoUpdDialog extends JDialog {
	
	JPanel     panelBtn;
	JButton    btnRead;
	JTable     table;
	TableModel model;
	
	String[][] isoCols;
	String[]   isoColsNames = {"이름", "성별", "나이", "전화번호", "시도", "구군", "상세주소", "특이사항"};

	IsoController isoController;
	
	public static String exPhone = null;
	
	public IsoUpdDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn = new JPanel();
		table    = new JTable();
		btnRead  = new JButton("조회");
	}
	
	public void initFrame() {
		isoController = new IsoController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<IsoVO> isoList = new ArrayList<IsoVO>();
				IsoVO            isoVO   = new IsoVO();
				
				isoList = isoController.listIsoData();
				loadData(isoList);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<IsoVO> isoList = new ArrayList<IsoVO>();
				IsoVO            isoVO   = new IsoVO();
				
				final IsoCreDialog ic = new IsoCreDialog("자가격리자 명단 수정 화면");
				
				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				ic.tfName   .setText((String) data.getValueAt(row, 0));
				ic.tfGender .setText((String) data.getValueAt(row, 1));
				ic.tfAge    .setText((String) data.getValueAt(row, 2));
				ic.tfPhone  .setText((String) data.getValueAt(row, 3));
				ic.tfSido   .setText((String) data.getValueAt(row, 4));
				ic.tfGugun  .setText((String) data.getValueAt(row, 5));
				ic.tfAddress.setText((String) data.getValueAt(row, 6));
				ic.tfMemo   .setText((String) data.getValueAt(row, 7));
				exPhone = (String) data.getValueAt(row, 3);
				
				ic.updateData();
				ic.initFrame();
				isoList = isoController.listIsoData();
				loadData(isoList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		
		add(panelBtn, BorderLayout.SOUTH);
		
		isoCols = new String[0][8];
		model   = new TableModel(isoCols, isoColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation(400, 250);
		setSize    (1000, 550);
		setModal   (true);
		setVisible (true);
	}

	private void loadData(ArrayList<IsoVO> isoList) {
		isoCols = new String[isoList.size()][8];
		
		for (int i = 0; i < isoList.size(); i++) {
			IsoVO isoVO = isoList.get(i);
			
			isoCols[i][0] = isoVO.getName   ();
			isoCols[i][1] = isoVO.getGender ();
			isoCols[i][2] = Integer.toString(isoVO.getAge());
			isoCols[i][3] = isoVO.getPhone  ();
			isoCols[i][4] = isoVO.getSido   ();
			isoCols[i][5] = isoVO.getGugun  ();
			isoCols[i][6] = isoVO.getAddress();
			isoCols[i][7] = isoVO.getMemo   ();
			
			model = new TableModel(isoCols, isoColsNames);
			table.setModel(model);
		}
	}

}