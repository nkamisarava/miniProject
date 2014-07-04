<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<spring:form accept-charset="UTF-8" method="post" modelAttribute="user" action="/addUser">
    <label for="firstName">Введите имя</label> <spring:input path="firstName" type="text" id="firstName" /> <br>
    <label for="lastName">Введите фамилию</label> <spring:input path="lastName" type="text" id="lastName" /> <br>
    <label for="phoneNumber">Введите телефон</label> <spring:input path="phoneNumber" type="text" id="phoneNumber" /> <br>
    <label for="login">Введите логин</label> <spring:input path="login" type="text" id="login" /> <br>
    <label for="email">Введите email</label> <spring:input path="email" type="text" id="email" /> <br>
    <label for="password">Введите password</label> <spring:input path="password" type="password" id="password" /> <br>

    <input type="submit" value="Save">


</spring:form>
