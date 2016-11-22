<%@ page import="com.liferay.poshi.ide.ObjectDemo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% ObjectDemo objectDemo = (ObjectDemo)request.getAttribute("objectDemo"); %>

<html>
	<p>Username: ${objectDemo.getUsername()}</p>
	<p>Password: ${objectDemo.getPassword()}</p>
</html>