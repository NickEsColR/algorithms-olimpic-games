package thread;
import ui.OlimpicAlgorithmsGUI;
import model.Olimpic;
public class OlimpicAlgorithmsThread extends Thread {
	
	//relations 
	
	private OlimpicAlgorithmsGUI oagui;
	private Olimpic olimpic;
	
	//methods 
	
	public OlimpicAlgorithmsThread(Olimpic o, OlimpicAlgorithmsGUI gui) {
		oagui = gui;
		olimpic = o;	
	}
	
	@Override
	public void run() {
		
	}
}
