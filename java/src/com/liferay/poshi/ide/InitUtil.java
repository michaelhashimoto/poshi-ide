package com.liferay.poshi.ide;

import com.liferay.poshi.ide.model.PoshiPathFile;
import com.liferay.poshi.ide.util.OSDetector;
import com.liferay.poshi.ide.util.PropsUtil;
import com.liferay.poshi.ide.util.PropsValues;

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

public class InitUtil extends HttpServlet {

	public void init() throws ServletException {
		PropsUtil.getProperties();

		System.out.println(
			"Reading poshi files from " + PropsValues.TEST_BASE_DIR_NAME);

		try {
			List<String> filePaths = _getFilePaths(
				PropsValues.TEST_BASE_DIR_NAME,
				new String[] { "**/*.function", "**/*.macro", "**/*.path" });

			for(String filePath : filePaths) {
				File file = new File(filePath);

				String fileName = file.toString();

				if (fileName.endsWith(".function")) {
				}
				else if (fileName.endsWith(".macro")) {
				}
				else if (fileName.endsWith(".path")) {
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