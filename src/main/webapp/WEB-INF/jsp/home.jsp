<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Home [${user}]</h1>

<h2>CV</h2>
<h3>${cv}</h3>

<br>

<h2>Recommendations</h2>
<ul>
  <c:forEach var="rec" items="${recommendations}">
    <h3>${rec.fromUserInfo.fullName}[${rec.fromUserInfo.email}]</h3>
    <h4>${rec.text}</h4>
  </c:forEach>
</ul>