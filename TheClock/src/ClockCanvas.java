import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ClockCanvas extends Canvas {

	Image img;
	
	public ClockCanvas() {
		super();
	}

	public Image setImg(int num){
		
		switch(num){
		case 1 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_one.png");
			break;
		case 2 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_two.png");
			break;
		case 3 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_three.png");
			break;
		case 4 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_four.png");
			break;
		case 5 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_five.png");
			break;
		case 6 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_six.png");
			break;
		case 7 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_seven.png");
			break;
		case 8 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_eight.png");
			break;
		case 9 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_nine.png");
			break;
		case 0 :
			img = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_zero.png");
			break;
		}
		return null;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(img, 0, 0, this);
	}
}
