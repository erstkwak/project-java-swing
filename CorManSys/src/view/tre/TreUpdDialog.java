package view.tre;

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
import common.vo.TreVO;
import controller.TreController;

public class TreUpdDialog extends JDialog {
	
	JPanel     panelBtn;
	JButton    btnRead;
	JTable     table;
	TableModel model;
	
	String[][] treCols;
	String[]   treColsNames = {"이름", "성별", "나이", "전화번호", "시도", "구군", "상세주소", "특이사항"};

	TreController treController;
	
	public static String exPhone = null;
	
	public TreUpdDialog(String title) {
		setTitle(title);
		setResizable(false);
		
		panelBtn  = new JPanel();
		table     = new JTable();
		btnRead   = new JButton("조회");
	}
	
	public void initFrame() {
		treController = new TreController();
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TreVO> treList = new ArrayList<TreVO>();
				TreVO            treVO   = new TreVO();
				
				treList = treController.listTreData();
				loadData(treList);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<TreVO> treList = new ArrayList<TreVO>();
				TreVO            treVO   = new TreVO();
				
				final TreCreDialog td = new TreCreDialog("사망자 명단 수정 화면");
				
				int row = table.getSelectedRow();
				TableModel data = (TableModel) table.getModel();
				
				td.tfName   .setText((String) data.getValueAt(row, 0));
				td.tfGender .setText((String) data.getValueAt(row, 1));
				td.tfAge    .setText((String) data.getValueAt(row, 2));
				td.tfPhone  .setText((String) data.getValueAt(row, 3));
				td.tfSido   .setText((String) data.getValueAt(row, 4));
				td.tfGugun  .setText((String) data.getValueAt(row, 5));
				td.tfAddress.setText((String) data.getValueAt(row, 6));
				td.tfMemo   .setText((String) data.getValueAt(row, 7));
				exPhone = (String) data.getValueAt(row, 3);
				
				td.updateData();
				td.initFrame();
				treList = treController.listTreData();
				loadData(treList);
				model.fireTableDataChanged();
				}
			}
		);
		
		panelBtn.add(btnRead);
		
		add(panelBtn , BorderLayout.SOUTH);
		
		treCols = new String[0][8];
		model   = new TableModel(treCols, treColsNames);
		table.setModel(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLocation(400 , 250);
		setSize    (1000, 550);
		setModal   (true);
		setVisible (true);
	}

	private void loadData(ArrayList<TreVO> treList) {
		treCols = new String[treList.size()][8];
		
		for (int i = 0; i < treList.size(); i++) {
			TreVO treVO = treList.get(i);
			
			treCols[i][0] = treVO.getName   ();
			treCols[i][1] = treVO.getGender ();
			treCols[i][2] = Integer.toString(treVO.getAge());
			treCols[i][3] = treVO.getPhone  ();
			treCols[i][4] = treVO.getSido   ();
			treCols[i][5] = treVO.getGugun  ();
			treCols[i][6] = treVO.getAddress();
			treCols[i][7] = treVO.getMemo   ();
			
			model = new TableModel(treCols, treColsNames);
			table.setModel(model);
		}
	}

}