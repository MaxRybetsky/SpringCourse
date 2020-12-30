<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Shop data</h2>
        <br>
        <c:forEach var="entry" items="${allGoods}">
            <c:url var="updateCatButton" value="/updateCategoryInfo">
                <c:param name="catId" value="${entry.key.id}"/>
            </c:url>
            <h4>${entry.key.name}</h4>
            <input type="button" value="Update Info"
            onclick="window.location.href='${updateCatButton}'"/>
            <br>
            <br>
            <br>
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Operations</th>
                </tr>
                <c:forEach var="good" items="${entry.value}">
                    <c:url var="updateButton" value="/updateGoodInfo">
                        <c:param name="goodId" value="${good.id}"/>
                    </c:url>
                    <c:url var="deleteButton" value="/deleteGood">
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
        <input type="button" value="Add New Category"
                onclick="window.location.href='addNewCategory'"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" value="Add New Good"
                onclick="window.location.href='addNewGood'"/>
    </body>
</html>