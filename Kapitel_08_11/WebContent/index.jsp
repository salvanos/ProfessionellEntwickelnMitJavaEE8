<%@ include file="header.jspf" %>
<p>${message}</p>
<fmt:message key="signedin"/>: <c:out value="${customer.email}" default="-"/>
<%@ include file="footer.jspf" %>