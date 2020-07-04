package 网上书城;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import dao.Mysqlconnector;
// TODO: Auto-generated Javadoc

/**
 * The Class finalTable.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class finalTable implements TableModelListener{
	
	/** The table. */
	public static JTable table=null;
	
	/** The bktable. */
	bookTable bktable=null;
	
	/**
	 * Instantiates a new final table.
	 */
	public finalTable() {
		
		try {
			Mysqlconnector.book_Info_Insert_and_search() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bktable=new bookTable();
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
		 Object num =  bktable.getValueAt(row, 5);
		 bktable.mySetValueAt(num, row, 5);
	}
	
}

