package test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import client2.MobileCodeWSSoap;

public class MobileClient2 {
	public static void main(String[] args) throws Exception {
		// 1.创建服务视图
		/**
		 * 参数1：wsdl地址
		 * 参数2：服务名称
		 */
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		/**
		 * 参数1：命名空间地址
		 *       targetNamespace="http://WebXml.com.cn/"
		 * 参数2：服务视图名称  ,service的name值
		 */
		QName qName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
		Service service = Service.create(url,qName);
		// 2.获取服务实现类
		MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
		// 3.调用查询方法
		String info = mobileCodeWSSoap.getMobileCodeInfo("13588761383", "");
		System.out.println(info);
		
	}
}
