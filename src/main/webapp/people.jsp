<%@ page import="net.sni.servletbasic.model.Response" %>
<%@ page import="net.sni.servletbasic.model.Person" %>
<%@ page import="java.lang.reflect.Field" %><%--
  Created by IntelliJ IDEA.
  User: egurkan
  Date: 29/07/2022
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>People</title>
</head>
<body>
    <% if (request.getAttribute("response") != null) {
        Response<Person> resp = (Response<Person>) request.getAttribute("response"); %>
    <table>
        <tr>
            <% for (Field field : Person.class.getDeclaredFields()) { %>
                <th><%= field.getName() %></th>
            <% } %>
        </tr>
        <% for (Person person : resp.getResults()) { %>
            <%--TODO: You are here--%>
        <% } %>
    </table>
</body>
</html>
