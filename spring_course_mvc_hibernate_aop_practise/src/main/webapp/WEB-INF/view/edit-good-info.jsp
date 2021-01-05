<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Good Info</h2>
        <br>
        <form:form action="saveGood" modelAttribute="good">
            <form:hidden path="id" />
            Name: <form:input path="name" />
            <form:errors path="name" />
            <br><br>
            Quantity: <form:input path="quantity" />
            <form:errors path="quantity" />
            <br><br>
            <form:radiobuttons path="category" items="${categories}" />
            <form:errors path="category" />
            <br><br>
            <input type="submit" value="OK" />
        </form:form>
    </body>
</html>