package What_to_do;

class record{
	private int WhatDo; //�ΨӰO���ϥΪ̷Q�n������ 1=���� 2=��A 3=�T��
	private String thing; //�O���ϥΪ̿諸�F�� �i�H�O�����B��A�B�T��
	
	public boolean setWhatDo(int n){ //��WhatDo�@�ӭ�
		if(n>3 || n<1) return false; //���լO�_�����ĭȡA�p�G��J���X�k�A�h�^�� false
		else WhatDo=n;
		return true;
	}
	public void setThing(String s){ //��thing�@�ӭ�
		thing=s;
	}
	public int getWhatDo(){ //�Ǧ^WhatDo����
		return WhatDo;
	}
	public String getThing(){ //�Ǧ^thing����
		return thing;
	}
	public void show(){ //���WhatDo��thing����
		System.out.println("WhatDo="+WhatDo+", thing="+thing);
	}
}