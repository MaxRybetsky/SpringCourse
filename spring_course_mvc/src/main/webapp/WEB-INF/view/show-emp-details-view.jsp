<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Employee's Info</h2>
        <br>
        <br>
        <p>
            Name: ${employee.name}
            <br><br>
            Surname: ${employee.surname}
            <br><br>
            Salary: ${employee.salary}
            <br><br>
            Phone: ${employee.phoneNumber}
            <br><br>
            Email: ${employee.email}
            <br><br>
            Department: ${employee.department}
            <br><br>
            Your car: ${employee.carBrand}
            <br><br>
            Languages:
            <ul>
                <c:forEach var="lang" items="${employee.languages}">
                    <li>${lang}</li>
                </c:forEach>
            </ul>
        </p>
    </body>
</html>