package com.shop.utils.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
	/**
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	/**
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			if(response!=null) {
				response.getWriter().write(text);
				response.getWriter().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Title: outputJson
	 */
	public static void outputJson(HttpServletResponse response, Object obj) {
		String s = JsonWriter.toJson(obj, false);
		response.setContentType("text/plain;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
