<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Please enter your details</h2>
        <br>
        <br>
        <form:form action="showDetails" modelAttribute="employee">
            Name: <form:input path="name" />
            <form:errors path="name" />
            <br><br>
            Surname: <form:input path="surname" />
            <form:errors path="surname" />
            <br><br>
            Salary: <form:input path="salary" />
            <form:errors path="salary" />
            <br><br>
            Phone Number: <form:input path="phoneNumber" />
            <form:errors path="phoneNumber" />
            <br><br>
            EMail: <form:input path="email" />
            <form:errors path="email" />
            <br><br>
            Department: <form:select path="department">
                <form:options items="${employee.departments}" />
            </form:select>
            <br><br>
            What a car do you want:<br>
                <form:radiobuttons path="carBrand" items="${employee.carBrands}" />
            <br><br>
            Which languages do you know:<br>
                <form:checkboxes path="languages" items="${employee.langs}" />
            <br><br>
            <input type="submit" value="OK" />
        </form:form>
    </body>
</html>