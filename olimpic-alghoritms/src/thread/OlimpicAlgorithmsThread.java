package thread;
import ui.OlimpicAlgorithmsGUI;
import model.Olimpic;
public class OlimpicAlgorithmsThread extends Thread {
	
	//attributes
	private char algorithm;
	private boolean recursive;
	private char athlete;
	private int number;
	//relations 
	
	private OlimpicAlgorithmsGUI oagui;
	private Olimpic olimpic;
	
	
	//methods 
	
	public OlimpicAlgorithmsThread(Olimpic o, OlimpicAlgorithmsGUI gui, char a, boolean r,char at, int n) {
		oagui = gui;
		olimpic = o;	
		algorithm = a;
		recursive = r;
		athlete = at;
		number = n;
	}
	
	@Override
	public void run() {
		while(oagui.getRunning()) {
			if(athlete == 'a') {
				Thread clockThread = new ClockMovementThread(oagui,' ');
				Thread arrayClockThread = new ClockMovementThread(oagui,'a');
				oagui.setRunningArrayList(true);
				if(algorithm == 'a') {
					clockThread.start();
					arrayClockThread.start();
					try {
						olimpic.generateArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					
				}else {
					
				}
			}else if(athlete == 'l') {
				Thread linkedClockThread = new ClockMovementThread(oagui,'l');
				linkedClockThread.start();
				if(algorithm == 'a') {
							
				}else if(algorithm == 's') {
								
				}else {
								
				}
			}else {		
				Thread treeClockThread = new ClockMovementThread(oagui,'t');
				treeClockThread.start();
				if(algorithm == 'a') {
					
				}else if(algorithm == 's') {
				
				}else {
					
				}
			}
		}
	}
}
