package com.liferay.poshi.ide.servlet;

import com.liferay.poshi.ide.model.PoshiPath;
import com.liferay.poshi.ide.model.PoshiPathUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException {

		try {
			PoshiPath poshiPath = PoshiPathUtil.getPoshiPath(
				request.getParameter("pathKey"));

			request.setAttribute("poshiPath", poshiPath);
		}
		catch (Exception e) {
			e.printStackTrace();

			throw new ServletException(e);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
			"/jsp/path.jsp");

        requestDispatcher.forward(request, response);
	}
}