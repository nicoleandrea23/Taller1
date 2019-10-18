package nicole_melo_taller1;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemigo {
	
	private PApplet app;
	private int tipo, posX = 10, posY = 50, puntos;
	private PImage imagen;
	

	Enemigo ( PApplet app, int tipo, int posX, int posY){
		this.app = app;
		this.tipo = tipo;
		this.posX = posX;
		this.posY = posY;
		
		if(tipo == 1) {
			imagen = app.loadImage("enemigo1.png");
			puntos = 5;
		}
		if(tipo == 2) {
			imagen = app.loadImage("enemigo2.png");
			puntos = 10;
		}
		if(tipo == 3) {
			imagen = app.loadImage("enemigo3.png");
			puntos = 15;
		}
	}
	
	
	public void pintar() {
		app.image(imagen, posX, posY,151-40,131-40);
		mover();
	}
	
	private void mover() {
		posX +=3;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
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


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
