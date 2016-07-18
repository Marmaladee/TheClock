import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class RGBChecker extends JFrame {

	int r, g, b;

	JSlider red = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider green = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider blue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JLabel rgb = new JLabel("RGB(0, 0, 0)", JLabel.CENTER);

	JPanel p1 = new JPanel(new BorderLayout());
	JPanel west = new JPanel(new GridLayout(0, 1));
	JPanel cen = new JPanel(new GridLayout(0, 1));
	JPanel p2 = new JPanel();

	JTextField rText = new JTextField(new JTextFieldLimit(3), "", 3);
	JTextField gText = new JTextField(new JTextFieldLimit(3), "", 3);
	JTextField bText = new JTextField(new JTextFieldLimit(3), "", 3);

	public RGBChecker() {
		super("RGB Checker");

		red.setMajorTickSpacing(50);
		red.setMinorTickSpacing(5);
		red.setPaintTicks(true);
		red.setPaintLabels(true);

		green.setMajorTickSpacing(50);
		green.setMinorTickSpacing(5);
		green.setPaintTicks(true);
		green.setPaintLabels(true);

		blue.setMajorTickSpacing(50);
		blue.setMinorTickSpacing(5);
		blue.setPaintTicks(true);
		blue.setPaintLabels(true);

		JLabel rlabel = new JLabel("RED");
		JLabel glabel = new JLabel("GREEN");
		JLabel blabel = new JLabel("BLUE");

		rlabel.setForeground(Color.red);
		glabel.setForeground(Color.green);
		blabel.setForeground(Color.blue);

		rgb.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 24));

		west.add(rlabel);
		west.add(rText);
		west.add(glabel);
		west.add(gText);
		west.add(blabel);
		west.add(bText);

		cen.add(red);
		cen.add(green);
		cen.add(blue);

		p1.add("West", west);
		p1.add("Center", cen);

		add("North", rgb);
		add("South", p1);
		add("Center", p2);

		red.addChangeListener(new Sevent());
		green.addChangeListener(new Sevent());
		blue.addChangeListener(new Sevent());
		rText.addKeyListener(new Sevent());
		gText.addKeyListener(new Sevent());
		bText.addKeyListener(new Sevent());

		setVisible(true);
		setSize(400, 400);
		setLocation(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class Sevent implements ChangeListener, KeyListener {

		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();

			if (e.getSource() == red) {
				r = source.getValue();
				rText.setText(String.valueOf(r));
			}
			if (e.getSource() == green) {
				g = source.getValue();
				gText.setText(String.valueOf(g));
			}
			if (e.getSource() == blue) {
				b = source.getValue();
				bText.setText(String.valueOf(b));
			}
			p2.setBackground(new Color(r, g, b));
			rgb.setText("RGB(" + r + "," + g + "," + b + ")");

		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			JTextField source = (JTextField) e.getSource();

			if (Integer.parseInt(source.getText()) < 256 && Integer.parseInt(source.getText()) >= 0) {
				if (e.getSource() == rText) {
					r = Integer.parseInt(source.getText());
					red.setValue(r);
				}
				if (e.getSource() == gText) {
					g = Integer.parseInt(source.getText());
					green.setValue(g);
				}
				if (e.getSource() == bText) {
					b = Integer.parseInt(source.getText());
					blue.setValue(b);
				}
			}
			p2.setBackground(new Color(r, g, b));
			rgb.setText("RGB(" + r + "," + g + "," + b + ")");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	class JTextFieldLimit extends PlainDocument {
		private int limit;

		public JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) {
			if (str == null) {
				return;
			}
			if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
				if ((getLength() + str.length()) <= limit) {
					try {
						super.insertString(offset, str, attr);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		// °ÏºÎ ÇÊ¿ä
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RGBChecker start = new RGBChecker();
	}

}
