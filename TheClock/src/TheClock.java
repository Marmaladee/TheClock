import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TheClock extends JFrame implements Runnable {

	JPanel[] p = new JPanel[6];
	JPanel[] colonP = new JPanel[2];
	ClockCanvas[] clockcan = new ClockCanvas[6];
	int[] num = { 0, 0, 0, 0, 0, 0 };
	Image colonImg = Toolkit.getDefaultToolkit().getImage("C:\\KDS\\workspace\\TheClock\\image\\resized_colon.jpg");

	public TheClock() {
		super("The Clock");

		for (int i = 0; i < 6; i++) {
			p[i] = new JPanel();
			p[i].setBackground(Color.white);
			clockcan[i] = new ClockCanvas();
			clockcan[i].setSize(100, 100);
			p[i].add(clockcan[i]);
		}
		for (int i = 0; i < 2; i++) {
			colonP[i] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					// TODO Auto-generated method stub
					super.paintComponent(g);
					g.drawImage(colonImg, 0, 0, this);
				}
			};
			colonP[i].setBackground(Color.white);
		}
		
		add(p[0]);
		add(p[1]);
		add(colonP[0]);
		add(p[2]);
		add(p[3]);
		add(colonP[1]);
		add(p[4]);
		add(p[5]);
		
		
		setLayout(new GridLayout(1, 0));
		setLocation(400, 200);
		setVisible(true);
		setSize(850, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void run() {
		while (true) {

			Calendar nowCal = Calendar.getInstance();
			if (nowCal.get(Calendar.HOUR) == 0) {
				num[0] = 1;
				num[1] = 2;
			} else if (nowCal.get(Calendar.HOUR) == 11) {
				num[0] = 1;
				num[1] = 1;
			} else if (nowCal.get(Calendar.HOUR) == 10) {
				num[0] = 1;
				num[1] = 0;
			} else {
				num[0] = 0;
				num[1] = nowCal.get(Calendar.HOUR);
			}
			num[2] = (nowCal.get(Calendar.MINUTE) / 10);
			num[3] = nowCal.get(Calendar.MINUTE) - (num[2] * 10);
			num[4] = (nowCal.get(Calendar.SECOND) / 10);
			num[5] = nowCal.get(Calendar.SECOND) - (num[4] * 10);

			for (int i = 0; i < 6; i++) {
				clockcan[i].setImg(num[i]);
				clockcan[i].repaint();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
