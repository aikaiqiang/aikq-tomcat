package com.aikq.space;

import com.aikq.space.tomcat.Tomcat;

/**
 *  测试类
 * @author aikq
 * @date 2019年01月31日 14:32
 */
public class Test {

	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.start();
	}
}
