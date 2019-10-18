package nicole_melo_taller1;

import processing.core.PApplet;
import processing.core.PImage;

public class Jugador {
	
	private String nombre;
	private int tipo;
	private int puntos;
	private PImage ima;
	private int posX, posY;
	private PImage bala;
	private int numeroBalas;
	private int xBala;
	private Bala balaEnemigo;
	public PApplet app;
	
	Jugador(PApplet app, String nombre, int tipo, int posX, int posY){
		this.app = app;
		this.nombre = nombre;
		this.tipo = tipo;
		this.posX = posX;
		this.posY = posY;
		puntos = 0;
		numeroBalas = 10;
		balaEnemigo = null;
		
		if(tipo == 1) {
			ima = app.loadImage("jugador1.png");
			bala = app.loadImage("balaAmarilla.png");
			xBala =280;
		}
		
		if(tipo == 2) {
			ima = app.loadImage("jugador2.png");
			bala = app.loadImage("balaAzul.png");
			xBala = 735;
		}
	}
	
	
	public void pintar() {
		
		pintarBalasEnemigo();
		app.image(ima, posX, posY);
		pintarBalasMenu();
		
	}
	
	public void pintarBalasEnemigo() {
		
		if(balaEnemigo != null) {
			balaEnemigo.pintar();
		}
		
	}
	
	public void pintarBalasMenu() {
		for (int i = 0; i < numeroBalas; i++) {
			app.image(bala,xBala+(i*22),575);
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


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getBalas() {
		return numeroBalas;
	}

	public void setBalas(int balas) {
		this.numeroBalas = balas;
	}


	public int getNumeroBalas() {
		return numeroBalas;
	}


	public void setNumeroBalas(int numeroBalas) {
		this.numeroBalas = numeroBalas;
	}


	public Bala getBalaEnemigo() {
		return balaEnemigo;
	}


	public void setBalaEnemigo(Bala balaEnemigo) {
		this.balaEnemigo = balaEnemigo;
	}
	
	
	

}
