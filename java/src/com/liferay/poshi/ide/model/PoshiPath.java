package com.liferay.poshi.ide.model;

import java.util.List;

import org.dom4j.Element;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PoshiPath {

	public PoshiPath(String fileName, Element element) throws Exception {
		List<Element> tdElements = element.elements("td");

		int size = tdElements.size();

		if (size != 3) {
			throw new Exception("Invalid size!");
		}

		_description = tdElements.get(2).getText();
		_fileName = fileName;
		_key = tdElements.get(0).getText();
		_locator = tdElements.get(1).getText();

		PoshiPathUtil.putPoshiPath(this);
	}

	public String getDescription() {
		return _description;
	}

	public String getFileName() {
		return _fileName;
	}

	public String getKey() {
		return _key;
	}

	public String getPathKey() {
		return _fileName + "#" + _key;
	}

	public String getLocator() {
		return _locator;
	}

	public String toJSONString() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("description", _description);
		jsonObject.put("fileName", _fileName);
		jsonObject.put("key", _key);
		jsonObject.put("locator", _locator);

		return jsonObject.toString();
	}

	private String _description;
	private String _fileName;
	private String _key;
	private String _locator;

}