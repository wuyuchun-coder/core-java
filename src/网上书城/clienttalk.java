package 网上书城;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class clienttalk.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class clienttalk {

/**
 * The main method.
 *
 * @param args the arguments
 * @throws UnknownHostException the unknown host exception
 * @throws IOException Signals that an I/O exception has occurred.
 */

    /**
    * @Title: main
    * @Description: 实现留言功能
    * @param @param args
    * @param @throws UnknownHostException
    * @param @throws IOException    参数
    * @return void    返回类型
    * @throws
    */
    
public static void main(String[]args)throws UnknownHostException, IOException {
	Socket s = new Socket("localhost", 20022);  
	JFrame j=new JFrame("聊天框");
	j.setLayout(new FlowLayout());
	JTextArea jt1=new JTextArea(10,30);
	//jt1.setText("123456");
	JButton jb=new JButton("发送");
	j.add(jt1);
	j.add(jb);
	j.setSize(500, 500);
	j.setVisible(true);
	
	OutputStream os = s.getOutputStream();//用于向服务器输出 

	jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb) {
			
				InputStream myIn=new ByteArrayInputStream(jt1.getText().getBytes());
				//将System.in转化为面向字符的流
				InputStreamReader ir = new InputStreamReader(myIn);
				 
				BufferedReader in = new BufferedReader(ir);//为输入流提供缓冲区
				String input;  
				try {
					while ((input= in.readLine()) != null) {  
						input=Login.loginId1.getText()+":"+input+"\n";
					    os.write(input.getBytes("utf-8"));  
					    jt1.setText("");
					}
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		}
		
	});
	
}
}
