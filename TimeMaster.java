import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;

import javax.swing.*;

public class TimeMaster extends JFrame {
	JPanel p1;
	JLabel L1;//select screen
	JComboBox jc1;
	JLabel L2, L3;//enter timing
	JComboBox jc2;
	JTextArea ta1;
	JButton b1;//save
	JTextField t1;
	
	
	
	public TimeMaster() {
		this.setVisible(true);
		this.setSize(600,500);
		this.setTitle("Time Master");
		p1=new JPanel();
		L1=new JLabel("Select Screen");
		jc1 = new JComboBox();
		L2 = new JLabel("Enter Timinng");
		String a[]= {"9:30 to 12:30","12:30 to 3:30","3:30 to 6:30",
				"6:30 to 9:30","9:30 to 1:30","Other"};
		jc2 =new JComboBox(a);
		t1 = new JTextField(15);
		ta1 = new JTextArea(5,20);
		JScrollPane js = new JScrollPane(ta1);
		b1 = new JButton("Save");
		L3 =new JLabel("If Other");
		p1.add(L1);p1.add(jc1);
		p1.add(L2);p1.add(jc2);
		p1.add(L3);
		p1.add(t1);p1.add(b1);
		p1.add(js);
		getContentPane().add(p1);
		b1.addActionListener(e->actionB1(e));
		
		try
		{
			DBConnect x =new DBConnect();
			ResultSet rs = x.queryReturner("select * from screenmaster");
			while(rs.next()) 
			{
				jc1.addItem(rs.getString(1));
			}	
		}
		
		catch(Exception ex)
		{
			
		}
		ta1.append("Screen Name\t Timing\n");
		ta1.setEditable(false);
		jc1.addItemListener(e->screenClick(e));
	}
	
	public void screenClick(ItemEvent e) {
		try {
			ta1.setText("");
			ta1.append("Screen Name \t Timing \t \n");
			DBConnect x = new DBConnect();
			ResultSet rs = x.queryReturner("select*from timemaster where screenname ='"+
			jc1.getSelectedItem()+"'");
			while(rs.next())
			{
				ta1.append(rs.getString(1)+"\t"+rs.getString(2)+"\t\n");		
				
			}
					
					
			
		}catch(Exception ex) {
			
		}
		
	}
		public void actionB1(ActionEvent e)
		{
			String sql="";
			if(t1.getText().length()>0)
				ta1.append(jc1.getSelectedItem()+"\t"+t1.getText()+"\n");
			else {
				ta1.append(jc1.getSelectedItem()+"\t"+jc2.getSelectedItem()+"\n");
				sql = "insert into timemaster values('"+jc1.getSelectedItem()+"','"+
				jc2.getSelectedItem()+"')";
			}
			try {
				DBConnect x =new DBConnect();
				x.queryExecuter(sql);
				JOptionPane.showMessageDialog(null,"Record Saved");	
			}
			catch(Exception ex) 
			{
			}
		}
}
	

				
		
	


