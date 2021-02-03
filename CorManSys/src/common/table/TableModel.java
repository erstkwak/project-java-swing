package common.table;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	Object[][] data;
	String[]   columnNames;

	public TableModel(Object[][] data, String[] columnNames) {
		this.data        = data;
		this.columnNames = columnNames; 
	}

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	public int     getColumnCount()                    {return columnNames.length;}
	public int     getRowCount   ()                    {return data.length       ;}
	public String  getColumnName (int idx)             {return columnNames[idx]  ;}
	public Object  getValueAt    (int row, int column) {return data[row][column] ;}
	public boolean isCellEditable(int row, int column) {return false             ;}

}