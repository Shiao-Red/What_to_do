import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class Main extends JFrame{
	private QuestionPanel QPanel=new QuestionPanel();
	private JPanel imagePanel=null, textPanel=new JPanel();
	private JLabel backgroundLabel=null;
	private ImageIcon backgroundImage=new ImageIcon(".\\picture\\spring.jpg");
	//背景圖片放在picture資料夾裡
	
	public Main() {
		super("今天要做什麼");
		//設定視窗的名稱
		QPanel.setLocation(0, 0);
		QPanel.setOpaque(false);
		
		this.add(textPanel);
		backgroundLabel=new JLabel(backgroundImage);
		//讓這個label採用圖片
		backgroundLabel.setBounds(0, 0, 800, 600);
		this.setSize(800, 600);
		//設定視窗的長跟寛
		this.setResizable(false);
		//限定視窗的大小
		this.setLocation(200, 100);
		//視窗的出現位置 x y
		
		this.add(QPanel);
		this.add(backgroundLabel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//點選 X 就是離開
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
		
}

