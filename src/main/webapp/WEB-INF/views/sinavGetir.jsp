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
						
							
							<c:forEach items="${sinav.klasikSorular.values()}" var="ks">
								<tr>
									<th>(${ks.k_puan} puan)<c:out value="${ks.k_soru}" /></th>
																			
							
									
								</tr>
							</c:forEach>
						
					</table>
					
					
			</div>
		</div>
	</div>

</body>
</html>