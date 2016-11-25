package com.liferay.poshi.ide;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.DirectoryScanner;

public class InitServlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("Initializing path files.");

		try {
			List<String> filePaths = _getFilePaths(
				"/opt/dev/projects/github/poshi-ide/test",
				new String[] { "**/*.path" });

			for(String filePath : filePaths) {
				File file = new File(filePath);

				if (file.exists()) {
					PoshiPathFile poshiPathFile = new PoshiPathFile(file);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();

			throw new ServletException(e);
		}
	}


	private static List<String> _getFilePaths(String basedir, String[] includes)
		throws IOException {

		List<String> filePaths = new ArrayList<>();

		DirectoryScanner directoryScanner = new DirectoryScanner();

		directoryScanner.setBasedir(basedir);
		directoryScanner.setIncludes(includes);

		directoryScanner.scan();

		for (String filePath : directoryScanner.getIncludedFiles()) {
			filePath = basedir + "/" + filePath;

			if (OSDetector.isWindows()) {
				filePath = filePath.replace("/", "\\");
			}

			filePaths.add(filePath);
		}

		return filePaths;
	}
}