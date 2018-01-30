package test;

import server.WeatherInterfaceImpl;
import server.WeatherInterfaceImplService;

public class WeatherClient {
	public static void main(String[] args) {
		// 1.创建服务视图
		// 作用：该视图通过wsdl.xml文件与服务端的实体类建立起练习
        WeatherInterfaceImplService weatherInterfaceImplService = 
               new WeatherInterfaceImplService();
        // 2.获取服务实现类
        WeatherInterfaceImpl weatherInterfaceImpl = weatherInterfaceImplService.getPort(WeatherInterfaceImpl.class);
        // 3.调用查询方法
		String result = weatherInterfaceImpl.queryWeather("杭州");
		System.out.println(result);
	}
}
