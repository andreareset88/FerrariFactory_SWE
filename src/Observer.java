import java.io.IOException;

public interface Observer {
	void update() throws InterruptedException, IOException;
}
