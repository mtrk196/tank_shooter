import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

//import Board.AL;

import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JTextField;

public class FighterFrame extends JFrame implements ActionListener{
	Fighter f;
	Timer time;
	//int gameTime=0;
	Enemy en;
	Bullet m;
	boolean app=true;
	//public boolean lifeCounter=false;
	//int second=0;
	//Bullet m= new Bullet();
	//static Font scores =new Font("Scores :",Font.BOLD,24);
	//private JTextField txtScore;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FighterFrame frame = new FighterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FighterFrame() {
		f=new Fighter();
		en=new Enemy();
		m= new Bullet(f);
		//s=new HighScore(m);
		/*gameTime= new Timer();
		TimerTask task = new TimerTask() {
			
		}*/
		addKeyListener(new AL());
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 494);
		getContentPane().setLayout(null);
		
		JLabel fbackground = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("ffbackkground.png")).getImage();
		fbackground.setIcon(new ImageIcon(img));
		fbackground.setBounds(0, 0, 829, 455);
		getContentPane().add(fbackground);
		//txtScore.setColumns(10);
		time =new Timer(5,this);
		time.start();
		
	//	System.out.println(r);
//		if(f.lifeCounter==true) {

	//	}
		
	}
	public void actionPerformed(ActionEvent e) {
		f.move();
		en.movement();
		m.move(f, en);
		if(f.lifeCounter==true) {
		try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("Score.txt",app))))
        {
            writer.write("Total Score: " + m.count); // writes score
            writer.close();
        }

        catch (IOException error) {
            error.printStackTrace();
        }
		}
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
			Graphics g2d =(Graphics2D) g;
			g.setColor(Color.WHITE);
			g2d.fillRect(740, 34, 90, 20);
			//g2d.fillRect(300,34,300,151);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial",3,10));
			g2d.drawString("SCORE:"+m.count,742,45);
			g2d.drawString("LIFE:"+f.collision(en, f),302, 45);
			g2d.drawImage(m.getImage(), m.getX(),m.getY(), null);
			g2d.drawImage(f.getImage(), f.getX(), f.getY(),null);
			g2d.drawImage(en.getEImage(), en.getEX(), en.getEY(),null);
			if(f.lifeCounter==true) {
				g.setColor(Color.WHITE);
				g2d.fillRect(300,150,300,160);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Arial",3,50));
				g2d.drawString("Game Over",320,250);
			}
	}
	private class AL extends KeyAdapter{
		public void keyRealeased(KeyEvent e) {
			f.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			f.keyPressed(e);
		}
		/*public boolean collision(Enemy e,Fighter f) {
			if(f.x+107>=e.ex && f.x<=e.ex) {
				if(f.x<e.ey && f.x+141>e.ey) {
					lifeCounter=true;
				}
			}
			return lifeCounter;
		}*/
	}
}


