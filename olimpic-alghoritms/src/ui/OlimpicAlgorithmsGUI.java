package ui;
import model.Olimpic;
import thread.OlimpicAlgorithmsThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class OlimpicAlgorithmsGUI {
	
	//constant 
	
	public static long SLEEP = 100;
	
	//attributes 
		
		private boolean running;
		private boolean runningArrayList;
		private boolean runningLinkedList;
		private boolean runningTree;
		
	  @FXML
	    private TextField txtAmount;

	    @FXML
	    private CheckBox cbAdd;

	    @FXML
	    private CheckBox cbSearch;

	    @FXML
	    private CheckBox cbDelete;

	    @FXML
	    private CheckBox cbIterative;

	    @FXML
	    private CheckBox cbRecursive;

	    @FXML
	    private Button btnRun;

	    @FXML
	    private TextField txtClock;

	    @FXML
	    private Circle shBigCirlce;

	    @FXML
	    private Circle shSmallCircle;

	    @FXML
	    private TextField txtArrayListClock;

	    @FXML
	    private TextField txtLinkedListClock;

	    @FXML
	    private TextField txtABBClock;

	//relations
	
	private Olimpic olimpic;
	
	//methods
	public OlimpicAlgorithmsGUI() {
		olimpic = new Olimpic();
	}
	
	@FXML
    public void run(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("something goes wrong");
		if(txtAmount.getText().trim().isEmpty()) {
			alert.setContentText("Digit an integer number to the fill after 'N:'");
			alert.showAndWait();
		}else if(!cbAdd.isSelected() && !cbSearch.isSelected() && !cbDelete.isSelected()) {
			alert.setContentText("Please select an algorithm");
			alert.showAndWait();
		}else if(!cbIterative.isSelected() && !cbRecursive.isSelected()) {
			alert.setContentText("Please select a mode");
			alert.showAndWait();
		}else {
		try {
			int number = Integer.parseInt(txtAmount.getText());
			btnRun.setDisable(true);
			running = true;
		if(cbAdd.isSelected()) {
			Thread arrayListThread = new OlimpicAlgorithmsThread(olimpic,this,'a',cbRecursive.isSelected(), 'a',number);			
			arrayListThread.start();
		}else if(cbSearch.isSelected()) {
			Thread arrayListThread = new OlimpicAlgorithmsThread(olimpic,this,'s',cbRecursive.isSelected(),'a',number);			
			arrayListThread.start();
		}else {
			Thread arrayListThread = new OlimpicAlgorithmsThread(olimpic,this,'d',cbRecursive.isSelected(),'a',number);			
			arrayListThread.start();
		}
		}catch(NumberFormatException e) {
			alert.setContentText("Digit a valid integer in the field after 'N:'");
			alert.showAndWait();
		}
		}
    }
	
    @FXML
    void addClick(ActionEvent event) {
    	cbSearch.setSelected(false);
    	cbDelete.setSelected(false);
    }
    @FXML
    void deleteClick(ActionEvent event) {
    	cbAdd.setSelected(false);
    	cbSearch.setSelected(false);
    }

    @FXML
    void iterativeClick(ActionEvent event) {
    	cbRecursive.setSelected(false);
    }

    @FXML
    void recursiveClick(ActionEvent event) {
    	cbIterative.setSelected(false);
    }

    @FXML
    void searchClick(ActionEvent event) {
    	cbAdd.setSelected(false);
    	cbDelete.setSelected(false);
    }
    
    public void setClockTime(long time) {
    	long second = time / 1000;
    	long milis = time - second;
    	long minutes = second/ 60;
    	txtClock.setText(minutes + " : "+second+" : "+milis);
    }
    
    public boolean getRunning() {
    	return running;
    }
    
    public void setRunning(boolean r) {
    	running = r;
    }
    
    public void setArrayListTime(long time) {
    	long second = time / 1000;
    	long milis = time - second;
    	long minutes = second/ 60;
    	txtArrayListClock.setText(minutes + " : "+second+" : "+milis);
    }
    public void setLinkedListTime(long time) {
    	long second = time / 1000;
    	long milis = time - second;
    	long minutes = second/ 60;
    	txtLinkedListClock.setText(minutes + " : "+second+" : "+milis);
    }
    public void setTreeTime(long time) {
    	long second = time / 1000;
    	long milis = time - second;
    	long minutes = second/ 60;
    	txtABBClock.setText(minutes + " : "+second+" : "+milis);
    }
    public void setRunningArrayList(boolean r) {
    	runningArrayList = r;
    }
    public void setRunningLinkedList(boolean r) {
    	runningLinkedList = r;
    }
    public void setRunningTree(boolean r) {
    	runningTree = r;
    }
    public boolean getRunningArrayList() {
    	return runningArrayList;
    }
    public boolean getRunningLinkedList() {
    	return runningLinkedList;
    }
    public boolean getRunningTree() {
    	return runningTree;
    }
}
