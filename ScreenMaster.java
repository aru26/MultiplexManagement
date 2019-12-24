import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class ScreenMaster extends JFrame {
	JPanel p1;
	JLabel L1;
	JTextField t1;
	JButton b1;
	
	public ScreenMaster() {
		this.setVisible(true);
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setTitle("Screen Master");
		
	p1 = new JPanel();
	L1 = new JLabel("Enter Screen Name");
	t1 =new JTextField(20);
	b1 = new JButton("Submit");
	p1.add(L1);
	p1.add(t1);
	p1.add(b1);
	getContentPane().add(p1);
	b1.addActionListener(e->actionB1(e));
	
		
	}
	public void actionB1(ActionEvent e) 
	{
		try {
			DBConnect db = new DBConnect();
			db.queryExecuter("insert into screenmaster values('"+
			t1.getText()+"')");
			JOptionPane.showMessageDialog(null, "Record Saved.");
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex .toString());
			
			
			
		}
	}
	public static void main(String []args) {
		new ScreenMaster();
		
	}
}




