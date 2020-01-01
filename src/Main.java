import java.util.*;
import java.awt.BorderLayout;
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
		public Node findNode(String target, Node node) {
			if(node!=null) {
				questionNumber++;
				findNode(target, node.Yes);
				if(node.question.equals(target)) return node;
				findNode(target, node.No);
			}
			return null;
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
			this.addNodeAfter("要主食嗎?", true, "要屁眼嗎?");
		}
	}
	private int questionNumber=-1;
	public boolean isBoy;
	private Node currentQuestion, previousQuestion;
	private QuestionPanel typeOfFood=new QuestionPanel();
	private JPanel imagePanel=null, textPanel=new JPanel();
	private JLabel backgroundLabel=null;
	private ImageIcon backgroundImage=new ImageIcon(".\\picture\\CLASSROOM.jpg");
	//背景圖片放在picture資料夾裡
	
	private ActionListener noBtnActionListener=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			currentQuestion=currentQuestion.No;
		}
	};
	private ActionListener yesBtnActionListener=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			currentQuestion=currentQuestion.Yes;
		}
	};
	
	public Main() {
		super("今天要做什麼");
		//設定視窗的名稱
		QuestionPanel.setup();
		//TypeOfFood.setup();
		
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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//點選 X 就是離開
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main.QuestionTree tree=new Main().new QuestionTree();
		tree.setup();
		tree.inorder();
		new Main();
	}
		
}

