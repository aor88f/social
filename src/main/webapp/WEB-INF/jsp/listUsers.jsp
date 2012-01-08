<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Users</h1>

<ul>
  <c:forEach var="user" items="${users}">
    <li><a href="user?id=${user.id}">${user.fullName}[${user.email}]</a></li>
  </c:forEach>
</ul>