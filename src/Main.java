import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Main extends JFrame{
	
	class QuestionTree {
		private Node root;
		
		public QuestionTree() {
			this.root=new Node("要主食嗎?", 0);
		}
		
		public void addNodeAfter(String target, boolean isYes, String questionString) {
			Node node;
			node=findNode(target, root);
			if(isYes) {
				node.Yes=new Node(questionString, questionNumber);
			}
			else {
				node.No=new Node(questionString, questionNumber);
			}
		}
		
		private Node findNode(String target, Node n) {
			class Stack{
				public boolean isWentYes;
				public boolean isWentNo;
				public Node node;
			}
			
			int stackIndex=-1;
			Stack[] nodeStack=new Stack[100];
			
			stackIndex++;
			nodeStack[stackIndex]=new Stack();
			nodeStack[stackIndex].node=n;
			nodeStack[stackIndex].isWentYes=false;
			nodeStack[stackIndex].isWentNo=false;
			
			while(stackIndex >= 0) {
				if(nodeStack[stackIndex].node.question.equals(target)) break;
				else if(nodeStack[stackIndex].node.Yes != null && nodeStack[stackIndex].isWentYes==false) {
					nodeStack[stackIndex].isWentYes=true;
					stackIndex++;
					nodeStack[stackIndex]=new Stack();
					nodeStack[stackIndex].node=nodeStack[stackIndex-1].node.Yes;
					nodeStack[stackIndex].isWentNo=false;
					nodeStack[stackIndex].isWentYes=false;
				}
				else if(nodeStack[stackIndex].node.No != null && nodeStack[stackIndex].isWentNo==false) {
					nodeStack[stackIndex].isWentNo=true;
					stackIndex++;
					nodeStack[stackIndex]=new Stack();
					nodeStack[stackIndex].node=nodeStack[stackIndex-1].node.No;
					nodeStack[stackIndex].isWentNo=false;
					nodeStack[stackIndex].isWentYes=false;
				}
				else stackIndex--;
			}
		
			return nodeStack[stackIndex].node;
		}
		public void inorder() {
			recursiveInorder(root);
		}
		public void recursiveInorder(Node node) {
			if(node!=null) {
				recursiveInorder(node.Yes);
				System.out.println(node.question+" , "+node.questionNumber);
				recursiveInorder(node.No);
			}
		}
		public void setup() {
			//root的問題是 : 要主食嗎?
			//中間傳入的 boolean值，如果是 true 的話，代表加在 Yes 選項後。
			addNodeAfter("要主食嗎?", false, "要甜點嗎?");
			addNodeAfter("要甜點嗎?", true, "要喝飲料嗎?");
		}
	}
	
	private int questionNumber=-1;
	public boolean isBoy;
	private QuestionTree tree=new QuestionTree();
	private Node currentQuestion, previousQuestion;
	private QuestionPanel typeOfFood=new QuestionPanel();
	private JPanel textPanel=new JPanel();
	private JLabel backgroundLabel=null;
	private ImageIcon backgroundImage=new ImageIcon(".\\picture\\CLASSROOM.jpg");
	//背景圖片放在picture資料夾裡
	
	private ActionListener noAction=new ActionListener() {
		public void actionPerformed(ActionEvent e){
			if(Main.this.currentQuestion.No != null) {
				Main.this.previousQuestion=Main.this.currentQuestion;
				Main.this.currentQuestion=Main.this.currentQuestion.No;
				Main.this.typeOfFood.message.setText(currentQuestion.question);
				System.out.println("no");
			}
			else {
				Main.this.typeOfFood.message.setText("沒東西了");
			}
		}
	};
	private ActionListener yesAction=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Main.this.currentQuestion.Yes != null) {
				Main.this.previousQuestion=Main.this.currentQuestion;
				Main.this.currentQuestion=Main.this.currentQuestion.Yes;
				Main.this.typeOfFood.message.setText(currentQuestion.question);
				System.out.println("yes");
			}
			else {
				Main.this.typeOfFood.message.setText("沒東西了");
			}
		}
	};
	
	public Main() {
		super("今天要做什麼");
		//設定視窗的名稱
		typeOfFood.setup();
		tree.setup();
		
		
		typeOfFood.yesBtn.addActionListener(yesAction);
		typeOfFood.noBtn.addActionListener(noAction);
		
		currentQuestion=tree.root;
		
		typeOfFood=new QuestionPanel();
		typeOfFood.add(QuestionPanel.boyImg[0]);
		typeOfFood.add(QuestionPanel.girlImg[0]);
		typeOfFood.setLocation(0, 0);
		typeOfFood.setOpaque(false);
		
		this.add(textPanel);
		backgroundLabel=new JLabel(backgroundImage);
		//讓這個label採用圖片
		backgroundLabel.setBounds(0, 0, 800, 600);
		this.setSize(800, 561);
		//設定視窗的長跟寛
		this.setResizable(false);
		//限定視窗的大小
		this.setLocation(200, 100);
		//視窗的出現位置 x y
		
		this.add(typeOfFood);
		this.add(backgroundLabel);
		typeOfFood.yesBtn.addActionListener(yesAction);
		typeOfFood.noBtn.addActionListener(noAction);
		this.typeOfFood.message.setText(currentQuestion.question);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//點選 X 就是離開
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
		
}

