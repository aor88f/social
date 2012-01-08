<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>${user.fullName}[${user.email}]</h1>

<h2>Form</h2>
<table border=1 cellpadding=5>
  <tr>
    <td>From</td><td>${userForm.from}</td>
  </tr>
  <tr>
    <td>Education</td><td>${userForm.education}</td>
  </tr>
  <tr>
    <td>Experience</td><td>${userForm.experience}</td>
  </tr>
</table>

<br>

<a href=addRecommendation?id=${user.id}>Add recommendation</a>

<br>

<h2>Recommendations</h2>
<ul>
  <c:forEach var="rec" items="${recommendations}">
    <h3>${rec.fromUserInfo.fullName}[${rec.fromUserInfo.email}]</h3>
    <h4>${rec.text}</h4>
  </c:forEach>
</ul>