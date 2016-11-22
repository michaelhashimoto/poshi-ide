package com.liferay.poshi.ide;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException {

		ObjectDemo objectDemo = new ObjectDemo(
			request.getParameter("username"), request.getParameter("password"));

		request.setAttribute("objectDemo", objectDemo);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
			"/jsp/demo.jsp");

        requestDispatcher.forward(request, response);
	}
}