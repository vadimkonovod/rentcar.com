<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.mainpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
    <%-------------%>
    <script type="text/javascript">
        $(function(){
            $('input[name="startDate"]').on( "change", function () {
                $(this).val();
                $('input[name="finishDate"]').attr({min:$(this).val()});
            })
            $('input[name="finishDate"]').on( "change", function () {
                $(this).val();
                $('input[name="startDate"]').attr({max:$(this).val()});
            })
        });
        function checkDate(){
            var start = document.getElementsByName("startDate")[0].value;
            var finish = document.getElementsByName("finishDate")[0].value;
            if(!start&&!finish){
                alert("<fmt:message bundle="${loc}" key="local.main.error.dates"/>");
                return false;
            } else if (!start) {
                alert("<fmt:message bundle="${loc}" key="local.main.error.pickupdate"/>");
                return false;
            } else if (!finish) {
                alert("<fmt:message bundle="${loc}" key="local.main.error.returndate"/>");
                return false; }
        }
    </script>

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <form class="col-xs-4 col-xs-offset-4" onsubmit="return checkDate()" action="${pageContext.request.contextPath}/serv?command=search_cars" method="post" >
            <h3><fmt:message bundle="${loc}" key="local.main.where"/></h3>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.main.location"/></label>
                <select name="locationCity" class="form-control">
                    <option value="all">All Cities</option>
                    <option value="Brest">Brest</option>
                    <option value="Vitebsk">Vitebsk</option>
                    <option value="Gomel">Gomel</option>
                    <option value="Grodno">Grodno</option>
                    <option value="Minsk">Minsk</option>
                    <option value="Mogilev">Mogilev</option>
                    <option value="Mozyr">Mozyr</option>
                    <option value="Lida">Lida</option>
                </select>
            </div>
            <h3><fmt:message bundle="${loc}" key="local.main.when"/></h3>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.main.pickupdate"/></label>
                <input type="date" name="startDate" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.main.returndate"/></label>
                <input type="date" name="finishDate" class="form-control">
            </div>
            <button type="submit" class="btn-success btn pull-right"><fmt:message bundle="${loc}" key="local.main.selectcar"/></button>
        </form>
    </div>
</div>
</body>
</html>
