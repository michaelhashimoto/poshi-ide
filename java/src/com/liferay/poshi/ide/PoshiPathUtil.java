package com.liferay.poshi.ide;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;

public class PoshiPathUtil {

	public static PoshiPath getPoshiPath(String pathKey) throws Exception {
		if (!_poshiPaths.containsKey(pathKey)) {
			throw new Exception("Invalid path key " + pathKey + "!");
		}

		return _poshiPaths.get(pathKey);
	}

	public static void putPoshiPath(PoshiPath poshiPath) throws Exception {
		String pathKey = poshiPath.getPathKey();

		if (_poshiPaths.containsKey(pathKey)) {
			throw new Exception("Duplicate path key " + pathKey + "!");
		}

		_poshiPaths.put(pathKey, poshiPath);
	}

	private static Map<String, PoshiPath> _poshiPaths = new HashMap<>();

}