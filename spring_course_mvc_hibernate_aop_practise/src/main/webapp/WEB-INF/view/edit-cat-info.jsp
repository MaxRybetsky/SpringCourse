<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Category Info</h2>
        <br>
        <form:form action="saveCategory" modelAttribute="category">
            <form:hidden path="id" />
            Name: <form:input path="name" />
            <form:errors path="name" />
            <br><br>
            <input type="submit" value="OK" />
        </form:form>
    </body>
</html>