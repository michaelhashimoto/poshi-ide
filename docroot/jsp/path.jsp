<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.poshi.ide.model.PoshiPath" %>

<% PoshiPath poshiPath = (PoshiPath)request.getAttribute("poshiPath"); %>

<html>
	<p><b>Path Key:</b> ${poshiPath.getFileName()}#${poshiPath.getKey()}</p>
	<p><b>Locator:</b> ${poshiPath.getLocator()}</p>
	<p><b>Description:</b> ${poshiPath.getDescription()}</p>
</html>