package rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MainMDI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMDI frame = new MainMDI();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("main");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMDI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoniqueRentalPayment = new JLabel("MONIQUE RENTAL PAYMENT SYSTEM");
		lblMoniqueRentalPayment.setForeground(Color.BLUE);
		lblMoniqueRentalPayment.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMoniqueRentalPayment.setBounds(10, 11, 414, 39);
		contentPane.add(lblMoniqueRentalPayment);
		
		JLabel lblWaterDistribution = new JLabel("Water Distribution");
		lblWaterDistribution.setForeground(Color.red);
		lblWaterDistribution.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		lblWaterDistribution.setBounds(125, 61, 185, 26);
		contentPane.add(lblWaterDistribution);
		
		JButton btnPayments = new JButton("Payments");
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Payment pay = new Payment();
				pay.setVisible(true);
				close();
			}

		});
		btnPayments.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPayments.setBounds(64, 118, 99, 23);
		contentPane.add(btnPayments);
		
		JButton btnWater = new JButton("Water");
		btnWater.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Water wat = new Water();
				wat.setVisible(true);
				close();
			}
		});
		btnWater.setBounds(254, 118, 89, 23);
		contentPane.add(btnWater);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(163, 184, 89, 23);
		contentPane.add(btnExit);
	}
	private void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}

