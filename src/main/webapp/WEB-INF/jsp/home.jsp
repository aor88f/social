<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Home ${user}</h1>

<h2>Form</h2>
<table border=1 cellpadding=5>
  <tr>
    <td>From</td><td>asdf</td>
  </tr>
  <tr>
    <td>Education</td><td>asd</td>
  </tr>
  <tr>
    <td>Experience</td><td>asdf</td>
  </tr>
</table>
<tr>
  <td><a href="editform">Edit</a></td>
</tr>

<br>

<h2>Recommendations</h2>
<ul>
  <c:forEach var="rec" items="${recommendations}">
    <h3>${rec.fromUserInfo.fullName}[${rec.fromUserInfo.email}]</h3>
    <h4>${rec.text}</h4>
  </c:forEach>
</ul>