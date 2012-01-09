<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Users</h1>

<table border=1 cellpadding=5>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>
        <a href="user?id=${user.id}">${user.fullName}[${user.email}]</a>
      </td>
      <td>
        <table>
          <tr>
            <td>
              <a href="requestForRecommendationToSessionUser?fromId=${user.id}">Request to you from ${user.fullName}</a>
            </td>
            <td>
              <a href="requestForRecommendationTo?toId=${user.id}">Request to ${user.fullName} from...</a>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </c:forEach>
</table>