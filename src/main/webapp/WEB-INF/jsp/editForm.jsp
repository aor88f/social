<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${navigation}

<h1>Form</h1>


<form:form action="editForm" method="POST" modelAttribute="userForm">
  <table>
  <tr>
    <td><label for="from">From:</label></td><td><form:input path="from" id="from" value="${userForm.from}"/></td>
  </tr>
  <tr>
    <td><label for="education">Education:</label></td><td><form:input path="education" id="education" value="${userForm.education}"/></td>
  </tr>
  <tr>
    <td><label for="experience">Experience:</label></td><td><form:input path="experience" id="experience" value="${userForm.experience}"/></td>
  </tr>
  <tr>
    <td/><td><input type="submit" value="Edit"/></td>
  </tr>
  </table>
</form:form>