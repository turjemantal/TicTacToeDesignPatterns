class NewGame
//318383973
{  static void newGame(MementoTicTacToe mementoTicTacToe,
		CareTaker careTaker)
	{ 
	int k=careTaker.getNumOfMemento();
	for (int i = 0; i < k; i++) {
		Undo.undo(mementoTicTacToe, careTaker);
	}
	
	}
}
