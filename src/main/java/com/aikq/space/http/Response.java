package com.aikq.space.http;

import lombok.Data;

import java.io.OutputStream;

/**
 *  Http响应对象
 * @author aikq
 * @date 2019年01月31日 14:40
 */
@Data
public class Response {
	/**
	 * 响应头信息
	 */
	public static final String RESPONSE_HEADER ="HTTP/1.1 200 \r\n"
			+ "Content-Type: text/html\r\n"
			+ "\r\n";

	private OutputStream outputStream;
	private String write;

	public Response(OutputStream outputStream){
		this.outputStream = outputStream;
	}

}
