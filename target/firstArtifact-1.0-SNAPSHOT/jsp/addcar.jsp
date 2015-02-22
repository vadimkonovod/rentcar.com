<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.addcarpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
    <script type="text/javascript">
        function check(){
            var year = document.getElementsByName("year")[0].value;
            if(!document.getElementsByName("brand")[0].value){
                document.getElementsByName("brand")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.cars.error.brand"/>");
                return false;
            } else if (!document.getElementsByName("model")[0].value) {
                document.getElementsByName("model")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.cars.error.model"/>");
                return false;
            } else if (!year || isNaN(year)) {
                document.getElementsByName("year")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.cars.error.year"/>");
                return false;
            } else if (!document.getElementsByName("city")[0].value) {
                document.getElementsByName("city")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.cars.error.city"/>");
                return false;
            }
        }
    </script>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <form class="col-xs-4 col-xs-offset-4" onsubmit="return check()" action="${pageContext.request.contextPath}/serv?command=add_car" method="post" >
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.cars.brand"/></label>
                <input type="text" name="brand" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.cars.model"/></label>
                <input type="text" name="model" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.cars.year"/></label>
                <input type="text" name="year" class="form-control">
            </div>
            <c:if test="${not empty yearNotValidMessage}">
                <div class="form-group">
                    <a style="color: red;">${yearNotValidMessage}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.cars.city"/></label>
                <input type="text" name="city" class="form-control">
            </div>
            <button type="submit" class="btn-success btn pull-right"><fmt:message bundle="${loc}" key="local.cars.addcarbtn"/></button>
        </form>
    </div>
</div>
</body>
</html>
