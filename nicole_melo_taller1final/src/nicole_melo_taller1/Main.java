package nicole_melo_taller1;
import processing.core.PApplet;

public class Main extends PApplet{
	private Logica log;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("nicole_melo_taller1.Main");
	

	}
	public void settings() {
		size(1200,700);

	}
	public void setup() {
		log = new Logica(this);
	}
	public void draw() {
			
			background(0);
			log.dibujar();
	
	}

	public void mouseClicked () {
		log.click();
	}	

	public void keyPressed () {
		log.teclas();
	}
	
}
