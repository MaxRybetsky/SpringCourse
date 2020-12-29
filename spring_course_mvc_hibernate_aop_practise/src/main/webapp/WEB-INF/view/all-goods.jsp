<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Shop data</h2>
        <br>
        <c:forEach var="entry" items="${allGoods}">
        <h4>${entry.key.name}</h4>
        <br>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Operations</th>
            </tr>
            <c:forEach var="good" items="${entry.value}">
                <c:url var="updateButton" value="/updateInfo">
                    <c:param name="goodId" value="${good.id}"/>
                </c:url>
                <c:url var="deleteButton" value="/deleteEmployee">
                    <c:param name="goodId" value="${good.id}"/>
                </c:url>
                <tr>
                    <td>${good.name}</td>
                    <td>${good.quantity}</td>
                    <td>
                        <input type="button" value="Update"
                        onclick="window.location.href='${updateButton}'"/>
                        <input type="button" value="Delete"
                        onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        </c:forEach>
        <br>
        <input type="button" value="Add"
                onclick="window.location.href='addNewEmployee'"/>
    </body>
</html>