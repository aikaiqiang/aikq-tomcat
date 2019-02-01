package com.aikq.space.servlet;

import com.aikq.space.http.Request;
import com.aikq.space.http.Response;

/**
 *  Servlet
 * @author aikq
 * @date 2019年01月31日 14:34
 */
public abstract class AbstractServlet {

	public abstract void doGet(Request request, Response response);

	public abstract void doPost(Request request, Response response);

}
