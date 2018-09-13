<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sınav Getir</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container myrow-container">
		<div class="panel panel-warning">

			<div class="panel-body">
				<h3><c:out value="${sinav.sinav_adi}"/></h3>
				<h6><c:out value="${sinav.sinav_gozetmenAdi}"/></h6>
				
				
				<table class="table table-hover table-bordered">
						
							
							<c:forEach items="${sinav.sorular.values()}" var="s">
							<c:set var="soruNo" value="${soruNo+1}"></c:set>
								<tr>
									<th>${soruNo}) <c:out value="${s.soru_kok}" />(${s.soru_puan} puan)</th>
									
								</tr>
								
<<<<<<< HEAD
								<c:if test="${s.tip.tip_id==2}">
								<tr>
									<th>A)<c:out value="${s.soru_A}" /></th>
									
								</tr>
								<tr>
									<th>B)<c:out value="${s.soru_B}" /></th>
									
								</tr>
								<tr>
									<th>C)<c:out value="${s.soru_C}" /></th>
									
								</tr>
								<tr>
									<th>D)<c:out value="${s.soru_D}" /></th>
									
								</tr>
								<tr>
									<th>E)<c:out value="${s.soru_E}" /></th>
									
								</tr>
								</c:if>
								
								<c:if test="${s.tip.tip_id==1 or s.tip.tip_id==3}">
								<tr>
									<th>Cevap:<c:out value="${s.soru_dogru}" /></th>
									
								</tr>
								
								</c:if>
=======
								<tr>
									<th>A)<c:out value="${s.soru_A}" /></th>
									
								</tr>
								<tr>
									<th>B)<c:out value="${s.soru_B}" /></th>
									
								</tr>
								<tr>
									<th>C)<c:out value="${s.soru_C}" /></th>
									
								</tr>
								<tr>
									<th>D)<c:out value="${s.soru_D}" /></th>
									
								</tr>
								<tr>
									<th>E)<c:out value="${s.soru_E}" /></th>
									
								</tr>
>>>>>>> refs/remotes/origin/master
							</c:forEach>
						
					</table>
					<a class="btn btn-primary btn-block" href="/pdfExport?sinav_id=<c:out value="${sinav.sinav_id}"/>">PDF</a>
					
			</div>
		</div>
	</div>

</body>
</html>