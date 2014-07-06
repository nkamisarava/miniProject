<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:insertAttribute name="title"></s:insertAttribute></title>
</head>
<body>
<header><s:insertAttribute name="header"></s:insertAttribute></header>
<div>
    <div><s:insertAttribute name="navigation"></s:insertAttribute></div>
    <div><s:insertAttribute name="content"></s:insertAttribute></div>
</div>
<footer><s:insertAttribute name="footer"></s:insertAttribute></footer>
</body>

</html>