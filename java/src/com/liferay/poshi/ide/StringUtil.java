package com.liferay.poshi.ide;

import org.apache.commons.lang.StringUtils;

/**
 * The String utility class.
 *
 * @author Brian Wing Shun Chan
 * @author Sandeep Soni
 * @author Ganesh Ram
 * @author Shuyang Zhou
 * @author Hugo Huijser
 * @author Michael Hashimoto
 */
public class StringUtil {

	public static String toLowerCase(String s) {
		if (s == null) {
			return null;
		}

		return StringUtils.lowerCase(s);
	}

	public static String toUpperCase(String s) {
		if (s == null) {
			return null;
		}

		return StringUtils.upperCase(s);
	}

	public static String trim(String s) {
		if (s == null) {
			return null;
		}

		if (s.length() == 0) {
			return s;
		}

		int len = s.length();

		int x = len;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			if (!Character.isWhitespace(c)) {
				x = i;

				break;
			}
		}

		if (x == len) {
			return StringPool.BLANK;
		}

		int y = x + 1;

		for (int i = len - 1; i > x; i--) {
			char c = s.charAt(i);

			if (!Character.isWhitespace(c)) {
				y = i + 1;

				break;
			}
		}

		if ((x == 0) && (y == len)) {
			return s;
		}

		return s.substring(x, y);
	}

}