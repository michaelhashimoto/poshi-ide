package com.liferay.poshi.ide.util;

import java.io.InputStream;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class PropsUtil {

	public static String get(String key) {
		return _instance._get(key);
	}

	public static Properties getProperties() {
		return _instance._props;
	}

	public static void set(String key, String value) {
		_instance._set(key, value);
	}

	private PropsUtil() {
		try {
			String[] propertiesFileNames = {
				"poshi-ide.properties", "poshi-ide-ext.properties"
			};

			for (String propertiesFileName : propertiesFileNames) {
				Class<?> clazz = getClass();

				ClassLoader classLoader = clazz.getClassLoader();

				InputStream inputStream = classLoader.getResourceAsStream(
					propertiesFileName);

				if (inputStream != null) {
					_props.load(inputStream);
				}
			}

			_printProperties(false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String _get(String key) {
		String value = System.getProperty(key);

		if (Validator.isNull(value)) {
			value = _props.getProperty(key);
		}

		return value;
	}

	private void _printProperties(boolean update) {
		List<String> keys = Collections.list(
			(Enumeration<String>)_props.propertyNames());

		keys = ListUtil.sort(keys);

		if (update) {
			System.out.println("-- updated properties --");
		}
		else {
			System.out.println("-- listing properties --");
		}

		for (String key : keys) {
			System.out.println(key + "=" + _get(key));
		}

		System.out.println("");
	}

	private void _set(String key, String value) {
		_props.setProperty(key, value);
	}

	private static final PropsUtil _instance = new PropsUtil();

	private final Properties _props = new Properties();

}