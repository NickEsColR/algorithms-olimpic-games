package thread;
import ui.OlimpicAlgorithmsGUI;
public class ClockMovementThread extends Thread {
	
	//attribute
	
	private char algorithm; 
	
	//relations
	
	private OlimpicAlgorithmsGUI oagui;
	
	//methods
	
	public ClockMovementThread(OlimpicAlgorithmsGUI gui, char a) {
		oagui = gui;
		algorithm = a;
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		if(algorithm == 'a') {
			long end = System.currentTimeMillis();
			while(oagui.getRunningArrayList()) {	
				end = System.currentTimeMillis();
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oagui.setArrayListTime(end-start);
		}else if(algorithm == 'l') {
			long end = System.currentTimeMillis();
			while(oagui.getRunningLinkedList()) {
				end = System.currentTimeMillis();
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oagui.setLinkedListTime(end-start);
		}else if(algorithm == 't') {
			long end = System.currentTimeMillis();
			while(oagui.getRunningTree()) {	
				end = System.currentTimeMillis();
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oagui.setTreeTime(end-start);
		}else {
			while(oagui.getRunning()) {	
				long end = System.currentTimeMillis();
				oagui.setClockTime(end-start);
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
