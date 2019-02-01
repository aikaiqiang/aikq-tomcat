package com.aikq.space.tomcat;

import com.aikq.space.utils.XmlUtils;
import org.dom4j.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

/**
 *  E
 * @author aikq
 * @date 2019年01月31日 14:44
 */
public class Tomcat {
	private static final int PORT = 8080;

	public static final HashMap<String, Object> SERVLET_MAPPING = new HashMap<>();

	public static final HashMap<String, Object> SERVLET = new HashMap<>();

	/**
	 * 控制服务器启动关闭
	 */
	public boolean tomcatStarBool = true;

	private void init() {
		InputStream io = null;
		try {
			System.out.println("加载配置文件开始");
			//读取配置文件
			XmlUtils xml = new XmlUtils(XmlUtils.class.getResource("/")+"web.xml");
			//将所有的类都存储到容器中
			List<Element> list = xml.getNodes("servlet");
			for (Element element : list) {
				SERVLET.put(element.element("servlet-name").getText(),
						Class.forName(element.element("servlet-class").getText()).newInstance());
			}
			//映射关系创建
			List<Element> list2 = xml.getNodes("servlet-mapping");
			for (Element element : list2) {
				SERVLET_MAPPING.put(element.element("url-pattern").getText(),
						element.element("servlet-name").getText());
			}
			System.out.println("SERVLET_MAPPING = " + SERVLET_MAPPING);
			System.out.println("加载配置文件结束");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (io != null) {
				try {
					io.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Tomcat 服务已启动，地址：localhost ,端口：" + PORT);
			this.init();
			// 持续监听
			do {
				Socket socket = serverSocket.accept();
				// 处理任务
				Thread thread = new SocketProcess(socket);
				thread.start();
			} while (tomcatStarBool);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
