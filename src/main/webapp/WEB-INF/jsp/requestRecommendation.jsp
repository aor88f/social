<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Request recommendation from...</h1>

<ul>
  <c:forEach var="user" items="${users}">
    <li>
      <a href="requestForRecommendation?fromId=${user.id}&toId=${toUser.id}&requesterId=${requesterUser.id}">
        ...${user.fullName}[${user.email}]
      </a>
    </li>
  </c:forEach>
</ul>