import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void Attach(Observer o) {
		observers.add(o);
	}
	
	public void Detach(Observer o) throws InterruptedException {
		observers.remove(o);
		Notify();
	}
	
	public void Notify() throws InterruptedException {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
}
