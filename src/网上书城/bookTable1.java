package �������;

import javax.swing.table.AbstractTableModel;

import dao.Mysqlconnector;

// TODO: Auto-generated Javadoc
/**
 * The Class bookTable1.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020��7��3��
 */

public class bookTable1 extends AbstractTableModel{

/** The bookin. */
public static Object [][]bookin=Mysqlconnector.bookinfo;

/** The name. */
String []name= {"ͼ����","����","�۸�","����","����"};


    /* (�� Javadoc)
    * 
    * 
    * @return
    * @see javax.swing.table.TableModel#getRowCount()
    */
    
public int getRowCount() {
	// TODO Auto-generated method stub
	return bookin.length;
}


    /* (�� Javadoc)
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



    /* (�� Javadoc)
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


    /* (�� Javadoc)
    * 
    * 
    * @param col
    * @return
    * @see javax.swing.table.AbstractTableModel#getColumnName(int)
    */
    
public String getColumnName(int col) {
	return name[col];
}


    /* (�� Javadoc)
    * 
    * 
    * @param rowIndex
    * @param columnIndex
    * @return
    * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
    */
    
public boolean isCellEditable(int rowIndex, int columnIndex) {
      // �жϵ�Ԫ���Ƿ���Ա༭
	if(columnIndex==3)
		  return true;
	else
		return false;
		
}


    /* (�� Javadoc)
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

