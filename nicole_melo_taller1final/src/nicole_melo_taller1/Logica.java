package nicole_melo_taller1;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;


public class Logica implements Observer {
	
	private int pantalla = 0;
	private PApplet app;
	private PImage inicio,instrucciones, juego, enemigo1, enemigo2, enemigo3,
	jugador1, jugador2, contador, balaAmarilla, balaAzul,gana1, gana2;
	
	private Contador cont;
	
	

	
	private Jugador jugadorUno;
	private Jugador jugadorDos;
	
	private Enemigo lineaUno[];
	private Enemigo lineaDos[];
	private Enemigo lineaTres[];
	
	//private ControlServidor ref;
	
	public Logica(PApplet app) {
		this.app = app;
		cont = new Contador();
		cont.start();
		//ref = ControlServidor.getRef();
		//ref.addObserver(this);
		
		jugadorUno = new Jugador(app,"Jugado 1", 1, 100,200);
		jugadorDos = new Jugador(app,"Jugado 2", 2, 400,200);
		
		lineaUno = new Enemigo[30];
		lineaDos = new Enemigo[30];
		lineaTres = new Enemigo[30];
		
		
		for(int i = 0; i<lineaUno.length; i++) {
			lineaUno[i] = new Enemigo(app, (int)app.random(1,4),-i*500 ,50);
			lineaDos[i] = new Enemigo(app, (int)app.random(1,4),-i*500-300 ,200);
			lineaTres[i] = new Enemigo(app, (int)app.random(1,4),-i*500-150 ,400);
		}
					
		inicio = app.loadImage("inicio.png");
		instrucciones= app.loadImage("instrucciones.png");
		juego = app.loadImage("juego.png");
		enemigo1 =app.loadImage("enemigo1.png");
		enemigo2 =app.loadImage("enemigo2.png");
		enemigo3 =app.loadImage("enemigo3.png");
		jugador1 =app.loadImage("jugador1.png");
		jugador2 =app.loadImage("jugador2.png");
		contador =app.loadImage("contador.png");
		balaAmarilla =app.loadImage("balaAmarilla.png");
		balaAzul =app.loadImage("balaAzul.png");
		gana1 =app.loadImage("gana1.png");
		gana2 =app.loadImage("gana2.png");
	
	}
	
	public void dibujar() {
		
	switch(pantalla) {
	
	
	
		case 0:
			app.image(inicio,0,0);
		break;
			
			
		case 1:
			app.image(instrucciones, 0, 0);
		
		break;
			
		case 2:
			app.image(juego, 0, 0);
			app.image(contador, 250, 565);
			app.text(cont.contador, 585 , 610 );
			
			
			for(int i = 0; i<lineaUno.length; i++) {
				if(lineaUno[i] != null) {
					lineaUno[i].pintar();					
				}
				
				if(lineaDos[i] != null) {
					lineaDos[i].pintar();					
				}
				
				if(lineaTres[i] != null) {
					lineaTres[i].pintar();					
				}
			}
			
			jugadorUno.pintar();
			jugadorDos.pintar();
			validarDisparo();
			
			app.textSize(25);
			app.text(jugadorUno.getPuntos(), 530, 680);
			app.text(jugadorDos.getPuntos(), 670, 680);
		break;
			
		}
		
	}
	
	
	
public void click() {
	System.out.println(app.mouseX + " : " + app.mouseY);
	
	    switch(pantalla) {
     	
	    case 0:
 
	    if (app.mouseX >= 645  && app.mouseY >= 565 && app.mouseX <= 846 && app.mouseY <= 618 ){
			pantalla = 1;
		}
		break;
		
	    case 1:
	    	
	    	if(app.mouseX >= 524 && app.mouseY >= 569 && app.mouseX <= 728 && app.mouseY <= 616)
	    	{
	    		pantalla = 2; 
	    		
	    	}
	    	break;
	    	
	   case 2:
	   
		   if(app.mouseX >= 524 && app.mouseY >= 569 && app.mouseX <= 728 && app.mouseY <= 616){
	   			pantalla = 3; 
	    		
		   }
		   
		   break;
	    	
	 } 	
}


public void validarDisparo () {
	
	for (int i = 0; i < lineaUno.length; i++) {
			
			if(lineaUno[i] != null) {
				if(jugadorUno.getBalaEnemigo() != null) {				
					if( app.dist(jugadorUno.getBalaEnemigo().getPosX(), jugadorUno.getBalaEnemigo().getPosY(), lineaUno[i].getPosX(), lineaUno[i].getPosY())<50 ) {
						jugadorUno.setPuntos(jugadorUno.getPuntos() + lineaUno[i].getPuntos());
						jugadorUno.setBalaEnemigo(null);
						lineaUno[i]=null;
						break;
					}
				}
				
				if(jugadorDos.getBalaEnemigo() != null) {
					if( app.dist(jugadorDos.getBalaEnemigo().getPosX(), jugadorDos.getBalaEnemigo().getPosY(), lineaUno[i].getPosX(), lineaUno[i].getPosY())<50 ) {
						jugadorDos.setPuntos(jugadorDos.getPuntos() + lineaUno[i].getPuntos());
						jugadorDos.setBalaEnemigo(null);
						lineaUno[i]=null;
						break;
					}				
				}
			}else {
				break;
			}
		}
	
	for (int i = 0; i < lineaDos.length; i++) {
		
		if(lineaDos[i] != null) {
			if(jugadorUno.getBalaEnemigo() != null) {				
				if( app.dist(jugadorUno.getBalaEnemigo().getPosX(), jugadorUno.getBalaEnemigo().getPosY(), lineaDos[i].getPosX(), lineaDos[i].getPosY())<50 ) {
					jugadorUno.setPuntos(jugadorUno.getPuntos() + lineaDos[i].getPuntos());
					jugadorUno.setBalaEnemigo(null);
					lineaDos[i]=null;
					break;
				}
			}
			
			if(jugadorDos.getBalaEnemigo() != null) {
				if( app.dist(jugadorDos.getBalaEnemigo().getPosX(), jugadorDos.getBalaEnemigo().getPosY(), lineaDos[i].getPosX(), lineaDos[i].getPosY())<50 ) {
					jugadorDos.setPuntos(jugadorDos.getPuntos() + lineaDos[i].getPuntos());
					jugadorDos.setBalaEnemigo(null);
					lineaDos[i]=null;
					break;
				}				
			}
		}else {
			break;
		}
	}
	
	for (int i = 0; i < lineaTres.length; i++) {
			
			if(lineaTres[i] != null) {
				if(jugadorUno.getBalaEnemigo() != null) {				
					if( app.dist(jugadorUno.getBalaEnemigo().getPosX(), jugadorUno.getBalaEnemigo().getPosY(), lineaTres[i].getPosX(), lineaTres[i].getPosY())<50 ) {
						jugadorUno.setPuntos(jugadorUno.getPuntos() + lineaTres[i].getPuntos());
						jugadorUno.setBalaEnemigo(null);
						lineaTres[i]=null;
						break;
					}
				}
				
				if(jugadorDos.getBalaEnemigo() != null) {
					if( app.dist(jugadorDos.getBalaEnemigo().getPosX(), jugadorDos.getBalaEnemigo().getPosY(), lineaTres[i].getPosX(), lineaTres[i].getPosY())<50 ) {
						jugadorDos.setPuntos(jugadorDos.getPuntos() + lineaTres[i].getPuntos());
						jugadorDos.setBalaEnemigo(null);
						lineaTres[i]=null;
						break;
					}				
				}
			}else {
				break;
			}
		}
}

public void teclas () {
	
		if(app.key == 'v' || app.key == 'V' || app.key == ' ') {
			if(jugadorUno.getNumeroBalas()>0) {
				jugadorUno.setBalaEnemigo(new Bala(app, jugadorUno.getPosX(), jugadorUno.getPosY(), jugadorUno.getTipo()));
				jugadorUno.setNumeroBalas(jugadorUno.getNumeroBalas()-1);
				System.out.println("Disparar");
			}else {
				System.out.println("Debes recargar");
			}
		}
		
		if(app.key == '0') {
			if(jugadorDos.getNumeroBalas()>0) {
				jugadorDos.setBalaEnemigo(new Bala(app, jugadorDos.getPosX(), jugadorDos.getPosY(), jugadorDos.getTipo()));
				jugadorDos.setNumeroBalas(jugadorDos.getNumeroBalas()-1);
				System.out.println("Disparar");
			}else {
				System.out.println("Debes recargar");
			}
		}
		
		//Recargar
		if(app.key == 'r' || app.key == 'R') {
			if(jugadorUno.getNumeroBalas()<10) {
			jugadorUno.setNumeroBalas(10);
			}
		}
		
		if(app.key == '5' ) {
			if(jugadorDos.getNumeroBalas()<10) {
				jugadorDos.setNumeroBalas(10);
			}
		}
			
		//Jugador 1
		if(app.key == 'w' || app.key == 'W') {
			jugadorUno.setPosY(jugadorUno.getPosY() - 10);
		}
		
		if(app.key == 's' || app.key == 'S') {
			jugadorUno.setPosY(jugadorUno.getPosY() + 10);
		}
		
		if(app.key == 'a' || app.key == 'A') {
			jugadorUno.setPosX(jugadorUno.getPosX() - 10);
		}
		
		if(app.key == 'd' || app.key == 'D') {
			jugadorUno.setPosX(jugadorUno.getPosX() + 10);
		}
		
		
		//Jugador 2
		if(app.keyCode == app.UP) {
			jugadorDos.setPosY(jugadorDos.getPosY() - 10);
		}
		
		if(app.keyCode == app.DOWN) {
			jugadorDos.setPosY(jugadorDos.getPosY() + 10);
		}
		
		if(app.keyCode == app.RIGHT) {
			jugadorDos.setPosX(jugadorDos.getPosX() + 10);
		}
		
		if(app.keyCode == app.LEFT) {
			jugadorDos.setPosX(jugadorDos.getPosX() - 10);
		}
	}


	
	

	


			
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
