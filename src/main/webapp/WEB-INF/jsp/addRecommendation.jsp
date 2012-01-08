<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Recommendation to ${user.fullName}[${user.email}]</h1>


<form:form action="addRecommendation" method="POST" modelAttribute="recommendationForm">
  <table>
  <tr>
    <td><label for="text">Text:</label></td><td><form:input path="text" id="text" value="${recommendationForm.text}"/></td>
  </tr>
    <td/><td><input type="submit" value="Submit"/></td>
  </tr>
  </table>
</form:form>