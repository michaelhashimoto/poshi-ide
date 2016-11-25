package com.liferay.poshi.ide;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import java.util.List;

import org.apache.commons.io.FileUtils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PoshiPathFile {

	public PoshiPathFile(File file) throws Exception {
		String content = FileUtils.readFileToString(file, "UTF-8");
		InputStream inputStream = new ByteArrayInputStream(
			content.getBytes("UTF-8"));
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputStream);
		Element rootElement = document.getRootElement();

		Element headElement = rootElement.element("head");
		Element titleElement = headElement.element("title");
		String fileName = titleElement.getText();

		Element bodyElement = rootElement.element("body");
		Element tableElement = bodyElement.element("table");
		Element tbodyElement = tableElement.element("tbody");
		List<Element> trElements = tbodyElement.elements("tr");

		for (Element trElement : trElements) {
			PoshiPath poshiPath = new PoshiPath(fileName, trElement);
		}
	}

}