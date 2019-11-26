package What_to_do;

class record{
	private int WhatDo; //用來記錄使用者想要做什麼 1=食物 2=衣服 3=娛樂
	private String thing; //記錄使用者選的東西 可以是食物、衣服、娛樂
	
	public boolean setWhatDo(int n){ //給WhatDo一個值
		if(n>3 || n<1) return false; //測試是否為有效值，如果輸入不合法，則回傳 false
		else WhatDo=n;
		return true;
	}
	public void setThing(String s){ //給thing一個值
		thing=s;
	}
	public int getWhatDo(){ //傳回WhatDo的值
		return WhatDo;
	}
	public String getThing(){ //傳回thing的值
		return thing;
	}
	public void show(){ //顯示WhatDo跟thing的值
		System.out.println("WhatDo="+WhatDo+", thing="+thing);
	}
}