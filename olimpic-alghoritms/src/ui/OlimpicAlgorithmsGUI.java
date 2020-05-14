package ui;
import model.Olimpic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class OlimpicAlgorithmsGUI {
	
	//attributes 
	
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
    void run(ActionEvent event) {

    }
}
