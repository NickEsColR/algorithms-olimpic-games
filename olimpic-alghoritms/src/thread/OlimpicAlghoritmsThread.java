package thread;
import ui.OlimpicAlghoritmsGUI;
import model.Olimpic;
public class OlimpicAlghoritmsThread extends Thread {
	
	//relations 
	
	private OlimpicAlghoritmsGUI oagui;
	private Olimpic olimpic;
	
	//methods 
	
	public OlimpicAlghoritmsThread(Olimpic o, OlimpicAlghoritmsGUI gui) {
		oagui = gui;
		olimpic = o;	
	}
	
	@Override
	public void run() {
		
	}
}
