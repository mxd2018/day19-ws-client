package test;

import client2.MobileCodeWS;
import client2.MobileCodeWSSoap;

public class MobileClient {
	public static void main(String[] args) {
		//1.����������ͼ
		MobileCodeWS mobileCodeWS = new MobileCodeWS();
		//2.��ȡ����ʵ����
		MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getPort(MobileCodeWSSoap.class);
		//3.���ò�ѯ����	
		String info = mobileCodeWSSoap.getMobileCodeInfo("15168381503", "");
		System.out.println(info);
		
	}
}
