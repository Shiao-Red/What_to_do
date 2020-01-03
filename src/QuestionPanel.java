import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
	public JButton firstBtn = new JButton();
	public JButton secondBtn = new JButton();
	public static JLabel[] boyImg = new JLabel[2], girlImg = new JLabel[2];
	// [0] 是笑臉 [1]是疑惑
	public JButton yesBtn = new JButton("是"), noBtn=new JButton("否");
	public JLabel message = new JLabel();
	private int btnX = 250, btnY = 180;
	private static Image img;
	private static ImageIcon imgcon;
	private static Font btnFont = new Font("標楷體", Font.PLAIN, 22);
	private static Font msgFont = new Font("標楷體", Font.PLAIN, 40);
	public ActionListener firstAL;
	public ActionListener secondAL;


	public static void setup() {
		imgcon = new ImageIcon(".\\picture\\LPCportrait32-2.png");
		img = imgcon.getImage();
		img = img.getScaledInstance(275, 350, java.awt.Image.SCALE_SMOOTH);
		imgcon = new ImageIcon(img);

		boyImg[0] = new JLabel(imgcon);
		boyImg[0].setLocation(0, 200);
		boyImg[0].setSize(275, 380);

		imgcon = new ImageIcon(".\\picture\\LPCportrait32-3.png");
		img = imgcon.getImage();
		img = img.getScaledInstance(275, 350, java.awt.Image.SCALE_SMOOTH);
		imgcon = new ImageIcon(img);

		boyImg[1] = new JLabel(imgcon);
		boyImg[1].setLocation(0, 200);
		boyImg[1].setSize(275, 380);

		imgcon = new ImageIcon(".\\picture\\girlLaughtFlip.png");
		img = imgcon.getImage();
		img = img.getScaledInstance(275, 350, java.awt.Image.SCALE_SMOOTH);
		imgcon = new ImageIcon(img);

		girlImg[0] = new JLabel(imgcon);
		girlImg[0].setLocation(480, 200);
		girlImg[0].setSize(350, 380);

		imgcon = new ImageIcon(".\\picture\\girlSadFlip.png");
		img = imgcon.getImage();
		img = img.getScaledInstance(275, 350, java.awt.Image.SCALE_SMOOTH);
		imgcon = new ImageIcon(img);

		girlImg[1] = new JLabel(imgcon);
		girlImg[1].setLocation(480, 200);
		girlImg[1].setSize(350, 380);
	}
	
	public QuestionPanel() {
		//message.setText(question);
		message.setLocation(300, 230);
		message.setSize(500, 100);
		message.setFont(msgFont);
		
		this.noBtn.setForeground(Color.BLUE);
		this.noBtn.setFont(btnFont);
		this.noBtn.setLocation(btnX, btnY + 150);
		this.noBtn.setSize(300, 50);
		
		this.yesBtn.setForeground(Color.BLUE);
		this.yesBtn.setFont(btnFont);
		this.yesBtn.setLocation(btnX, btnY);
		this.yesBtn.setSize(300, 50);
		
		this.add(yesBtn);
		this.add(noBtn);
		
		this.add(message);
		this.setLayout(null);
		this.setSize(800, 600);
	}
}
