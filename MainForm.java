import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class MainForm extends JFrame implements ActionListener{
	
		
		JMenuBar mb1;
		JMenu Master , Trans ,Report ;
		JMenuItem mScreen , mSeat , mTime , mRate , mMovie;
		JMenuItem mBooking, mExit;
		
		public MainForm()
		{
		this.setVisible(true);
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb1 = new JMenuBar();
		Master = new JMenu("Master");
		Trans = new JMenu("Transaction");
		Report = new JMenu("Report");
		mScreen = new JMenuItem("Screen Master");
		mSeat = new JMenuItem("Seat Master");
		mTime = new JMenuItem("Time Master");
		mRate = new JMenuItem("Rate Master");
		mMovie = new JMenuItem("Movie Master");
		mBooking = new JMenuItem("Booking");
		JSeparator js1 = new JSeparator();
		mExit = new JMenuItem ("Exit");
		
		Master.add(mScreen);
		Master.add(mSeat);
		Master.add(mTime);
		Master.add(mRate);
		Master.add(mMovie);
		Master.add(js1);
		Master.add(mExit);
		
		Trans .add(mBooking);
		
		mb1.add(Master);
		mb1.add(Trans);
		mb1.add(Report);
		
		setJMenuBar(mb1);
		JLabel L1 = new JLabel("Multiplex Management");
		Font f = new Font("Sans-Serif", Font.BOLD,78);
		L1.setFont(f);
		L1.setForeground(Color.red);
		getContentPane().add(L1);
		this.setSize(801,788);
		this.setTitle("Multiplex Managment");
		mScreen.addActionListener(this);
		mSeat.addActionListener(this);
		mMovie.addActionListener(this);
		mTime.addActionListener(this);
		mRate.addActionListener(this);
		mExit.addActionListener(this);
		mBooking.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()== mScreen)
		
		{
			ScreenMaster frm = new ScreenMaster();
			frm.setVisible(true);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setBounds(100, 200, 300, 400);
			frm.setResizable(false);
		}
        if(e.getSource()== mTime)
			
		{
		TimeMaster frm =new TimeMaster();
			frm.setVisible(true);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setBounds(100, 200, 300, 400);
			frm.setResizable(false);
		}
		if(e.getSource()== mSeat)
			
		{
			SeatMaster frm = new SeatMaster();
			frm.setVisible(true);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setBounds(100, 200, 300, 400);
			frm.setResizable(false);
		}
        
		
		if(e.getSource()== mExit)
			
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String args[])
	{
		new MainForm();
	}
	

}
//java.io
//thread - Se
//networking socket
//rmi

