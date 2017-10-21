<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  Driver: Pc
  Date: 02.09.2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="CarController" name="formAddCar">
    Car ID : <input type="text" readonly="readonly" name="carid"
                    value="<c:out value="${car.carid}"/>"/> <br/>
    Name : <input type="text" name="carName"
                  value="<c:out value="${car.carName}"/>"/> <br/>
    Modele : <input type="text" name="modeleCar"
                    value="<c:out value="${car.modeleCar}"/>"/> <br/>
    Time Arrival : <input type="time" name="timeArrival"
                          value="<c:out value="${car.timeArrival}"/>"/> <br/>

    <input type="submit" value="Submit">
</form>
</body>
</html>
