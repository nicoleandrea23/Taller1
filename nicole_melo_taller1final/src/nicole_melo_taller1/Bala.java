package nicole_melo_taller1;

import processing.core.PApplet;
import processing.core.PImage;


public class Bala {
	

	private PApplet app;
	private PImage imagen;
	private int posX, posY;
	
	Bala (PApplet app, int posX, int posY, int tipo){
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		if(tipo == 1) imagen = app.loadImage("balaAmarilla.png");
		if(tipo == 2) imagen = app.loadImage("balaAzul.png");
	}
	
	public void pintar(){
		app.image(imagen,posX, posY);
		mover();
	}
	
	public void mover() {
		if(posY>0) {
			posY-=5;			
		}
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	

}
