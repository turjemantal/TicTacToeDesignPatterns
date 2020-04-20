// -- exception for empty file, singleton error, 90
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class MementoTicTacToe extends Application
//318383973
{ private char whoseTurn;
  private Cell[][] cell;
  private Label lblStatus;
  private GridPane pane;
  private CareTaker careTaker=new CareTaker();
  private BorderPane borderPane;
  private HBox hBox;
  private Scene scene;
  private Stage stage; 
  private Button bUndo;
  private Button bNewGame;


@Override 
  public void start(Stage primaryStage)   throws IOException
  { if (SingletonForOneRun.getInstance() > 0)
    {   System.out.println(	SingletonForOneRun.SINGLETON_MESSAGE);
         return;
    }
    initalization();
    stage.setOnCloseRequest(e ->
    {	try
		{	SingletonForOneRun.resetInstance();
		}
		catch (IOException ex)
		{  ex.printStackTrace();
		}
	});
    bUndo.setOnAction(e -> 
    {
    	Undo.undo(this, careTaker)   ;
	});
    bNewGame.setOnAction(e -> 
    { 
    	NewGame.newGame(this, careTaker);
    });
  }
  Cell[][] getCell()
  {  return cell;	  
  }
  char getWhoseTurn()
  { return whoseTurn;
  }
  void setWhoseTurn(char whoseTurn)
  { this.whoseTurn = whoseTurn;
  }
  Label getLblStatus()
  { return lblStatus;	  
  }
  void setLblStatus(Label lblStatus)
  { this.lblStatus = lblStatus;	  
  }
  void initalization()
  {  pane = new GridPane();
	 cell =  new Cell[3][3];
	 careTaker = new CareTaker();
	 for (int i = 0; i < 3; i++)
     for (int j = 0; j < 3; j++)
          pane.add(cell[i][j] = new Cell(this, careTaker), i, j);
     whoseTurn = 'X';
     lblStatus = new Label("X's turn to play");
     lblStatus.setMinWidth(250);
     lblStatus.setMaxWidth(250);
     bUndo = new Button("Undo");
     bNewGame = new Button("NewGame");
     borderPane = new BorderPane();
     hBox = new HBox(100);
     hBox.setPadding(new Insets(15, 15, 15, 15));
     hBox.setStyle("-fx-background-color: gold");
     borderPane.setCenter(pane);
     hBox.getChildren().addAll(lblStatus, bUndo, bNewGame);
     borderPane.setBottom(hBox);
     scene = new Scene(borderPane, 750, 750);
     stage = new Stage();
     stage.setTitle("TicTacToe"); 
     stage.setScene(scene); 
     stage.show(); 
     stage.setAlwaysOnTop(true);
  }
  public static void main(String[] args)
  { launch(args);
  }
}

