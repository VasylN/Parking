<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  Driver: Pc
  Date: 02.09.2017
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table border=4>
                <thead>
                <tr>
                    <th>DriverId</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Tel</th>
                    <th colspan="4">Action</th>
                </tr>
                </thead>
            <tbody>
            <c:forEach items="${userscars}" var = "driver">
                <tr>
                    <td><c:out value="${driver.driverid}"/></td>
                    <td><c:out value="${driver.firstName}"/></td>
                    <td><c:out value="${driver.lastName}"/></td>
                    <td><c:out value="${driver.tel}"/></td>
                    <td><a href="DriverController?action=edit&driverid=<c:out value="${driver.driverid}"/>">Update</a></td>
                    <td><a href="DriverController?action=delete&driverid=<c:out value="${driver.driverid}"/>">Delete</a></td>
                    <td><a href="CarController?action=review&driverid=<c:out value="${driver.driverid}"/>">Review list of cars</a></td>
                    <td><a href="CarController?action=calculate&driverid=<c:out value="${driver.driverid}"/>">Parking price</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="DriverController?action=insert">Add Driver</a></p>
        </body>
</html>
