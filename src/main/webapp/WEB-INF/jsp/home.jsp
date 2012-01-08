<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Users</h1>

<h2>CV</h2>
<h3>${cv}</h3>

<ul>
  <c:forEach var="rec" items="${recommendations}">
    <h2>${rec.fromUserInfo.fullName}[${rec.fromUserInfo.email}]</h2>
    <h3>${rec.text}</h3>
  </c:forEach>
</ul>

<br>

<a href="/users/register">Register</a>