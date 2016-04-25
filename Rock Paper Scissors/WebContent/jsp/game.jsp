<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Rock Paper Scissors</title>
</head>

<body>
<center>
	<form action="ServletController.do" method="POST">
	
		<div id="parentBox">
		
			<div id="input">
				<input type="radio" name="symbol" value="rock">Rock
  				<input type="radio" name="symbol" value="paper">Paper
  				<input type="radio" name="symbol" value="scissors">Scissors
  				<input type="submit" value="Play" id="button" >
			</div>
			<div id="symbol">
				<h3>You show:&nbsp${userSymbol}</h3>
				<h3>Cpu show:&nbsp${cpuSymbol}</h3>
			</div>
			<div id="round">
				<h3>Result</h3>
				<c:choose>
					<c:when test="${message eq 'Tie'}">
						<h3 style="color: brown">${message}</h3>
					</c:when>
					<c:when test="${message eq 'You Won'}">
						<h3 style="color: green">${message}</h3>
					</c:when>
					<c:when test="${message eq 'You Lose'}">
						<h3 style="color: red">${message}</h3>
					</c:when>
				</c:choose>
				
			</div>
			<div id="roundScore">
				<h2>Round Score</h2>
				<h3>You:&nbsp${userRoundScore}</h3>
				<h3>Cpu:&nbsp${cpuRoundScore}</h3>
			</div>
			<div id="gameScore">
				<h2>Game Score</h2>
				<h3>You:&nbsp${userGameScore}</h3>
				<h3>Cpu:&nbsp${cpuGameScore}</h3>
			</div>
			
		</div>
			
			
		
	</form>	
</center>
</body>
</html>