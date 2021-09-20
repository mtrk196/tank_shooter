import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bullet {
int x,dx,y,dy,cx,cy;
Image still,jump;
ImageIcon i,k;
Fighter f;
Enemy en= new Enemy();
int count=0;
public Bullet(Fighter fi) {
	f = fi;
	ImageIcon i= new ImageIcon("G:\\Coding\\Swing\\nimg\\bullet.png");
	still = i.getImage();
	x=f.getX()+5;
	y=f.getY()+35;
}
public void move(Fighter fi, Enemy e) {
	en = e;
	if(x<845) {
	x=x+2;
	}
	else {
		x=fi.cx+5;
		y=fi.getY()+35;
	}
	System.out.println("Bullet x:"+x+"Bullet Y:"+y +"Enemy x:"+en.ex+"Enemy Y:"+en.ey);
	if(x>en.ex && x<en.ex+141 ) {
		if(y>en.ey && y<en.ey+128) {
			x=fi.getX();
			y=fi.getY();
			en.reset();
			count++;
		}
	}
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
	/*public void point() {
		
	}*/
}
