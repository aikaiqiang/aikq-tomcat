package com.aikq.space.servlet;

import com.aikq.space.http.Request;
import com.aikq.space.http.Response;

/**
 *  Servlet实现类
 * @author aikq
 * @date 2019年01月31日 14:41
 */
public class HelloServlet extends AbstractServlet {
	@Override
	public void doGet(Request request, Response response) {
		response.setWrite("Hello，第一个Servlet");
	}

	@Override
	public void doPost(Request request, Response response) {
		this.doGet(request, response);
	}
}
