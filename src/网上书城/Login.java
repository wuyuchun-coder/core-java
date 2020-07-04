package 网上书城;

import dao.Mysqlconnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class Login {
	

 /** The jplibrary. */
 private Component jplibrary;
 
 /** The library. */
 //组件
 public static JFrame library=new JFrame("网上书城");
 
 /** The logon. */
 public static JButton logon=new JButton("登录");
 
 /** The register. */
 public static JButton register=new JButton("注册");
 
 /** The login label. */
 public static JLabel loginLabel=new JLabel("网上书城",JLabel.CENTER);
 
 /** The loginbackground. */
 public static JPanel loginbackground=new JPanel();
 
 /** The login icon. */
 public static JLabel loginIcon=new JLabel();
 
 /** The login id. */
 public static JLabel loginId=new JLabel("账号:");
 
 /** The login id 1. */
 public static JTextField loginId1=new JTextField();
 
 /** The login password. */
 public static JLabel loginPassword=new JLabel("密码:");
 
 /** The login password 1. */
 public static JPasswordField loginPassword1=new JPasswordField();
 
 /** The back 1. */
 public static JButton back1=new JButton("返回");

/** The loginbt. */
public static JButton loginbt=new JButton("登录");


/**
 * Show.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */
public static void show() throws IOException {
	
	
	  //设置背景色为白色和此块背景的位置
	  loginbackground.setBackground(Color.WHITE);
	  loginbackground.setBounds(0,200,500,600);
	  
	  //字体
	  Font font=new Font("font",Font.BOLD,20);
	  Font font1=new Font("font1",Font.BOLD,28);
	  
	  logon.setFont(font);
	  register.setFont(font);
	  loginLabel.setFont(font1);
	  loginId.setFont(font1);
	  loginPassword.setFont(font1);
	  back1.setFont(font1);
	  loginbt.setFont(font1);
	 //顶层容器设置大小和布局管理器
	 library.setSize(500,800);
	 library.setLayout(null);
	
	 //设置图片位置
	 ImageIcon loginicon=new iconSizeChange().sizeChange("E:\\网上书城项目图片\\登录界面图.jpg",500,200);
	 loginIcon.setIcon(loginicon);
	 loginIcon.setBounds(0, 0, 500, 200);
	 
	 //设置登录组件的位置和大小
	 logon.setBounds(150,300,200,50);
	 //设置注册组件的位置和大小
	 register.setBounds(150, 450, 200, 50);
	 //设置程序名字本文组件的位置和大小
	 loginLabel.setBounds(150,200,200,100);
	 //设置登录组件文本的位置
	 loginId.setBounds(80, 300, 200, 50);
	 //设置登录账号输入框的位置
	 loginId1.setBounds(150, 310, 300, 30);
	 //设置登录密码输入文本的位置
	 loginPassword.setBounds(80, 360, 200, 50);
	 //设置登录密码输入框的位置
	 loginPassword1.setBounds(150, 370, 300, 30);
	 //设置确认登录组件的大小和位置
	 loginbt.setBounds(120, 450, 100, 50);
	 //设置返回组件的大小和位置
	 back1.setBounds(250, 450, 100, 50);
	//添加组件
	 library.add(loginIcon);
	 library.add(logon);
	 library.add(register);
	 library.add(loginLabel);
     library.add(loginbt);
     library.add(back1);
     loginbt.setVisible(false);
     back1.setVisible(false);
	 loginId.setVisible(false);
	 loginId1.setVisible(false);
	 loginPassword.setVisible(false);
	 loginPassword1.setVisible(false);
	 library.add(loginId);
	 library.add(loginId1);
	 library.add(loginPassword);
	 library.add(loginPassword1);
	
	 library.add(loginbackground);
	 //为登录组件增加事件
	 logon.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==logon) {
				logon.setVisible(false);
				register.setVisible(false);
				loginId.setVisible(true);
				 loginId1.setVisible(true);
				 loginPassword.setVisible(true);
				 loginPassword1.setVisible(true);
				 loginbt.setVisible(true);
			     back1.setVisible(true);
			//	loginId.setVisible(true);
			}
		}
		 
	 });
	 //为注册组件增加事件
	 register.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==register) {
				 new loginPage();
				 //loginPage.showcomp();
			}
		}
		 
	 
	 });
	
	 back1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==back1) {
				logon.setVisible(true);
				register.setVisible(true);
				loginId.setVisible(false);
				 loginId1.setVisible(false);
				 loginPassword.setVisible(false);
				 loginPassword1.setVisible(false);
				 loginbt.setVisible(false);
			     back1.setVisible(false);
			}
		}
		 
	 });
	 loginbt.addActionListener(new ActionListener() {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==loginbt) {
				Mysqlconnector.login_userPassword_isRight() ;
				
			// TODO Auto-generated method stub	
			}
		
		}
		 
	 });
	 library.setVisible(true);
	 library.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 
 }


}
