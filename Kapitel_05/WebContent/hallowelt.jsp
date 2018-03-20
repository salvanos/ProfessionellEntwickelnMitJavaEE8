<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib 
    prefix="fmt" 
    uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <body>
        <fmt:setBundle basename="messages"/>
        <fmt:message key="hello.world"/>
    </body>
</html>