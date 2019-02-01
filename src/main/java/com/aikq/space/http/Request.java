package com.aikq.space.http;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *  http请求对象
 * @author aikq
 * @date 2019年01月31日 14:35
 */
@Data
public class Request {
	private String method;
	private String url;

		public Request(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String[] methodAndUrl = bufferedReader.readLine().split(" ");
		this.method = methodAndUrl[0];
		this.url = methodAndUrl[1];
		System.out.println("请求类型："+ method);
		System.out.println("请求路径："+ url);
	}


}
