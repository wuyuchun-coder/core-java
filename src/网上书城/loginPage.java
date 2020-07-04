package 网上书城;


import dao.Mysqlconnector;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



    // TODO: Auto-generated Javadoc
/**
     * The Class loginPage.
     *
     * @author wuyuchun
     * @version  v1.0
     * @date 2020年7月3日
     */
    
public class loginPage {
	
	/** The login pagelable. */
	//设置注册界面需要显示的所有组件
	public static JLabel loginPagelable=new JLabel("书籍是人类进步的阶梯",JLabel.CENTER);
	
	/** The jbuser id. */
	public static JLabel jbuserId=new JLabel("注册账号:");
	
	/** The jbpassword. */
	public static JLabel jbpassword=new JLabel("设置密码:");
	
	/** The jt id. */
	public static JTextField jtId=new JTextField();//注册时账号输入文本框
	
	/** The jtword. */
	public static JPasswordField jtword=new JPasswordField();//注册时密码输入文本框
	
	/** The jbset icon. */
	public static JLabel jbsetIcon=new JLabel();
	
	/** The name label. */
	public static JLabel nameLabel=new JLabel("请输入您的姓名:");
	
	/** The name text. */
	public static JTextField nameText=new JTextField();
	
	/** The sex label. */
	public static JLabel sexLabel=new JLabel("您的性别:");
	
	/** The age label. */
	public static JLabel ageLabel=new JLabel("您的年龄:");
	
	/** The age text. */
	public static JTextField ageText=new JTextField();
	
	/** The select sex. */
	public static JComboBox selectSex=null;
	
	/** The rigister type. */
	public static JLabel rigisterType=new JLabel("注册类型");
	
	/** The rigist type. */
	public static JComboBox rigistType=null;
	
	/** The sure. */
	public static JButton sure=new JButton("确定");
    
    /** The back. */
    public static JButton back=new JButton("返回");
    
    /** The loginsuc J label. */
    public static JLabel loginsucJLabel=new JLabel("您已注册成功",JLabel.CENTER);
    
    /**
     * Comphide.
     */
    public static void comphide() {
    	//将登陆界面的所有组件全部隐藏
		 Login.logon.setVisible(false);
		 Login.register.setVisible(false);
		 Login.loginLabel.setVisible(false);
		 Login.loginIcon.setVisible(false);
		 Login.loginbackground.setVisible(false);
		
				
		
    }
    
    /**
     * Showcomp.
     */
    public static void showcomp() {
    	Login.logon.setVisible(true);
		 Login.register.setVisible(true);
		 Login.loginLabel.setVisible(true);
		 Login.loginIcon.setVisible(true);
		 Login.loginbackground.setVisible(true);
    }
    
    /**
     * Comp 1 hide.
     */
    public static void comp1hide() {
    	//将注册界面的所有组件隐藏
        loginPagelable.setVisible(false);
    	jbuserId.setVisible(false);
    	jbpassword.setVisible(false);
    	jtId.setVisible(false);
    	jtword.setVisible(false);
    	jbsetIcon.setVisible(false);
    	nameLabel.setVisible(false);
    	 nameText.setVisible(false);
    	 sexLabel.setVisible(false);
    	 ageLabel.setVisible(false);
    	 ageText.setVisible(false);
    	 selectSex.setVisible(false);
    	jbsetIcon.setVisible(false);
    	rigisterType.setVisible(false);
    	rigistType.setVisible(false);
    	sure.setVisible(false);
    	back.setVisible(false);
    	loginsucJLabel.setVisible(false);
    }
    
    /**
     * Show 1 hide.
     */
    public static void show1hide() {
    	//将注册界面的所有组件显示
        loginPagelable.setVisible(true);
    	jbuserId.setVisible(true);
    	jbpassword.setVisible(true);
    	jtId.setVisible(true);
    	jtword.setVisible(true);
    	jbsetIcon.setVisible(true);
    	nameLabel.setVisible(true);
    	 nameText.setVisible(true);
    	 sexLabel.setVisible(true);
    	 ageLabel.setVisible(true);
    	 ageText.setVisible(true);
    	 selectSex.setVisible(true);
    	jbsetIcon.setVisible(true);
    	rigisterType.setVisible(true);
    	rigistType.setVisible(true);
    	sure.setVisible(true);
    	back.setVisible(true);
    	//loginsucJLabel.setVisible(true);
    }
    
	/**
	 * Instantiates a new login page.
	 */
	public loginPage() {
		
		
		 Font font=new Font("字体",Font.BOLD+Font.ITALIC,28);
		 Font font1=new Font("字体1",Font.BOLD,20);
		 Font font2=new Font("字体3",Font.BOLD,15);
		 comphide();
		 
		 loginsucJLabel.setFont(font2);
		 loginsucJLabel.setBounds(175, 700, 100, 50);
		 loginsucJLabel.setVisible(false);
		// loginsucJLabel.setVisible(false);
		//设置字体
		 loginPagelable.setFont(font);
		 loginPagelable.setBounds(0, 0, 500, 100);
		 
		//设置Id文本组件位置
		 jbuserId.setFont(font1);
		 jbuserId.setBounds(100, 150, 100, 30);
		 
		 
		 //设置Id账号输入框位置
		 jtId.setBounds(200, 150, 200, 30);
		 
		 //设置password文本位置
		 jbpassword.setFont(font1);
		 jbpassword.setBounds(100, 250, 100, 30);
		 
		 //设置password输入框位置
		 jtword.setBounds(200, 250, 200, 30);
		 
		 //设置姓名输入文本
		 nameLabel.setFont(font1);
		 nameLabel.setBounds(40, 350, 200, 30);
		 //设置姓名输入文本框
		 nameText.setBounds(200, 350, 200, 30);
		 
		 //设置性别选择文本
		 sexLabel.setFont(font1);
		 sexLabel.setBounds(100, 450, 100, 30);
		 
		 //设置性别选择框
		 String []sex= {"男","女"};
		selectSex=new JComboBox(sex);
		 selectSex.setEditable(false);
		 selectSex.setBounds(200, 450, 100, 30);
		 
		 //设置年龄文本
		 ageLabel.setFont(font1);
		 ageLabel.setBounds(100,530 , 100, 30);
		 
		 //设置年龄输入文本框
		 ageText.setBounds(200, 530, 100, 30);
		 
		 //设置注册类型文本
		 rigisterType.setFont(font1);
		 rigisterType.setBounds(100, 600, 100, 30);
		 
		 //设置注册框
		 String []rgt= {"普通用户","管理员"};
		 rigistType=new JComboBox(rgt);
		 rigistType.setBounds(200,600, 200, 30);
		 //设置确定按钮的大小和位置
		 sure.setFont(font2);
		 sure.setBounds(125,650,100,50);
		 
		 //设置返回按钮的大小和位置
		 back.setFont(font2);
		 back.setBounds(250, 650, 100, 50);
		 //设置背景图片
		 ImageIcon icon=new ImageIcon("E:\\网上书城项目图片\\注册界面图.jpg");
		 jbsetIcon.setIcon(icon);
		 jbsetIcon.setBounds(0, 0, 500, 800);
		 
			 
		 //为确定按钮添加动作事件(获得输入框中的信息并将它写入数据库)
		 sure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==sure) {
					String userId=jtId.getText();
					loginsucJLabel.setVisible(true);
					//@SuppressWarnings("deprecation")
					String password=new String(jtword.getPassword());
					String name=nameText.getText();
					String sex=(String)selectSex.getSelectedItem();
					
					String age=ageText.getText();
					
					int age1=Integer.parseInt(age);
					int isAdmin=0;
					if((boolean)rigistType.getSelectedItem().equals("管理员")) {
						isAdmin=1;
					}
					try {
						if(Mysqlconnector.check_userId_isExisit()) {
Mysqlconnector.set_LoginUser_Info_Into_Mysql(userId, password, name, sex, age1, isAdmin);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			 
			 
		 });
		 back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==back) {
					String id=jtId.getText();
					jtId.setText("");
					jtword.setText("");
					nameText.setText("");
					ageText.setText("");
					comp1hide();
					showcomp();
				}
			}
			 
			 
		 });
		 //添加组件
		
		 Login.library.add(loginPagelable);
		 Login.library.add(jbuserId);
		 Login.library.add(jtId);
		 Login.library.add(jbpassword);
		 Login.library.add(jtword);
		 Login.library.add(nameLabel);
		 Login.library.add(nameText);
		 Login.library.add(sexLabel);
		 Login.library.add(selectSex);
		 Login.library.add(ageText);
		 Login.library.add(ageLabel);
		 Login.library.add(rigisterType);
		 Login.library.add(rigistType);
		 Login.library.add(sure);
		 Login.library.add(back);
		 Login.library.add(loginsucJLabel);
		 Login.library.add(jbsetIcon);
		
		 show1hide();
		 
		
	}
}
