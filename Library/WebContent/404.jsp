<%@page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%=request.getAttribute("javax.servlet.error.status_code")%> <br>
 <%=request.getAttribute("javax.servlet.error.message")%> <br>
 <%=request.getAttribute("javax.servlet.error.exception_type")%> <br>
</body>
</html>