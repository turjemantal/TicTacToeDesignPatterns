class Undo
//318383973
{  static boolean undo(MementoTicTacToe mementoTicTacToe,
		CareTaker careTaker)
   { 
	Memento current=careTaker.getMemento();
	if(current==null)
		return false;
	current.getCell().setToken(' ');
	mementoTicTacToe.setWhoseTurn(current.getWhoseTurn());
	DrawToken.drawToken(current.getCell().getToken(), current.getCell());
	mementoTicTacToe.getLblStatus().setText(mementoTicTacToe.getWhoseTurn()+"'s turn");
	
      return true; 
   }
}
