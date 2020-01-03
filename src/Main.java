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
			this.root=new Node("要吃飯嗎?", 0);
		}
		
		public void addNodeAfter(String target, boolean isYes, String questionString) {
			Node node;
			node=findNode(target, root);
			if(isYes) {
				node.Yes=new Node(questionString, questionNumber);
				System.out.println("加入:"+questionString+"成功");
			}
			else {
				node.No=new Node(questionString, questionNumber);
				System.out.println("加入:"+questionString+"成功");
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
			//底層品項要用"否"選項來更換
			addNodeAfter("要吃飯嗎?", true, "要甜點嗎?");
			addNodeAfter("要吃飯嗎?", false, "戶外活動?");
			addNodeAfter("戶外活動?", false, "室內運動?");
			addNodeAfter("戶外活動?", true, "戶外運動?");
			addNodeAfter("要甜點嗎?", true, "要喝飲料嗎?");
			addNodeAfter("要甜點嗎?", false, "要熱食嗎?");
			addNodeAfter("戶外運動?", true, "戶外球類運動?");
			addNodeAfter("戶外運動?", false, "靜態戶外運動?");
			addNodeAfter("室內運動?", false, "遊戲類?");
			addNodeAfter("室內運動?", true, "室內球類運動?");
			addNodeAfter("要熱食嗎?", false, "要吃小吃嗎?");
			addNodeAfter("要熱食嗎?", true, "要吃炸物嗎?");
			addNodeAfter("要喝飲料嗎?", true, "要有料嗎?");
			addNodeAfter("要喝飲料嗎?", false, "要固體嗎?");
			addNodeAfter("戶外球類運動?", true, "網球?");
			addNodeAfter("戶外球類運動?", false, "直排輪?");
			addNodeAfter("靜態戶外運動?", false, "逛街?");
			addNodeAfter("靜態戶外運動?", true, "野餐?");
			addNodeAfter("室內球類運動?", true, "羽球?");
			addNodeAfter("室內球類運動?", false, "瑜珈?");
			addNodeAfter("遊戲類?", true, "電子遊戲?");
			addNodeAfter("遊戲類?", false, "看電影?");
			addNodeAfter("要吃小吃嗎?", true, "辣脆腸?");
			addNodeAfter("要吃小吃嗎?", false, "涼麵?");
			addNodeAfter("要吃炸物嗎?", true, "炸雞?");
			addNodeAfter("要吃炸物嗎?", false, "串燒?");
			addNodeAfter("要固體嗎?", true, "蛋糕?");
			addNodeAfter("要固體嗎?", false, "紅豆湯?");
			addNodeAfter("要有料嗎?", true, "波霸奶茶?");
			addNodeAfter("要有料嗎?", false, "紅茶?");	
			addNodeAfter("野餐?", false, "釣魚?");
			addNodeAfter("釣魚?", false, "露營?");
			addNodeAfter("逛街?", false, "遊樂園?");
			addNodeAfter("遊樂園?", false, "兜風?");
			addNodeAfter("直排輪?", false, "滑板?");
			addNodeAfter("滑板?", false, "爬山?");
			addNodeAfter("網球?", false, "排球?");
			addNodeAfter("排球?", false, "籃球?");
			addNodeAfter("電子遊戲?", false, "密室逃脫?");
			addNodeAfter("密室逃脫?", false, "桌遊?");
			addNodeAfter("遊戲類?", false, "看電影?");
			addNodeAfter("看電影?", false, "唱歌?");
			addNodeAfter("唱歌?", false, "看展覽?");
			addNodeAfter("羽球?", false, "桌球?");
			addNodeAfter("桌球?", false, "壁球?");
			addNodeAfter("瑜珈?", false, "重訓?");
			addNodeAfter("重訓?", false, "游泳?");
			addNodeAfter("蛋糕?", false, "舒芙蕾?");
			addNodeAfter("舒芙蕾?", false, "可麗餅?");
			addNodeAfter("紅豆湯?", false, "湯圓?");
			addNodeAfter("湯圓?", false, "芋園?");
			addNodeAfter("芋園?", false, "豆花?");
			addNodeAfter("要有料嗎?", true, "波霸奶茶?");
			addNodeAfter("要有料嗎?", false, "紅茶?");
			addNodeAfter("紅茶?", false, "牛奶?");
			addNodeAfter("牛奶?", false, "咖啡?");
			addNodeAfter("波霸奶茶?", false, "檸檬愛玉?");
			addNodeAfter("檸檬愛玉?", false, "仙草奶凍?");
			addNodeAfter("炸雞?", false, "薯條?");
			addNodeAfter("薯條?", false, "鹹酥雞?");
			addNodeAfter("串燒?", false, "炭烤?");
			addNodeAfter("炭烤?", false, "章魚燒?");
			addNodeAfter("辣脆腸?", false, "鹹水雞?");
			addNodeAfter("鹹水雞?", false, "滷味?");
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
				System.out.println(Main.this.currentQuestion.question);
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
				System.out.println(Main.this.currentQuestion.question);
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

