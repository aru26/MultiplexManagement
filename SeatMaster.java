import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java .sql.ResultSet;
import javax.swing.*;

public class SeatMaster extends JFrame {
	JLabel L0;//select screen
	JComboBox jc0;
	
	JLabel L2;//select range , no. of row.
	JComboBox jc2;
	JLabel L3;//select range,no.of col
	JComboBox jc3;
	JPanel p1;
	JButton b1,b2;
	public SeatMaster() {
		this.setVisible(true);
		this.setSize(600, 200);
		this.setTitle("Seat Master");
		p1=new JPanel();
		
		L0 = new JLabel("Select Screen");
		jc0 = new JComboBox();
		
		L2 = new JLabel("Select no of row");
		jc2 = new JComboBox();
		for(int i = 1; i<=26;i++) {
			jc2.addItem(i);
		}
		L3 = new JLabel("Select no of col");
		jc3 = new JComboBox();
		for(int i = 1; i<=20;i++) {
			jc3.addItem(i);
		}
		
		b1=new JButton("Preview");
		b2 = new JButton("Save");
		
		p1.add(L0);p1.add(jc0);
		p1.add(L2);p1.add(jc2);
		p1.add(L3);p1.add(jc3);
		p1.add(b1);p1.add(b2);
		getContentPane().add(p1);
		
		try {
			DBConnect x = new DBConnect();
			ResultSet rs = x.queryReturner("select*from screenmaster");
			while(rs.next()) {
				jc0.addItem(rs.getString(1));
			}
		}
		catch(Exception ex) {
			
		}
		b1.addActionListener(e->actionB1(e));
		b2.addActionListener(e->actionB2(e));
		}
	public void actionB1(ActionEvent e)
	{
		JFrame x =new JFrame();
		x.setVisible(true);
		x.setSize(800,700);
		x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel Keypad = new JPanel();
	int row = Integer.parseInt(jc2.getSelectedItem().toString());
	int col = Integer.parseInt(jc3.getSelectedItem().toString());
	    Keypad.setLayout(new GridLayout(row,col,10,5));
	    int total = row*col;
	    JButton b [] =new JButton[total];
	    
	    String rows[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
	    		"T","U","V","W","X","Y","Z"};
	    int j =0;
	    for(int i =0; i<row;i++) {
	    	
	    	for(int k=1;k<=col;k++) {
	    		b[j]=new JButton(rows[j]+""+k);
	    		Keypad.add(b[i]);
	    		}
	    	j++;
	    }
	    
	    x.getContentPane().add(Keypad);
	
	}
	public void actionB2(ActionEvent e) {
		try {
			DBConnect x =new DBConnect();
			x.queryExecuter("insert into seatmaster values('"+ jc0.getSelectedItem()+"'."+
			jc2.getSelectedItem()+"',"+jc3.getSelectedItem()+")");
			JOptionPane.showMessageDialog(null,"Record Saved.");	
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);	
		}
	}
}
	
	


