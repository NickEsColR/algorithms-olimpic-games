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
			Thread clockThread = new ClockMovementThread(oagui,' ');
			if(athlete == 'a') {
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
					try {
						olimpic.generateArrayList(number, false);
						clockThread.start();
						arrayClockThread.start();
						olimpic.searchArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						olimpic.generateArrayList(number, false);
						clockThread.start();
						arrayClockThread.start();
						olimpic.deleteArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else if(athlete == 'l') {
				Thread linkedClockThread = new ClockMovementThread(oagui,'l');
				linkedClockThread.start();
				if(algorithm == 'a') {
					clockThread.start();
					linkedClockThread.start();
					try {
						olimpic.generateLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					try {
						olimpic.generateLinkedList(number, recursive);
						clockThread.start();
						linkedClockThread.start();
						olimpic.searchLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				}else {
					try {
						olimpic.generateLinkedList(number, recursive);
						clockThread.start();
						linkedClockThread.start();
						olimpic.deleteLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
			}else {		
				Thread treeClockThread = new ClockMovementThread(oagui,'t');
				treeClockThread.start();
				if(algorithm == 'a') {
					clockThread.start();
					treeClockThread.start();
					try {
						olimpic.generateTree(number, recursive);
						oagui.setRunningTree(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					try {
						olimpic.generateTree(number, recursive);
						clockThread.start();
						treeClockThread.start();
						olimpic.searchTree(number, recursive);
						oagui.setRunningTree(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						olimpic.generateTree(number, recursive);
						clockThread.start();
						treeClockThread.start();
						olimpic.deleteTree(number, recursive);
						oagui.setRunningTree(false);
						oagui.setRunning(false);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
