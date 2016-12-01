package com.liferay.poshi.ide.servlet;

import com.liferay.poshi.ide.model.PoshiPath;
import com.liferay.poshi.ide.model.PoshiPathUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxPathServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException {

		StringBuilder sb = new StringBuilder();

		BufferedReader reader = request.getReader();

		try {
			String line;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} finally {
			reader.close();
		}

		try {
			PoshiPath poshiPath = PoshiPathUtil.getPoshiPath(sb.toString());

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			out.print(poshiPath.toJSONString());
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
}