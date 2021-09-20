import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy {
int ex,edx,ey,edy;
Image still,jump;
ImageIcon i,k;
Bullet bul;
public Enemy() {
	
	ImageIcon i= new ImageIcon("G:\\Coding\\Swing\\nimg\\tank.png");
	still=i.getImage();
	ex=850;
	ey=350;
}
public void movement() {
	if(ex>1) {
	ex=ex-1;
	}
	else {
		ex=850;
	}
	System.out.println("ENEMY " + ex + " " + ey);
}
public int getEX() {
	return ex;
}
public int getEY() {
	return ey;
}
public Image getEImage() {
	return still;
}
public int reset() {
	ex=850;
	return ex;
}
}