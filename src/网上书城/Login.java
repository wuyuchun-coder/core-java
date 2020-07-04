package �������;

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
 * @date 2020��7��3��
 */
public class Login {
	

 /** The jplibrary. */
 private Component jplibrary;
 
 /** The library. */
 //���
 public static JFrame library=new JFrame("�������");
 
 /** The logon. */
 public static JButton logon=new JButton("��¼");
 
 /** The register. */
 public static JButton register=new JButton("ע��");
 
 /** The login label. */
 public static JLabel loginLabel=new JLabel("�������",JLabel.CENTER);
 
 /** The loginbackground. */
 public static JPanel loginbackground=new JPanel();
 
 /** The login icon. */
 public static JLabel loginIcon=new JLabel();
 
 /** The login id. */
 public static JLabel loginId=new JLabel("�˺�:");
 
 /** The login id 1. */
 public static JTextField loginId1=new JTextField();
 
 /** The login password. */
 public static JLabel loginPassword=new JLabel("����:");
 
 /** The login password 1. */
 public static JPasswordField loginPassword1=new JPasswordField();
 
 /** The back 1. */
 public static JButton back1=new JButton("����");

/** The loginbt. */
public static JButton loginbt=new JButton("��¼");


/**
 * Show.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */
public static void show() throws IOException {
	
	
	  //���ñ���ɫΪ��ɫ�ʹ˿鱳����λ��
	  loginbackground.setBackground(Color.WHITE);
	  loginbackground.setBounds(0,200,500,600);
	  
	  //����
	  Font font=new Font("font",Font.BOLD,20);
	  Font font1=new Font("font1",Font.BOLD,28);
	  
	  logon.setFont(font);
	  register.setFont(font);
	  loginLabel.setFont(font1);
	  loginId.setFont(font1);
	  loginPassword.setFont(font1);
	  back1.setFont(font1);
	  loginbt.setFont(font1);
	 //�����������ô�С�Ͳ��ֹ�����
	 library.setSize(500,800);
	 library.setLayout(null);
	
	 //����ͼƬλ��
	 ImageIcon loginicon=new iconSizeChange().sizeChange("E:\\���������ĿͼƬ\\��¼����ͼ.jpg",500,200);
	 loginIcon.setIcon(loginicon);
	 loginIcon.setBounds(0, 0, 500, 200);
	 
	 //���õ�¼�����λ�úʹ�С
	 logon.setBounds(150,300,200,50);
	 //����ע�������λ�úʹ�С
	 register.setBounds(150, 450, 200, 50);
	 //���ó������ֱ��������λ�úʹ�С
	 loginLabel.setBounds(150,200,200,100);
	 //���õ�¼����ı���λ��
	 loginId.setBounds(80, 300, 200, 50);
	 //���õ�¼�˺�������λ��
	 loginId1.setBounds(150, 310, 300, 30);
	 //���õ�¼���������ı���λ��
	 loginPassword.setBounds(80, 360, 200, 50);
	 //���õ�¼����������λ��
	 loginPassword1.setBounds(150, 370, 300, 30);
	 //����ȷ�ϵ�¼����Ĵ�С��λ��
	 loginbt.setBounds(120, 450, 100, 50);
	 //���÷�������Ĵ�С��λ��
	 back1.setBounds(250, 450, 100, 50);
	//������
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
	 //Ϊ��¼��������¼�
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
	 //Ϊע����������¼�
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
