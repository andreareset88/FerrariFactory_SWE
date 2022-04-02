import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void Attach(Observer o) {
		observers.add(o);
	}
	
	public void Detach(Observer o) {
		observers.remove(o);
		Notify();
	}
	
	public void Notify() {
		for(int i=0; i<observers.size(); i++) {
			observers.get(i).Update();
		}
	}
}
