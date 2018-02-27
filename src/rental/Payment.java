package rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
					frame.setVisible(true);
					frame.setLocation(300, 300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Payment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPayments = new JLabel("Add Payments");
		lblAddPayments.setForeground(Color.BLUE);
		lblAddPayments.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		lblAddPayments.setBounds(20, 11, 164, 32);
		contentPane.add(lblAddPayments);
		
		JLabel lblHouseNumber = new JLabel("House Number :");
		lblHouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHouseNumber.setBounds(31, 54, 112, 28);
		contentPane.add(lblHouseNumber);
		
		JLabel lblTenantName = new JLabel("Tenant Name :");
		lblTenantName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenantName.setBounds(31, 93, 112, 28);
		contentPane.add(lblTenantName);
		
		JLabel lblAmountDeposited = new JLabel("Amount Paid :");
		lblAmountDeposited.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmountDeposited.setBounds(31, 129, 112, 28);
		contentPane.add(lblAmountDeposited);
		
		textField = new JTextField();
		textField.setBounds(135, 59, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 98, 139, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 132, 139, 20);
		contentPane.add(textField_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection myconn = DriverManager.getConnection("JDBC:mysql://localhost:3306/rental","root","Mbugua21");
					
					
					String query = "insert into payment (HouseNo,TenantName,AmountPd,DatePd) values (?,?,?,?)";
					
					PreparedStatement mystmt = myconn.prepareStatement(query);
					mystmt.setString(1,textField.getText() );
					mystmt.setString(2,textField_1.getText() );
					mystmt.setString(3,textField_2.getText() );
					mystmt.setString(4,textField_3.getText() );
					
					mystmt.execute();
					
					 JOptionPane.showMessageDialog(null, "Data Saved");
					mystmt.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(203, 216, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMDI main = new MainMDI();
				main.setVisible(true);
				close();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(315, 216, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblDatePaid = new JLabel("Date Paid :");
		lblDatePaid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatePaid.setBounds(31, 164, 112, 28);
		contentPane.add(lblDatePaid);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 169, 139, 20);
		contentPane.add(textField_3);
	}

	protected void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
