package 网上书城;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import dao.Mysqlconnector;

// TODO: Auto-generated Javadoc
/**
 * The Class adminTable.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
 
public class adminTable implements TableModelListener{
	
	/** The table. */
	public static JTable table=null;
	
	/** The bktable. */
	bookTable1 bktable=null;
	
	/**
	 * Instantiates a new admin table.
	 */
	public adminTable() {
		
		try {
			Mysqlconnector.book_Info_Insert_and_search() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bktable=new bookTable1();
		bktable.addTableModelListener(this);
		table=new JTable(bktable);	
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param e
	    * @see javax.swing.event.TableModelListener#tableChanged(javax.swing.event.TableModelEvent)
	    */
	    
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		 int row = e.getFirstRow();
		 Object num =  bktable.getValueAt(row, 3);
		 bktable.mySetValueAt(num, row, 3);
	}
	
}

