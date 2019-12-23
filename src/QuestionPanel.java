import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

public class QuestionPanel extends JPanel{
	private int btnX=250, btnY=150;
	private JButton boyBtn=new JButton("男生");
	private JButton girlBtn=new JButton("女生");
	private JLabel boyImg, girlImg;
	private JLabel message;
	private Image img;
	private ImageIcon imgcon;
	private Font font=new Font("標楷體", Font.PLAIN, 22);
	
	public QuestionPanel(){
		imgcon=new ImageIcon(".\\picture\\LPCportrait32-2.png");
		img=imgcon.getImage();
		img=img.getScaledInstance(275, 350,  java.awt.Image.SCALE_SMOOTH);
		imgcon=new ImageIcon(img);
		
		boyImg=new JLabel(imgcon);
		boyImg.setLocation(0, 200);
		boyImg.setSize(275, 380);
		
		imgcon=new ImageIcon(".\\picture\\girlLaughtFlip.png");
		img=imgcon.getImage();
		img=img.getScaledInstance(275, 350,  java.awt.Image.SCALE_SMOOTH);
		imgcon=new ImageIcon(img);
		
		girlImg=new JLabel(imgcon);
		girlImg.setLocation(480, 200);
		girlImg.setSize(350, 380);
		
		boyBtn.setForeground(Color.BLUE);
		boyBtn.setFont(font);
		boyBtn.setLocation(btnX, btnY);
		boyBtn.setSize(300, 50);
		
		girlBtn.setForeground(Color.BLUE);
		girlBtn.setFont(font);
		girlBtn.setLocation(btnX, btnY+150);
		girlBtn.setSize(300, 50);
		
		this.add(boyImg);
		this.add(girlImg);
		this.add(boyBtn);
		this.add(girlBtn);
		this.setLayout(null);
		this.setSize(800, 600);
	}
}
