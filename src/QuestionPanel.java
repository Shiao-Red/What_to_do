import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
	private int btnX = 250, btnY = 150;
	public JButton firstBtn = new JButton("男生");
	public JButton secondBtn = new JButton("女生");
	public JLabel[] boyImg = new JLabel[2], girlImg = new JLabel[2];
	// [0] 是笑臉 [1]是疑惑
	public JLabel message = new JLabel();
	private Image img;
	private ImageIcon imgcon;
	private Font btnFont = new Font("標楷體", Font.PLAIN, 22);
	private Font msgFont = new Font("標楷體", Font.PLAIN, 40);
	private ActionListener firstAL;
	private ActionListener secondAL;

	public QuestionPanel() {
		QuestionPanel thisQPanel = this;
		message.setText("請選擇你的角色");
		message.setLocation(250, 30);
		message.setSize(500, 100);
		message.setFont(msgFont);

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

		firstBtn.setForeground(Color.BLUE);
		firstBtn.setFont(btnFont);
		firstBtn.setLocation(btnX, btnY);
		firstBtn.setSize(300, 50);

		secondBtn.setForeground(Color.BLUE);
		secondBtn.setFont(btnFont);
		secondBtn.setLocation(btnX, btnY + 150);
		secondBtn.setSize(300, 50);

		this.add(message);
		this.add(boyImg[0]);
		this.add(girlImg[0]);
		this.add(firstBtn);
		this.add(secondBtn);
		this.setLayout(null);
		this.setSize(800, 600);
		
		firstAL= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisQPanel.girlImg[0].setVisible(false);
				thisQPanel.remove(girlImg[0]);
				secondBtn.removeActionListener(secondAL);
			}
		};
		secondAL=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisQPanel.boyImg[0].setVisible(false);
				thisQPanel.remove(boyImg[0]);
				firstBtn.removeActionListener(firstAL);
			}
		};
		
		firstBtn.addActionListener(firstAL);
		secondBtn.addActionListener(secondAL);

	}
}
