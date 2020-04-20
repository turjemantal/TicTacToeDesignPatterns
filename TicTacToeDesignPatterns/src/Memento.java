class Memento
//318383973
  { private char whoseTurn;
    private Cell cell;
    Memento(char whoseTurn, Cell cell)
    { this.whoseTurn = whoseTurn; 
      this.cell = cell;
    }
    char getWhoseTurn()
    { return whoseTurn;
    }
    Cell getCell()
    { return cell;
    }
  }