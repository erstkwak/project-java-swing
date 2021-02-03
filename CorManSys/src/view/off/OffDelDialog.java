package view.off;

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
import common.vo.OffVO;
import controller.OffController;

public class OffDelDialog extends JDialog {
	
	JPanel panelBtn;
	
	JButton btnRead, btnDelete;
	
	JTable     table;
	TableModel model;
	
	String[][] offCols;
	String[]   offColsNames = {"이름", "직급", "직위", "부서 이름", "부서 전화번호", "담당 업무", "식별 번호", "특이사항"};

	OffController offController;
	
	public OffDelDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		
		btnRead   = new JButton("조회");
		btnDelete = new JButton("삭제");
	}
	
	public void initFrame() {
		offController = new OffController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<OffVO> offList = new ArrayList<OffVO>();
				
				offList = offController.listOffData();
				loadData(offList);
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<OffVO> offList = new ArrayList<OffVO>();
				OffVO            offVO   = new OffVO();
				
				int close = table.getRowCount();

				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				String id = (String) data.getValueAt(row, 6);
				offVO.setId(Integer.parseInt(id));
				offController.deleteOffData(offVO);
				
				showMessage("데이터가 삭제되었습니다.");
				
				if (close == 1 && row == 0) {
					setVisible(false);
				}
				
				offList = offController.listOffData();
				loadData(offList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		panelBtn.add(btnDelete);

		add(panelBtn , BorderLayout.SOUTH);
		
		offCols = new String[0][8];
		model = new TableModel(offCols, offColsNames);
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
			
			offCols[i][0] = offVO.getName();
			offCols[i][1] = offVO.getClasz();
			offCols[i][2] = offVO.getPosition();
			offCols[i][3] = offVO.getDept();
			offCols[i][4] = offVO.getTel();
			offCols[i][5] = offVO.getResp();
			offCols[i][6] = Integer.toString(offVO.getId());
			offCols[i][7] = offVO.getMemo();
			
			model = new TableModel(offCols, offColsNames);
			table.setModel(model);
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
	}


}