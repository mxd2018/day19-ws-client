package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class MobileClient3 {
	private static String getXML(String string) {
		// TODO Auto-generated method stub
		String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
				"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"  <soap:Body>\r\n" + 
				"    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\r\n" + 
				"      <mobileCode>"+string+"</mobileCode>\r\n" + 
				"      <userID></userID>\r\n" + 
				"    </getMobileCodeInfo>\r\n" + 
				"  </soap:Body>\r\n" + 
				"</soap:Envelope>";
		return xml;
	}
	
	public static void treeWalk(Document document) {
	     treeWalk( document.getRootElement());
	}
	public static void treeWalk(Element element) {
	        for ( int i = 0, size = element.nodeCount(); i < size; i++ ) {
	            Node node = element.node(i);
	            if ( node instanceof Element ) {
	                treeWalk( (Element) node );
	            }
	            else {
	                // do something....
	            	if (node.getNodeTypeName().equals("Text")) {
	            		System.out.println(node.getText());
					}
	            }
	        }
	    }
	
	public static void main(String[] args) throws Exception {
		// 1.创建服务地址，不是WSDL地址ַ
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
		// 2.打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 3.设置参数
		// 3.1发送方式设置：POST必须大写
		connection.setRequestMethod("POST");
		// 3.2 设置数据格式：content-type
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		// 3.3设置输入输出，因为默认新创建的connection没有读写权限
		connection.setDoOutput(true);
		connection.setDoInput(true);
		// 4. 组织SOAP数据，发送请求
		String aopxml = getXML("15168381503"); 
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(aopxml.getBytes());
		// 5.接收服务端响应，打印
		if(connection.getResponseCode()==200){
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(isr);
			
			/*String readLine = bReader.readLine();
			System.out.println(readLine);*/
			
			//读取数据，StringBuilder是非线程安全的，速度比StringBuffer快
			StringBuilder sb = new StringBuilder();
			String temp = null;
			while (null !=(temp = bReader.readLine())) {
				sb.append(temp);
			}
			
			//使用dom4j解析xml文件，取出需要的数据
			Document document = DocumentHelper.parseText(sb.toString());
			treeWalk(document);
			is.close();
			isr.close();
			bReader.close();
		}
	
	}
}
