package 网上书城;

import dao.Mysqlconnector;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


	
// TODO: Auto-generated Javadoc
/**
 * The Class userMainPage.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class userMainPage {
	
	/** The buy book system. */
	public static JFrame buyBookSystem=new JFrame("网上书城-购书");
	
	/** The icon. */
	public static JLabel icon=new JLabel();
	
	/** The welcome. */
	public static JLabel welcome=new JLabel("欢迎使用网上书城系统",JLabel.CENTER);
	
	/** The search book. */
	public static JButton searchBook=new JButton("搜索");
	
	/** The booktype. */
	public static JLabel booktype=new JLabel("类别:");
	
	/** The tech book. */
	public static JButton techBook=new JButton("科幻");
	
	/** The love book. */
	public static JButton loveBook=new JButton("言情");
	
	/** The que book. */
	public static JButton queBook=new JButton("悬疑");
	
	/** The offer list. */
	//public static JTable bookTable=new JTable();
	public static JButton offerList=new JButton("提交订单");
	
	/** The jb 1. */
	public static JButton jb1=new JButton("留言");
	
	/** The back 3. */
	public static JButton back3=new JButton("返回");
	
	/** The all. */
	public static JButton all=new JButton("全部");
	
	/** The search line. */
	public static JTextField searchLine=new JTextField("请输入想要查找的书名");
   
	
	/**
	 * Creates the buy book page.
	 */
	
	    /**
	    * @Title: createBuyBookPage
	    * @Description:创造用户的购书界面
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public static void createBuyBookPage() {
		JButton jb=new JButton("购买记录");
		try {
			ImageIcon loginicon=new iconSizeChange().sizeChange("E:\\网上书城项目图片\\登录界面图.jpg",1000,100);
			icon.setIcon(loginicon);
			icon.setBounds(0, 0, 1000, 100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//构造购书的GUI界面
		Font font=new Font("字体",Font.BOLD,28);
		Font font1=new Font("字体1",Font.BOLD,20);
		Font font2=new Font("字体2",Font.BOLD,15);
	
		jb1.setFont(font1);
		jb1.setBounds(700, 750, 150, 50);
		welcome.setFont(font);
		welcome.setBounds(0, 100, 1000, 50);
		
		searchBook.setFont(font1);
		searchBook.setBounds(820, 150, 100, 40);
		searchLine.setBounds(100, 150, 700, 40);
		
		booktype.setFont(font1);
		booktype.setBounds(80, 220, 100, 30);
		
		techBook.setFont(font2);
		techBook.setBounds(180, 225, 70, 20);
		
		loveBook.setFont(font2);
		loveBook.setBounds(280, 225, 70, 20);
		
		queBook.setFont(font2);
		queBook.setBounds(380, 225, 70, 20);
		
		all.setFont(font2);
		all.setBounds(480,225,70,20);
		
		offerList.setFont(font1);
		offerList.setBounds(200, 700, 200, 50);
		
		back3.setFont(font1);
		back3.setBounds(500, 700, 100, 50);
		
		jb.setFont(font1);
		jb.setBounds(700, 700, 150, 50);
		
		buyBookSystem.setLayout(null);
		buyBookSystem.setSize(1000, 1000);
	
		buyBookSystem.add(icon);
		buyBookSystem.add(welcome);
		buyBookSystem.add(searchLine);
		buyBookSystem.add(searchBook);
		buyBookSystem.add(booktype);
		buyBookSystem.add(techBook);
		buyBookSystem.add(loveBook);
		buyBookSystem.add(queBook);
		buyBookSystem.add(all);
		buyBookSystem.add(offerList);
		buyBookSystem.add(back3);
		buyBookSystem.add(jb);
		buyBookSystem.add(jb1);

		//为科幻类按钮增加事件
		techBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==techBook) {
					Mysqlconnector.tech_book();
					finalTable f=new finalTable();
					//Mysqlconnector.que_book();
					JScrollPane	j=new JScrollPane(finalTable.table); 
					j.setBounds(70, 280, 800, 400);
					buyBookSystem.add(j);
				}
			}
			
		});
		//为言情类图书按钮添加时间
		loveBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==loveBook) {
					Mysqlconnector.love_book();
					finalTable f=new finalTable();
					//Mysqlconnector.que_book();
					JScrollPane	j=new JScrollPane(finalTable.table); 
					j.setBounds(70, 280, 800, 400);
					buyBookSystem.add(j);
				}
			}
			
		});
		//为科幻类图书按钮添加事件
		queBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==queBook) {
					Mysqlconnector.que_book();
					finalTable f=new finalTable();
					//Mysqlconnector.que_book();
					JScrollPane	j=new JScrollPane(finalTable.table); 
					j.setBounds(70, 280, 800, 400);
					buyBookSystem.add(j);
				}
			}
			
		});
		//为所有图书按钮添加事件
		all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==all) {
					Mysqlconnector.all();
					finalTable f=new finalTable();
					//Mysqlconnector.que_book();
					JScrollPane	j=new JScrollPane(finalTable.table); 
					j.setBounds(70, 280, 800, 400);
					buyBookSystem.add(j);
				}
			}
			
		});
		//为搜索按钮添加事件
		searchBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==searchBook) {
					Mysqlconnector.search();
					finalTable f=new finalTable();
					//Mysqlconnector.que_book();
					JScrollPane	j=new JScrollPane(finalTable.table); 
					j.setBounds(70, 280, 800, 400);
					buyBookSystem.add(j);
				}
			}
			
		});
		//提交订单按钮添加事件
		offerList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(bookTable.isEditing());;
				if(e.getSource()==offerList)
				offerlist.offerList();

			}
			
		});
		//为用户订单按钮添加事件
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb) {
					Mysqlconnector.personal_offerlist_search(0);
				}
			}
		
		});
		//为留言按钮添加事件
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb1) {
					try {
						clienttalk.main(null);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		finalTable f=new finalTable();
		//Mysqlconnector.que_book();
		JScrollPane	j=new JScrollPane(finalTable.table); 
		j.setBounds(70, 280, 800, 400);
		buyBookSystem.add(j);
		buyBookSystem.setVisible(true);
		buyBookSystem.setDefaultCloseOperation(buyBookSystem.EXIT_ON_CLOSE);
		
		
		
	}
	    
    	/**
    	 * Page change.
    	 */
	    /**
	    * @Title: pageChange
	    * @Description: 程序由登录界面切换到用户购书界面
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	    */ 
	public static void pageChange() {
		Login.library.setVisible(false);
		createBuyBookPage();
	//	setBookTable();
		
	}
}
