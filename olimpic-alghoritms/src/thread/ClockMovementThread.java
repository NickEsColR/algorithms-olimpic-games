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
		long end = System.currentTimeMillis();
		if(algorithm == 'a') {
			while(oagui.getRunningArrayList()) {	
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			end = System.currentTimeMillis();
			long time = end -start;
			oagui.setArrayListTime(time);
		}else if(algorithm == 'l') {
			while(oagui.getRunningLinkedList()) {
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			end = System.currentTimeMillis();
			oagui.setLinkedListTime(end-start);
		}else if(algorithm == 't') {
			
			while(oagui.getRunningTree()) {	
				try {
					Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			end = System.currentTimeMillis();
			oagui.setTreeTime(end-start);
		}else {
			while(oagui.getRunning()) {	
				end = System.currentTimeMillis();
				long time = end-start;
				oagui.setClockTime(time);
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
