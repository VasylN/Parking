<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  Driver: Pc
  Date: 02.09.2017
  Time: 13:52
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
        <th>Carid</th>
        <th>Car Name</th>
        <th>Car Modele</th>
        <th>Time Arrival</th>
        <th>Time Departure</th>
        <th>Payment</th>
        <th>Number Parking</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.carid}"/></td>
            <td><c:out value="${car.carName}"/></td>
            <td><c:out value="${car.modeleCar}"/></td>
            <td><c:out value="${car.timeArrival}"/></td>
            <td><c:out value="${car.timeDeparture}"/></td>
            <td><c:out value="${car.payment}"/></td>
            <td><c:out value="${car.numberParking}"/></td>
            <td><a href="CarController?action=edit&carid=<c:out value="${car.carid}"/>">Update</a></td>
            <td>
                <a href="CarController?action=delete&carid=<c:out value="${car.carid}"/>&driverid=<c:out value="${car.driverid}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="CarController?action=insert">Add Car</a></p>
</body>
</html>
