package test;

import client2.MobileCodeWS;
import client2.MobileCodeWSSoap;

public class MobileClient {
	public static void main(String[] args) {
		//1.创建服务视图
		MobileCodeWS mobileCodeWS = new MobileCodeWS();
		//2.获取服务实现类
		MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getPort(MobileCodeWSSoap.class);
		//3.调用查询方法	
		String info = mobileCodeWSSoap.getMobileCodeInfo("15168381503", "");
		System.out.println(info);
		
	}
}
