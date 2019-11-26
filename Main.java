package What_to_do;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int choose1=0; //記錄第一個選擇
		record user=new record(); //用來計錄使用者選項的類別
		
		System.out.println(question.WhatDo); //第一個問題
		System.out.println(question.WhatDoSelect); //顯示選項
		choose1=s.nextInt();
		
		while(user.setWhatDo(choose1)==false){ //檢視使用者輸入的數字
			System.out.println("輸入有誤，請重新輸入");
			System.out.println(question.WhatDoSelect);
			choose1=s.nextInt();
		}
		
		user.show();
		
		
	}

}
