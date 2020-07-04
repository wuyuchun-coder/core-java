package 网上书城;


import dao.Mysqlconnector;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.*;


// TODO: Auto-generated Javadoc
/**
 * The Class adminPage.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class adminPage {
	
		/** The adjframe. */
		public static JFrame adjframe=new JFrame("书城管理员");
		
		/** The adjlabel. */
		public static JLabel adjlabel=new JLabel("书城管理员系统",JLabel.CENTER);
		
		/** The search book. */
		public static JButton searchBook=new JButton("搜索");
		
		/** The search line. */
		public static JTextField searchLine=new JTextField("请输入想要查找的书名");
		
		/** The icon. */
		public static JLabel icon=new JLabel();
		
		/** The jb. */
		public static JLabel  jb=new JLabel("所有图书信息",JLabel.CENTER);
		
		/** The add. */
		public static JButton add=new JButton("添加图书");
		
		/** The delete. */
		public static JButton delete=new JButton("删除图书");
		
		/** The searchalloffer. */
		public static JButton searchalloffer=new JButton("全部订单");
		
		/** The all. */
		public static JButton all=new JButton("全部图书");
		
		/** The save. */
		public static JButton save=new JButton("保存");
		
		/** The addmanybooks. */
		public static JButton addmanybooks=new JButton("批量导入");
		
		/** The outmanybooks. */
		public static JButton outmanybooks=new JButton("批量导出");
		
		/** The talk. */
		public static JButton talk=new JButton("回复");
		
		/** The sure 1. */
		public static JButton sure1=new JButton("确定");
		
		/** The jframe. */
		public static JFrame jframe =new JFrame("增加图书");
		
		/** The jp. */
		JPanel jp=new JPanel();
			
		/** The sure. */
		public static JButton sure=new JButton("确定");
		
		/** The off. */
		public static	JButton off=new JButton("取消");
		
		/** The jl. */
		public static	JLabel jl=new JLabel("图书编号:");
		
		/** The jt. */
		public static	JTextField jt=new JTextField();
		
		/** The jl 1. */
		public static	JLabel jl1=new JLabel("书名:");
		
		/** The jt 1. */
		public static	JTextField jt1=new JTextField();
		
		/** The jl 2. */
		public static	JLabel jl2=new JLabel("价格:");
		
		/** The jt 2. */
		public static	JTextField jt2=new JTextField();
		
		/** The jl 3. */
		public static   JLabel jl3=new JLabel("数量:");
		
		/** The jt 3. */
		public static	JTextField jt3=new JTextField();
		
		/** The jl 4. */
		public static	JLabel jl4=new JLabel("类型:");
		
		/** The jt 4. */
		public static	JTextField jt4=new JTextField();
		
		/** The jframe 1. */
		public static JFrame jframe1 =new JFrame("删除图书");
		
		/** The jlb. */
		public static	JLabel jlb=new JLabel("图书名称:");
		
		/** The jtb. */
		public static	JTextField jtb=new JTextField();
		
		/**
		 * Createadmin page.
		 */
		
		    /**
		    * @Title: createadminPage
		    * @Description:创建管理员界面
		    * @param     参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		
		    /**
		    * @Title: createadminPage
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param     参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		public static void createadminPage() {
			
			ImageIcon loginicon = null;
			try {
				loginicon = new iconSizeChange().sizeChange("E:\\网上书城项目图片\\管理.jpg",1000,100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		icon.setIcon(loginicon);
		icon.setBounds(0, 0, 1000, 100);
			
		Font font=new Font("字体",Font.BOLD,28);
		Font font1=new Font("字体1",Font.BOLD,20);
		Font font2=new Font("字体2",Font.BOLD,15);
			
		all.setFont(font1);
		all.setBounds(780, 200, 200, 40);
		
		save.setFont(font1);
		save.setBounds(900, 650, 80, 40);
		
		
		addmanybooks.setBounds(800,700, 150, 50);
		
		outmanybooks.setBounds(620, 760, 150, 50);
		
	    adjlabel.setFont(font);
		adjlabel.setBounds(0, 100, 1000, 50);
		
		searchBook.setFont(font1);
		searchBook.setBounds(820, 150, 100, 40);
		searchLine.setBounds(100, 150, 700, 40);
		
		jb.setFont(font1);
		jb.setBounds(350, 225, 200, 20);
		
		
		searchalloffer.setBounds(620,700, 150, 50);
		
		add.setBounds(100, 700, 150, 50);
		delete.setBounds(280, 700, 150, 50);
	
		
		talk.setBounds(800, 750, 150, 50);
		
		
		adjframe.setSize(1000, 1000);
		adjframe.setLayout(null);
		adjframe.add(icon);
		adjframe.add(searchLine);
		adjframe.add(searchBook);
		adjframe.add(adjlabel);
		adjframe.add(jb);
		adjframe.add(searchalloffer);
		adjframe.add(add);
		adjframe.add(delete);
		adjframe.add(all);
		adjframe.add(save);
		adjframe.add(addmanybooks);
		adjframe.add(outmanybooks);
		
		//为查询所有订单按钮添加事件
	    searchalloffer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==searchalloffer) {
					Mysqlconnector.personal_offerlist_search(1);
				}
			}
	    
	    });
	    //为增加图书按钮添加事件
	    add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jl.setBounds(100, 20, 100, 30);
				jt.setBounds(250, 20, 200, 30);
				jl1.setBounds(100, 80, 100, 30);
				jt1.setBounds(250, 80, 200, 30);
				jl2.setBounds(100, 140, 100, 30);
				jt2.setBounds(250, 140, 200, 30);
				jl3.setBounds(100, 200, 100, 30);
				jt3.setBounds(250, 200, 200, 30);
				jl4.setBounds(100, 260, 100, 30);
				jt4.setBounds(250, 260, 200, 30);
				sure.setBounds(150, 400, 200, 50);

				jframe.setLayout(null);
				jframe.setSize(500,500);
				jframe.add(jl);
				jframe.add(jt);
				jframe.add(jl1);
				jframe.add(jt1);
				jframe.add(jl2);
				jframe.add(jt2);
				jframe.add(jl3);
				jframe.add(jt3);
				jframe.add(jl4);
				jframe.add(jt4);
				jframe.add(sure);

				jframe.setVisible(true);	
			}
	    });
	    //为添加图书界面的确定按钮添加事件
	    sure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==sure)
				Mysqlconnector.adimin_add_book();
			}
	    	
	    });
	    //为管理员界面的删除按钮添加事件并使删除页面可视化
	    delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==delete) {
			    	jlb.setBounds(200, 200, 200, 40);	
			    	jframe1.setLayout(null);
			    	jframe1.setSize(500, 500);
			    	jtb.setBounds(200, 300, 200, 40);
			    	sure1.setBounds(200, 400, 200, 40);
                    jframe1.add(jlb);
                    jframe1.add(jtb);
                    jframe1.add(sure1);
			        jframe1.setVisible(true);	
			        
				}
			}
	    	
	    });
	    searchBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==searchBook) {
					Mysqlconnector.search1();
					adminTable f=new adminTable();
					JScrollPane	j=new JScrollPane(adminTable.table); 
					j.setBounds(100, 280, 780, 400);
					adjframe.add(j);
				}
			}
			
		});
	    all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==all) {
					bookTable1.bookin=Mysqlconnector.bookinfo;
					adminTable f=new adminTable();
					JScrollPane	j=new JScrollPane(adminTable.table); 
					j.setBounds(100, 280, 780, 400);
					adjframe.add(j);
				}
			}
	    	
	    });
	    save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==save) {
					Object [][]info=null;
					int columns=adminTable.table.getColumnCount();
					int rows=adminTable.table.getRowCount();
					info=new Object [rows][columns];
					
					for(int i=0;i<rows;i++) {
						for(int j=0;j<columns;j++) {
							info[i][j]=adminTable.table.getValueAt(i, j);
						}
					}
					String Driver="com.mysql.jdbc.Driver";
						try {
							Class.forName(Driver);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
						String user="root";
						String password="123456";
						for(int i=0;i<rows;i++) {
						Connection conn;
						try {
						conn=DriverManager.getConnection(url, user, password);
						String sql="update 图书表 set num1=" +info[i][3].toString()+" where bkName="+"'"+info[i][1]+"'";
						PreparedStatement pst=conn.prepareStatement(sql);
						pst.executeUpdate();
						pst.close();
						conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}		
				}
			}  	
	    });
	    //为删除页面里的确定按钮添加事件
	    sure1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==sure1) {
					Mysqlconnector.admin_delete_book();
				}
			}
	    	
	    });
	    addmanybooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==addmanybooks) {
					Mysqlconnector.admin_import_books();
				}
			}
	    	
	    });
	    outmanybooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==outmanybooks) {
					try {
						Mysqlconnector.out_admin_book();
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	    	
	    });
	    //使图书数据以表格的方式显示
			adminTable f=new adminTable();
			JScrollPane	j=new JScrollPane(adminTable.table); 
			j.setBounds(100, 280, 780, 400);
			adjframe.add(j);
			adjframe.setVisible(true);
		
		}
		
	
		
	
}
