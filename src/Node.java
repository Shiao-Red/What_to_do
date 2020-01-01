import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;

class Node{
	public String question;
	public int questionNumber;
	public Node Yes, No;
	
	public Node(String question, int questionNumber){
		this.question=question;
		this.questionNumber=questionNumber;
		
		this.Yes=null;
		this.No=null;
	}
}