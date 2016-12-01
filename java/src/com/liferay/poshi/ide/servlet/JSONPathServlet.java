package com.liferay.poshi.ide.servlet;

import com.liferay.poshi.ide.model.PoshiPath;
import com.liferay.poshi.ide.model.PoshiPathUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSONPathServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		out.print("{mobile:12345}");
	}
}