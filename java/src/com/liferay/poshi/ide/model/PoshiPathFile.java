package com.liferay.poshi.ide.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PoshiPathFile {

	public PoshiPathFile(File file) throws Exception {
		_initPoshiPaths(file);
		_initSimpleFileName(file);
	}

	private Element _getElementFromFile(File file) throws Exception {
		String content = FileUtils.readFileToString(file, "UTF-8");

		InputStream inputStream = new ByteArrayInputStream(
			content.getBytes("UTF-8"));

		SAXReader saxReader = new SAXReader();

		Document document = saxReader.read(inputStream);

		return document.getRootElement();
	}

	private String _getSimpleFileName(String fileName) throws Exception {
		int x = 0;

		if (fileName.contains("/")) {
			x = fileName.lastIndexOf("/") + 1;
		}
		else if (fileName.contains("\\")) {
			x = fileName.lastIndexOf("\\") + 1;
		}

		int y = fileName.lastIndexOf(".");

		return fileName.substring(x, y);
	}

	private void _initPoshiPaths(File file) throws Exception {
		Element element = _getElementFromFile(file);
		Element bodyElement = element.element("body");
		Element tableElement = bodyElement.element("table");
		Element tbodyElement = tableElement.element("tbody");
		List<Element> trElements = tbodyElement.elements("tr");

		String simpleFileName = _getSimpleFileName(file.toString());

		for (Element trElement : trElements) {
			_poshiPaths.add(new PoshiPath(simpleFileName, trElement));
		}
	}

	private void _initSimpleFileName(File file) throws Exception {
		_simpleFileName = _getSimpleFileName(file.toString());

		Element element = _getElementFromFile(file);

		Element headElement = element.element("head");
		Element titleElement = headElement.element("title");

		if (!_simpleFileName.equals(titleElement.getText())) {
			throw new Exception(
				"The 'title' must match '" + _simpleFileName + "'.");
		}

		Element bodyElement = element.element("body");
		Element tableElement = bodyElement.element("table");
		Element theadElement = tableElement.element("thead");
		Element trElement = theadElement.element("tr");
		Element tdElement = trElement.element("td");

		if (!_simpleFileName.equals(tdElement.getText())) {
			throw new Exception(
				"The 'thead' must match '" + _simpleFileName + "'.");
		}
	}

	private List<PoshiPath> _poshiPaths = new ArrayList<>();
	private String _simpleFileName;

}