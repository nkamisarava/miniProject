<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">


        <div class="jumbotron" style="margin-top: 20px;">

         <sec:authorize access="!isAuthenticated()">
                <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username" /></p>
                <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>

            </sec:authorize>
        </div>
       <div><a href="/registration">Register</a></div>
</div>
