<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>${user.fullName}[${user.email}]</h1>

<h2>Form</h2>
<ul cellspacing=0>
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
</ul>

<h2>Recommendations</h2>

<ul>
  <a href=addRecommendation?id=${user.id}>Add recommendation</a>
</ul>

<ul>
  <c:forEach var="rec" items="${recommendations}">
    <table border=1 cellpadding=5 width=320>
      <tr>
        <td><a href="user?id=${rec.fromUserInfo.id}">${rec.fromUserInfo.fullName}[${rec.fromUserInfo.email}]</a></td>
      </tr>
      <tr>
        <td>${rec.text}</td>
      </tr>
    </table>
    <br>
  </c:forEach>
</ul>