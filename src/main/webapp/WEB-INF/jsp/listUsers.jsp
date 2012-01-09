<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Users</h1>


<table border=1>
<tr>
<td>
</td>
<td>
<table border=0 cellspacing=5>
<tr><td>Request recommendation</tr></tr>
</table>
</td>
</tr>
<tr>
<td>
<table border=1 cellpadding=2>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>
        <a href="user?id=${user.id}">${user.fullName}[${user.email}]</a>
      </td>
      <td>
        <table border=0 cellspacing=5>
          <tr>
            <td>
              <a href="requestForRecommendationToSessionUser?fromId=${user.id}">to you from ${user.fullName}</a>
            </td>
            <td>
              <a href="requestForRecommendationTo?toId=${user.id}">to ${user.fullName} from...</a>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </c:forEach>
</table>
</td>
</tr>