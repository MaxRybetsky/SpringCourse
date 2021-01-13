<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Page</title>
    </head>
    <body>
        <h3>Information for all Employees</h3>
        <security:authorize access="hasRole('HR')">
        <br>
        <br>
        <br>
        <input type="button" value="Salary"
            onclick="window.location.href='hr_info'" />
        <p>Only for HR</p><br><br>
        </security:authorize>
        <security:authorize access="hasRole('MANAGER')">
        <br>
        <br>
        <br>
        <input type="button" value="Performance"
                    onclick="window.location.href='manager_info'" />
        <p>Only for Managers</p><br><br>
        </security:authorize>
    </body>
</html>