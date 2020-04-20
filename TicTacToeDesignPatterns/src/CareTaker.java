import java.util.ArrayList;
//318383973
class CareTaker {
	private ArrayList<Memento> mementoStack = new ArrayList<>();

	public void addMemento(Memento m) {
		mementoStack.add(m);

	}

	public Memento getMemento() {
		Memento mementoToReturn = null;
		if(mementoStack.size()==0)
			return null;
		if (mementoStack.size() != 1) {
			mementoToReturn = new Memento(mementoStack.get(mementoStack.size() - 1).getWhoseTurn(),
					mementoStack.get(mementoStack.size() - 1).getCell());
			mementoStack.remove(mementoStack.size() - 1);
		} else {
			mementoToReturn = new Memento(mementoStack.get(0).getWhoseTurn(), mementoStack.get(0).getCell());
		}
		return mementoToReturn;
	}

	public int getNumOfMemento() {
		return mementoStack.size();
	}
	
}