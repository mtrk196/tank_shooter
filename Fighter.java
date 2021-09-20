import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Fighter {
int x,dx,y,dy,cx,cy;
public boolean lifeCounter=false;
Image still,jump;
ImageIcon i,k;
Enemy en;

public Fighter() {
	
	ImageIcon i= new ImageIcon("G:\\Coding\\Swing\\nimg\\C__fakepath_shooter.png");
	still = i.getImage();
	x=5;
	y=340;
}
public void move() {
	x=x+dx;
	}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public Image getImage() {
	return still;
}
public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==KeyEvent.VK_A) {
		x=x-5;
		cx=x;
	}
	if(key==KeyEvent.VK_D) {
		x=x+5;
		cx=x;
	}
	if (key == KeyEvent.VK_W) {
		y=y-10;
	}
	if(key==KeyEvent.VK_S) {
		y=y+10;
	}
	
}
public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==KeyEvent.VK_A) {
		x=0;
		//dx=0;
	}
	if(key==KeyEvent.VK_D) {
		x=0;
		//dx=0;
	}
	if (key == KeyEvent.VK_W) {
		y=0;
		//dy = 0;
    /*still = i.getImage();
		y=350;*/
    }
	if(key==KeyEvent.VK_S) {
		y=0;
		//dy=0;
	}	
}

	public boolean collision(Enemy e,Fighter f) {
		if(f.x+107>=e.ex && f.x<=e.ex) {
			if(f.x<e.ey && f.x+141>e.ey) {
				lifeCounter=true;
			}
		}
		return lifeCounter;
	}

}