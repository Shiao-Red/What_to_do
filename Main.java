package What_to_do;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int choose1=0; //�O���Ĥ@�ӿ��
		record user=new record(); //�Ψӭp���ϥΪ̿ﶵ�����O
		
		System.out.println(question.WhatDo); //�Ĥ@�Ӱ��D
		System.out.println(question.WhatDoSelect); //��ܿﶵ
		choose1=s.nextInt();
		
		while(user.setWhatDo(choose1)==false){ //�˵��ϥΪ̿�J���Ʀr
			System.out.println("��J���~�A�Э��s��J");
			System.out.println(question.WhatDoSelect);
			choose1=s.nextInt();
		}
		
		user.show();
		
		
	}

}
