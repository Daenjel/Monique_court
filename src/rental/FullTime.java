package rental;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class FullTime extends JFrame {

	private JPanel contentPane;
	private JTable table;

	Connection myconn = null;
	PreparedStatement mystmt = null;
	ResultSet myRs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FullTime frame = new FullTime();
				frame.setVisible(true);
				frame.setResizable(false);
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FullTime() {
		setTitle("Full Time");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Water wat = new Water();
				wat.setVisible(true);
				close();
			}
		});
		panel.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		panel.add(btnPrint);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try
		{
			myconn = DriverManager.getConnection("JDBC:mysql://localhost:3306/rental","root","Mbugua21");
			
			mystmt = myconn.prepareStatement("select *from payment where AmountPd>=?");
			
			mystmt.setDouble(1,10000);
						
			myRs = mystmt.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(myRs));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	protected void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}