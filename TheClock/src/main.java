
public class main {

	public static void main(String[] args) {
		TheClock start = new TheClock();
		Thread t = new Thread(start);
		t.start();
	}

}
