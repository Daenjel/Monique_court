package rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Water extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Water frame = new Water();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Water Distribute");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Water() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFullTime = new JButton("Full Time");
		btnFullTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FullTime ful = new FullTime();
				ful.setVisible(true);
				ful.setResizable(false);
				close();
				
				
			}
			
		});
		btnFullTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFullTime.setBounds(10, 96, 89, 23);
		contentPane.add(btnFullTime);
		
		JButton btnHalfDay = new JButton("Half Day");
		btnHalfDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HalfDay Half = new HalfDay();
				Half.setVisible(true);
				Half.setResizable(false);
				close();
				
			}
			
		});
		btnHalfDay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHalfDay.setBounds(133, 96, 89, 23);
		contentPane.add(btnHalfDay);
		
		JButton btnMorningHours = new JButton("Morning Hours");
		btnMorningHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Morning Morn = new Morning();
				Morn.setVisible(true);
				Morn.setResizable(false);
				close();
				
			}
			
		});
		btnMorningHours.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMorningHours.setBounds(257, 96, 140, 23);
		contentPane.add(btnMorningHours);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMDI main = new MainMDI();
				main.setVisible(true);
				close();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(153, 181, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblWaterDistribution = new JLabel("Water Distribution");
		lblWaterDistribution.setForeground(Color.BLUE);
		lblWaterDistribution.setFont(new Font("Lucida Handwriting", Font.PLAIN, 22));
		lblWaterDistribution.setBounds(38, 29, 359, 36);
		contentPane.add(lblWaterDistribution);
	}

	protected void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}
