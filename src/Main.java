import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame{
	public Main() {
		super("今天要做什麼");
		this.setSize(800, 600);
		//設定視窗的長跟寛
		this.setLocation(200, 100);
		//視窗的出現位置 x y
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
		
}

