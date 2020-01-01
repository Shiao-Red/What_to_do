import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;

class Node{
	public JButton yesBtn = new JButton(), noBtn=new JButton();
	public String question;
	public int questionNumber;
	public Node Yes, No;
	
	private static Font btnFont = new Font("º–∑¢≈È", Font.PLAIN, 22);
	private static int btnX = 250, btnY = 180;
	
	public Node(String question, int questionNumber){
		this.question=question;
		this.questionNumber=questionNumber;
		
		this.yesBtn.setForeground(Color.BLUE);
		this.yesBtn.setFont(btnFont);
		this.yesBtn.setLocation(btnX, btnY);
		this.yesBtn.setSize(300, 50);
		
		this.noBtn.setForeground(Color.BLUE);
		this.noBtn.setFont(btnFont);
		this.noBtn.setLocation(btnX, btnY + 150);
		this.noBtn.setSize(300, 50);
		
		this.Yes=null;
		this.No=null;
	}
}