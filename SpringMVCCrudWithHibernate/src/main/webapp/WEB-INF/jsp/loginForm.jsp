<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>

<!-- External Java Script : Configure  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/employeeportal.js"></script>

<!-- External CSS : Configure  -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employeeportal.css" />

</head>
<body>
<div class="login-form">
		<div id="loginErrMsg">
			<c:if test="${isValidCredential == false}">
				<h5 style="color: red;" align="center"><strong>Either UserName or
					password is incorrect!!</strong></h5>
				<br />
			</c:if>
		</div>
		<form action="loginCheck" method="post">
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input id="userName" onfocusin="hideErrorMsg();" name="userName" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input id="password" onfocusin="hideErrorMsg();" name="password" type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
                
    </form>
</div>
</body>
</html>                                		