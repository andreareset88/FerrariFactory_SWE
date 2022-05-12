package Observer;

import Observer.Observer;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void attach(Observer o) {
		observers.add(o);
	}
	
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	public void Notify() throws InterruptedException, IOException {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
