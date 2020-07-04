package dao;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import 网上书城.Login;
import 网上书城.adminPage;
import 网上书城.bookTable;
import 网上书城.bookTable1;
import 网上书城.loginPage;
import 网上书城.userMainPage;
// TODO: Auto-generated Javadoc

/**
 * The Class Mysqlconnector.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class Mysqlconnector {
	
	/** The Driver. */
	public static String Driver="com.mysql.jdbc.Driver";
	
	/** The booktable. */
	public static JTable booktable=null;
	
	    /**
    	 * Sets the login user info into mysql.
    	 *
    	 * @param userId the user id
    	 * @param password the password
    	 * @param name the name
    	 * @param sex the sex
    	 * @param age the age
    	 * @param isAdmin the is admin
    	 * @return the int
    	 */
	
	public static int set_LoginUser_Info_Into_Mysql(String userId,String password,String name,String sex,int age,int isAdmin) {

		String Url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
		String user="root";
		 String password1="123456";
		 int num=0;
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn=DriverManager.getConnection(Url, user, password1);
			String sql="insert into 用户表 values (?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userId);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, sex);
			pst.setInt(5, age);
			pst.setInt(6, isAdmin);
			num=pst.executeUpdate();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	
	    /**
    	 * Check user id is exisit.
    	 *
    	 * @return true, if successful
    	 * @throws SQLException the SQL exception
    	 */
	    
	public static boolean check_userId_isExisit() throws SQLException {		
		//数据库驱动加载和连接
		String Url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
		String user="root";
		String password1="123456";
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn=DriverManager.getConnection(Url, user, password1);
		String sql1="select userId from 用户表";
		PreparedStatement rst=conn.prepareStatement(sql1);
		//对数据库结果集进行处理（对账号查重）	
		ResultSet idResult=rst.executeQuery();
		while(idResult.next()) {
			String userid=idResult.getString("userId");
			if(userid.equals(loginPage.jtId.getText())) {
				loginPage.jtId.setText("此账号已被注册");
				return false;
			}
		}
		return true;
	}
	
	
	    /**
    	 * Login user password is right.
    	 *
    	 * @return the int
    	 */
	    
	public static int login_userPassword_isRight() {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
		String user="root";
		String password="123456";
		JLabel tip=new JLabel("密码输入错误");
		int isAdmin = 0;
		
		try {
			Connection conn=DriverManager.getConnection(url, user, password);
			ResultSet rst=null;
			String sql= "select password,isAdmin from 用户表 where userId="+Login.loginId1.getText();
			
			PreparedStatement pst=conn.prepareStatement(sql);
			rst=pst.executeQuery();
			
			while(rst.next()) {
				String password1=rst.getString("password");
				isAdmin=rst.getInt("isAdmin");
				String info=Login.loginPassword.getText();
				if(isAdmin==0) {
					if(password1.equals(Login.loginPassword1.getText())) {
					userMainPage.pageChange();
				}
				else 
				{
					Login.loginId1.setText("账号或密码输入错误");
				}
				}
				else {
					if(password1.equals(Login.loginPassword1.getText()))
					adminPage.createadminPage();
				}
			
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdmin;
	
	}
	
	/** The bookinfo. */
	public static Object [][] bookinfo=null;
	
	
	    /**
    	 * Book info insert and search.
    	 *
    	 * @return the int
    	 * @throws SQLException the SQL exception
    	 */
	    
	public static int book_Info_Insert_and_search() throws SQLException{
			String Driver="com.mysql.jdbc.Driver";
			int num=0;
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
			String user="root";
			String password="123456";
			
			
			Connection conn;
			try {
				
				
				conn = DriverManager.getConnection(url, user, password);
				String sql=null;
				sql= "select * from 图书表 ";
				PreparedStatement pst=conn.prepareStatement(sql); 
				ResultSet rst=null;
				rst=pst.executeQuery();
			    int rows=0;
				while(rst.next()) {
					rows++;
				}
				num=rows;
				rst.beforeFirst();
				bookinfo=new Object[rows][11];
				int index=0;
				while(rst.next()) {
			
					bookinfo[index][0]=rst.getString("bkId");
					bookinfo[index][1]=rst.getString("bkName");
					bookinfo[index][2]=rst.getInt("price");
					bookinfo[index][3]=rst.getInt("num1");
					bookinfo[index][4]=rst.getString("type");
					index++;
					
				}
				
				rst.close();
				pst.close();
				conn.close();
			
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return num;
			
	
}
	
	/** The quebook. */
	public static	Object [][]quebook;
	
	
	    /**
    	 * Que book.
    	 *
    	 * @return the int
    	 */
	    
	public static int que_book() {
		int index=0;
		int num=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
				if(Mysqlconnector.bookinfo[i][4].equals("悬疑")) {
					index++;
			}
		}
		num=index;
		quebook=new Object[index][6];
		index=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
		{
				if(Mysqlconnector.bookinfo[i][4].equals("悬疑")) {
						for(int j=0;j<6;j++) {
							quebook[index][j]=bookinfo[i][j];
						}index++;
				}
			}
		}
		bookTable.bookin=quebook;
		return num;
	}
	
	/** The lovebook. */
	public static	Object [][]lovebook;
	
	    /**
    	 * Love book.
    	 *
    	 * @return the int
    	 */
	    
	public static int  love_book() {
		int index=0;
		int num=0;
			for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
					if(Mysqlconnector.bookinfo[i][4].equals("言情")) {
						index++;
				}
			}
			num=index;
			quebook=new Object[index][6];
			index=0;
			for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
			{
					if(Mysqlconnector.bookinfo[i][4].equals("言情")) {
							for(int j=0;j<6;j++) {
								quebook[index][j]=bookinfo[i][j];
							}index++;
					}
				}
			}
			bookTable.bookin=quebook;
			return num;
	}
	
	/** The techbook. */
	public static	Object [][]techbook;
	
	    /**
    	 * Tech book.
    	 *
    	 * @return the int
    	 */
	    
	public static int tech_book() {
		int index=0;
		int num=0;
			for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
					if(Mysqlconnector.bookinfo[i][4].equals("科幻")) {
						index++;
				}
			}
			num=index;
			quebook=new Object[index][6];
			index=0;
			for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
			{
					if(Mysqlconnector.bookinfo[i][4].equals("科幻")) {
							for(int j=0;j<6;j++) {
								quebook[index][j]=bookinfo[i][j];
							}index++;
					}
				}
			}
			bookTable.bookin=quebook;
			return num;
	}
	
	
	    /**
    	 * All.
    	 */
	    
	public static void all() {
		bookTable.bookin=Mysqlconnector.bookinfo;
	}
	
	/** The searchbook. */
	public static Object[][]searchbook=null;
	
	
	    /**
    	 * Search.
    	 *
    	 * @return the int
    	 */
	    
	public static int search() {
		int index=0;
		int num=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
				if(Mysqlconnector.bookinfo[i][1].equals(userMainPage.searchLine.getText())) {
					index++;
			}
			
		}
		num=index;
	//	System.out.println(index);
		searchbook=new Object[index][6];
		index=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
		{
				if(Mysqlconnector.bookinfo[i][1].equals(userMainPage.searchLine.getText())) {
						for(int j=0;j<6;j++) {
							searchbook[index][j]=bookinfo[i][j];
						}index++;
				}
			}
		}
		bookTable.bookin=searchbook;
		return num;
	}
	
	/** The searchbook 1. */
	public static Object[][]searchbook1=null;
	
	/**
	 * Search 1.
	 *
	 * @return the int
	 */
	public static int search1() {
		int index=0;
		int num=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
				if(Mysqlconnector.bookinfo[i][1].equals(adminPage.searchLine.getText())) {
					index++;
			}
			
		}
		num=index;
	//	System.out.println(index);
		searchbook1=new Object[index][5];
		index=0;
		for(int i=0;i<Mysqlconnector.bookinfo.length;i++) {
		{
				if(Mysqlconnector.bookinfo[i][1].equals(adminPage.searchLine.getText())) {
						for(int j=0;j<5;j++) {
							searchbook1[index][j]=bookinfo[i][j];
						}index++;
				}
			}
		}
		bookTable1.bookin=searchbook1;
		return num;
	}
	
	    /**
    	 * Personal offerlist search.
    	 *
    	 * @param isAdmin the is admin
    	 * @return the int
    	 */
	    
	public static int personal_offerlist_search(int isAdmin){
		int num1=0;
		 	String Driver="com.mysql.jdbc.Driver";
		 	JFrame offersearch=new JFrame("您的订单");
		 	JTable jt=null;
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
			String user="root";
			String password="123456";
			String sql="";
			if(isAdmin==0) {
				 sql="select * from 订单表 where id="+Login.loginId1.getText();
			}
			else 
				 sql="select * from 订单表 ";
		//	System.out.println(sql);
			Connection conn;
			int num=0;
			int index=0;
			Object [][]a = null;
			try {
				conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rst=pst.executeQuery();
				;
				while(rst.next()) {
					num++;
					
				}
				a=new Object[num][4];	
				rst.beforeFirst();
				num1=num;
				
				while(rst.next()) {
					a[index][0]=rst.getString("id");
					a[index][1]=rst.getString("content");
				
					a[index][2]=rst.getInt("allprice");
					a[index][3]=rst.getString("buytime");
					index++;
				}
				pst.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			String[]name= {"账号","购买内容","总额","购买时间"};
				jt=new JTable(a,name);	
				JScrollPane j =new JScrollPane(jt);
				
				offersearch.add(j);
				offersearch.setSize(800, 500);
				offersearch.setLocation(300, 200);
				offersearch.setVisible(true);
				return num1;
	}

	
	    /**
    	 * Adimin add book.
    	 *
    	 * @return the int
    	 */
	    
	public static int adimin_add_book() {
	int num=0;
		String a1=adminPage.jt.getText();
		String a2=adminPage.jt1.getText();
		String a3=adminPage.jt2.getText();
		String a4=adminPage.jt3.getText();
		String a5=adminPage.jt4.getText();
		String Driver="com.mysql.jdbc.Driver";
	
		
		Connection conn;
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
		String user="root";
		String password="123456";
		String sql="insert into 图书表 values('"+a1+"','"+a2+"',"+a3+","+a4+",'"+a5+"')";
		//	System.out.println(sql);
			try {
				conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pst=conn.prepareStatement(sql);
			num=pst.executeUpdate();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return num;
			
	}
	
	    /**
    	 * Admin delete book.
    	 *
    	 * @return the int
    	 */
	    
	public static int admin_delete_book() {
		String a=adminPage.jtb.getText();
		String Driver="com.mysql.jdbc.Driver";
			
			Connection conn;
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/mysql?useSSL=true&useUnicode=true&characterEncoding=GBK";
			String user="root";
			String password="123456";
			String sql="delete from 图书表 where bkName='"+a+"'";
		//	System.out.println(sql);
			try {
				conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.executeUpdate();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int num=1;
			return num;
	}
	
	/**
	 * Admin import books.
	 */
	public static void admin_import_books() {
		File file =new File("C://Users//123//Desktop//图书导入.xls");
		try {
			Workbook workbook=Workbook.getWorkbook(file);
			Sheet sheet=workbook.getSheet(0);
			int rows=sheet.getRows();
			for(int i=1;i<rows;i++) {
				Cell c1=sheet.getCell(0, i);
				Cell c2=sheet.getCell(1, i);
				Cell c3=sheet.getCell(2, i);
				Cell c4=sheet.getCell(3, i);
				Cell c5=sheet.getCell(4, i);

				String bkNumber=c1.getContents();
				String bkName=c2.getContents();
				String bkPrice=c3.getContents();
				String bkNum=c4.getContents();
				String bkType=c5.getContents();
				
				adminPage.jt.setText(bkNumber);
				adminPage.jt1.setText(bkName);
				adminPage.jt2.setText(bkPrice);
				adminPage.jt3.setText(bkNum);
				adminPage.jt4.setText(bkType);

                Mysqlconnector.adimin_add_book();
                adminPage.jt.setText("");
				adminPage.jt1.setText("");
				adminPage.jt2.setText("");
				adminPage.jt3.setText("");
				adminPage.jt4.setText("");

			}
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Out admin book.
	 *
	 * @throws RowsExceededException the rows exceeded exception
	 * @throws WriteException the write exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void out_admin_book() throws RowsExceededException, WriteException, IOException {
		File file=new File("C://Users//123//Desktop//图书.xls");
		WritableWorkbook workBook=null;
				workBook=Workbook.createWorkbook(file);
			WritableSheet sheet=workBook.createSheet("图书信息", 0);
			Object [][]book=bookTable1.bookin;
			int rows=book.length;
		    int columns=5;
		   jxl.write.Label  a1=new jxl.write.Label(0,0,"编号");
		   jxl.write.Label a2=new jxl.write.Label(1,0,"书名");
		   jxl.write.Label a3=new jxl.write.Label(2,0,"价格");
		   jxl.write.Label a4=new jxl.write.Label(3,0,"数量");
		   jxl.write.Label a5=new jxl.write.Label(4,0,"类型");
		 
			sheet.addCell(a1);
			sheet.addCell(a2);
			sheet.addCell(a3);
			sheet.addCell(a4);
			sheet.addCell(a5);
		
		    for(int i=0;i<rows;i++) {
		    	for(int j=0;j<columns;j++) {
		    		jxl.write.Label bookId=new jxl.write.Label(j,i+1,book[i][j].toString());
		    		jxl.write.Label bookName=new jxl.write.Label(j,i+1,book[i][j].toString());
		    		jxl.write.Label bookPrice=new jxl.write.Label(j,i+1,book[i][j].toString());
		    		jxl.write.Label bookNum=new jxl.write.Label(j,i+1,book[i][j].toString());
		    		jxl.write.Label bookType=new jxl.write.Label(j,i+1,book[i][j].toString());
		    		
						sheet.addCell(bookId);
						sheet.addCell(bookName);
						sheet.addCell(bookPrice);
						sheet.addCell(bookNum);
						sheet.addCell(bookType);
		    	}
		    }
				workBook.write();
			
				workBook.close();
	}
	
}
