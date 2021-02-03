package view.off;

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
import common.vo.OffVO;
import controller.OffController;

public class OffUpdDialog extends JDialog {
	
	JPanel panelBtn;
	
	JButton btnRead;
	
	JTable     table;
	TableModel model;
	
	String[][] offCols;
	String[]   offColsNames = {"이름", "직급", "직위", "부서 이름", "부서 전화번호", "담당 업무", "식별 번호", "특이사항"};

	OffController offController;
	
	public static String exId = null;
	
	public OffUpdDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		
		btnRead   = new JButton("조회");
	}
	
	public void initFrame() {
		offController = new OffController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<OffVO> offList = new ArrayList<OffVO>();
				OffVO            offVO   = new OffVO();
				
				offList = offController.listOffData();
				loadData(offList);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<OffVO> offList = new ArrayList<OffVO>();
				OffVO            offVO   = new OffVO();
				
				final OffCreDialog oc = new OffCreDialog("담당 공무원 수정 화면");
				
				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				oc.tfName    .setText((String) data.getValueAt(row, 0));
				oc.tfClasz   .setText((String) data.getValueAt(row, 1));
				oc.tfPosition.setText((String) data.getValueAt(row, 2));
				oc.tfDept    .setText((String) data.getValueAt(row, 3));
				oc.tfTel     .setText((String) data.getValueAt(row, 4));
				oc.tfResp    .setText((String) data.getValueAt(row, 5));
				oc.tfId      .setText((String) data.getValueAt(row, 6));
				oc.tfMemo    .setText((String) data.getValueAt(row, 7));
				exId = (String) data.getValueAt(row, 6);
				
				oc.updateData();
				oc.initFrame();
				offList = offController.listOffData();
				loadData(offList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		
		add(panelBtn, BorderLayout.SOUTH);
		
		offCols = new String[0][8];
		model   = new TableModel(offCols, offColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation(400, 250);
		setSize    (1000, 550);
		setModal   (true);
		setVisible (true);
	}

	private void loadData(ArrayList<OffVO> offList) {
		offCols = new String[offList.size()][8];
		
		for (int i = 0; i < offList.size(); i++) {
			OffVO offVO = offList.get(i);
			
			offCols[i][0] = offVO.getName    ();
			offCols[i][1] = offVO.getClasz   ();
			offCols[i][2] = offVO.getPosition();
			offCols[i][3] = offVO.getDept    ();
			offCols[i][4] = offVO.getTel     ();
			offCols[i][5] = offVO.getResp    ();
			offCols[i][6] = Integer.toString(offVO.getId());
			offCols[i][7] = offVO.getMemo    ();
			
			model = new TableModel(offCols, offColsNames);
			table.setModel(model);
		}
	}

}