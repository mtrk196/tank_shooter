import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{

	private JFrame frame;
	public JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private Container c;
	
	private void initialize() {
		//c=thisframe.getContentPane();
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(335, 151, 149, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBounds(335, 275, 149, 58);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/strtbckgrnd2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 845, 494);
		frame.getContentPane().add(label);
		
		//clicking Start Button
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FighterFrame ff=new FighterFrame();
				ff.setVisible(true);
				
			}
			
		});
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
	}
}
