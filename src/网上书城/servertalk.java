package 网上书城;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class servertalk.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class servertalk {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	
	    /**
	    * @Title: main
	    * @Description: 接受保存用户留言
	    * @param @param args
	    * @param @throws UnknownHostException
	    * @param @throws IOException    参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public static void main(String []args)throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		JFrame j=new JFrame("留言板");
		j.setLayout(new FlowLayout());
		JButton j2=new JButton("保存记录");
		JTextArea jt1=new JTextArea(15,30);
		j.add(jt1);
		j.add(j2);
		j.setSize(500, 400);
		j.setVisible(true);
		ServerSocket server=new ServerSocket(20022);
		Socket s =server.accept();  
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));  
		String content;  
		String content1="";
		final String content2 = null;
		while((content = reader.readLine() )!=null){  
		     jt1.append(content+"\n");
		     content1=content+content1;
		 	j2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==j2) {
					
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
							String words=jt1.getText();
							
							Connection conn;
							String sql="insert into 用户留言 values ('"+words+"')";
							try {
								conn=DriverManager.getConnection(url, user, password);
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
				
			});
		}
	
	
	}

}
