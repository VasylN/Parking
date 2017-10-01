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
<form method="post" action="DriverController" name="formAddDriverCar">
    Driver ID : <input type="text" readonly="readonly" name="driverid"
                     value="<c:out value="${driver.driverid}"/>"/> <br/>
    First name : <input type="text" name="firstName"
                        value="<c:out value="${driver.firstName}"/>"/> <br/>
    Last name : <input type="text" name="lastName"
                       value="<c:out value="${driver.lastName}"/>"/> <br/>
    Tel : <input type="text" name="tel"
                 value="<c:out value="${driver.tel}"/>"/> <br/>
      <input type="submit" value="ok">
    <p><a href="DriverController?action=listDriver">Back</a></p>
</form>
</body>
</html>
