package 网上书城;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



// TODO: Auto-generated Javadoc
/**
 * The Class offerlist.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class offerlist {
 
/**
 * Offer list.
 */

    /**
    * @Title: offerList
    * @Description: 获取表格中用户的购买情况，再以表格形式构建用户订单
    * @param     参数
    * @return void    返回类型
    * @throws
    */
    
public static void offerList(){
	    JLabel jb1=new JLabel("您的订单");
	    JTable jtable=null;
	    JButton jb2=new JButton("确认付款");
	    
	    Object [][]info=null;
		Object [][]info1=null;
		
		JFrame offerframe =new JFrame("您的订单");  
		
		offerframe.setVisible(true);
		offerframe.setLayout(null);
		
		Font font1=new Font("字体",Font.BOLD,30);
		Font font2=new Font("字体1",Font.BOLD,20);
		jb1.setFont(font1);
		jb2.setFont(font2);
		
		int columns=finalTable.table.getColumnCount();
		int rows=finalTable.table.getRowCount();
		
		int rows1=rows;
		
		JLabel allprice1=new JLabel("应付金额:");
		JTextField jtext=new JTextField();
		allprice1.setFont(font2);
		info=new Object [rows][columns];
		
		int index=0;
		String []name= {"图书编号","书名","价格","类型","购买数量"};
		
		int a[]=new int[10000];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				info[i][j]=finalTable.table.getValueAt(i, j);
			}
		}
		for(int i=0;i<rows1;i++) {
			if(info[i][5]==null) {
				rows--;
			}
			else 
			a[index++]=i;
		}
		
		info1=new Object [rows][5];
		for(int i=0;i<rows;) {
			for(int j=0;j<rows;j++)
			{
				info1[i][0]=info[a[j]][0];
				info1[i][1]=info[a[j]][1];
				info1[i][2]=info[a[j]][2];
				info1[i][3]=info[a[j]][4];
				info1[i][4]=info[a[j]][5];
				i++;
			}
		}
		final Object[][]info2=info1;
		int allprice11=0;
		final int  rows11=rows;
		for(int i=0;i<rows11;i++) {
			allprice11=allprice11+Integer.parseInt(info2[i][2].toString())*Integer.parseInt(info2[i][4].toString());
		}
	
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb2) {
				{
						   String Driver="com.mysql.jdbc.Driver";
						   String now = "";
						   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
						   now = dateFormat.format(new Date());
							try {
								Class.forName(Driver);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
							String user="root";
							String password="123456";
							int allprice=0;
							String content="";
							for(int i=0;i<rows11;i++) {
							Connection conn;
							
							try {
								conn=DriverManager.getConnection(url, user, password);
								
							String sql="update 图书表 set num1=num1-" +info2[i][4].toString()+" where bkName='"+info2[i][1].toString()+"'";
							content=content+info2[i][1]+":"+info2[i][4]+"本"+"\n";
							allprice=allprice+Integer.parseInt(info2[i][4].toString())*(int)info2[i][2];
					
							PreparedStatement pst=conn.prepareStatement(sql);
							pst.executeUpdate();
							pst.close();
							conn.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
							}
						 

							}
						    try {
						    Connection conn1;
							conn1=DriverManager.getConnection(url, user, password);
							content ="insert into 订单表 values"+"('"+Login.loginId1.getText()+"'"+",'"+content+"',"+allprice+",'"+now+"'"+")";

							PreparedStatement pst1=conn1.prepareStatement(content);
							pst1.executeUpdate(content);
							pst1.close();
							conn1.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							offerframe.setVisible(false);
					}
				
				}
			}
			
		});
	
		
        jtext.setText(String.valueOf(allprice11));
		DefaultTableModel dtm=new DefaultTableModel(info1,name);
		
		jtable=new JTable(dtm);
		
		JScrollPane j=new JScrollPane(jtable);
		j.setBounds(40, 80, 500, 200);
		jb1.setBounds(220, 20, 300, 50);
		jb2.setBounds(300, 300, 150, 30);
	
		allprice1.setBounds(50, 300, 150, 30);
		jtext.setBounds(150, 300, 80, 30);
		offerframe.setSize(600, 400);
		
		offerframe.add(j);
		offerframe.add(jb1);
		offerframe.add(allprice1);
		offerframe.add(jtext);
		offerframe.add(jb2);
		
		offerframe.setVisible(true);
}

}
