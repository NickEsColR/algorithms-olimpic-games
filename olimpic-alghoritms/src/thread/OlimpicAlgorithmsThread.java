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
				Thread arrayClockThread = new ClockMovementThread(oagui,'a');
				oagui.setRunningArrayList(true);
				if(algorithm == 'a') {
					arrayClockThread.start();
					try {
						olimpic.generateArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					try {
						olimpic.generateArrayList(number, false);
						arrayClockThread.start();
						olimpic.searchArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						olimpic.generateArrayList(number, false);
						arrayClockThread.start();
					
						olimpic.deleteArrayList(number, recursive);
						oagui.setRunningArrayList(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else if(athlete == 'l') {
				Thread linkedClockThread = new ClockMovementThread(oagui,'l');
				oagui.setRunningLinkedList(true);
				if(algorithm == 'a') {
					
					linkedClockThread.start();
					
					try {
						olimpic.generateLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					try {
						olimpic.generateLinkedList(number, recursive);
						
						linkedClockThread.start();
						olimpic.searchLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				}else {
					try {
						olimpic.generateLinkedList(number, recursive);
						
						linkedClockThread.start();
						olimpic.deleteLinkedList(number, recursive);
						oagui.setRunningLinkedList(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
			}else {		
				Thread treeClockThread = new ClockMovementThread(oagui,'t');
				oagui.setRunningTree(true);
				if(algorithm == 'a') {
					
							treeClockThread.start();
						
					try {
						olimpic.generateTree(number, recursive);
						oagui.setRunningTree(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(algorithm == 's') {
					try {
						olimpic.generateTree(number, recursive);
						olimpic.searchTree(number, recursive);
						oagui.setRunningTree(false);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						olimpic.generateTree(number, recursive);
								treeClockThread.start();
						olimpic.deleteTree(number, recursive);
						oagui.setRunningTree(false);
				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}