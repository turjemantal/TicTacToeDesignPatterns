import javafx.scene.layout.Pane;
class Cell extends Pane
//318383973
  { private char token = ' ';
    private MementoTicTacToe mementoTicTacToe; 
    private CareTaker careTaker;
    Cell(MementoTicTacToe mementoTicTacToe,
    		CareTaker careTaker)
    { this.mementoTicTacToe = mementoTicTacToe;
      this.careTaker = careTaker;  
      setStyle("-fx-border-color: black"); 
      this.setPrefSize(2000, 2000);
      this.setOnMouseClicked(e -> 
      {  HandleMouseClick.handleMouseClick(this);
    	 setANDrequestFocus(); 
  	  });
    }
    private void setANDrequestFocus()
    { setFocusTraversable(true);
      requestFocus(); 
    }
    MementoTicTacToe getMementoTicTacToe()
    { return mementoTicTacToe;   
    }
    CareTaker getCareTaker()
    { return careTaker;    	
    }
    char getToken()
    { return token;
    }
    void setToken(char token)
    { this.token = token;
    }
  }   