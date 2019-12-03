import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class frame extends JFrame{
	//視窗物件
	private JPanel p;
	private JButton btnMove;
	
	public frame(String name) {
		//視窗的建構
		super(name);
		this.setSize(300, 300);
		//設定視窗的長跟寛
		this.setLocation(200, 100);
		//視窗的出現位置 x y
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Main extends JFrame{
	public static void main(String[] args) {
		frame myf=new frame("hello");
	}
		
}

