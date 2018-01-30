package test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import client2.MobileCodeWSSoap;

public class MobileClient2 {
	public static void main(String[] args) throws Exception {
		// 1.����������ͼ
		/**
		 * ����1��wsdl��ַ
		 * ����2����������
		 */
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		/**
		 * ����1�������ռ��ַ
		 *       targetNamespace="http://WebXml.com.cn/"
		 * ����2��������ͼ����  ,service��nameֵ
		 */
		QName qName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
		Service service = Service.create(url,qName);
		// 2.��ȡ����ʵ����
		MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
		// 3.���ò�ѯ����
		String info = mobileCodeWSSoap.getMobileCodeInfo("13588761383", "");
		System.out.println(info);
		
	}
}
