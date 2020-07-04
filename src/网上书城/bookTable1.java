package 网上书城;

import javax.swing.table.AbstractTableModel;

import dao.Mysqlconnector;

// TODO: Auto-generated Javadoc
/**
 * The Class bookTable1.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */

public class bookTable1 extends AbstractTableModel{

/** The bookin. */
public static Object [][]bookin=Mysqlconnector.bookinfo;

/** The name. */
String []name= {"图书编号","书名","价格","数量","类型"};


    /* (非 Javadoc)
    * 
    * 
    * @return
    * @see javax.swing.table.TableModel#getRowCount()
    */
    
public int getRowCount() {
	// TODO Auto-generated method stub
	return bookin.length;
}


    /* (非 Javadoc)
    * 
    * 
    * @return
    * @see javax.swing.table.TableModel#getColumnCount()
    */
    
@Override
public int getColumnCount() {
	// TODO Auto-generated method stub
	return name.length;
}



    /* (非 Javadoc)
    * 
    * 
    * @param rowIndex
    * @param columnIndex
    * @return
    * @see javax.swing.table.TableModel#getValueAt(int, int)
    */
    
public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	//System.out.println( bookin[rowIndex][columnIndex]);
	return bookin[rowIndex][columnIndex];
}


    /* (非 Javadoc)
    * 
    * 
    * @param col
    * @return
    * @see javax.swing.table.AbstractTableModel#getColumnName(int)
    */
    
public String getColumnName(int col) {
	return name[col];
}


    /* (非 Javadoc)
    * 
    * 
    * @param rowIndex
    * @param columnIndex
    * @return
    * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
    */
    
public boolean isCellEditable(int rowIndex, int columnIndex) {
      // 判断单元格是否可以编辑
	if(columnIndex==3)
		  return true;
	else
		return false;
		
}


    /* (非 Javadoc)
    * 
    * 
    * @param value
    * @param row
    * @param col
    * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
    */
    
public void setValueAt(Object value, int row, int col) {
      bookin[row][col] = value;
      fireTableCellUpdated(row, col);
}

/**
 * My set value at.
 *
 * @param value the value
 * @param row the row
 * @param col the col
 */
public void mySetValueAt(Object value, int row, int col) {
      bookin[row][col] = value;
}


 
}

