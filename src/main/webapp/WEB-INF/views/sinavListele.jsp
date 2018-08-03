<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>SoruBankası</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>Soru Listele</b>
					</div>
					<div align="right">
						<a href="yeniKlasik">SoruEkle</a>

					</div>
				</h3>
			</div>
		

				


				<c:if test="${empty sinavlar}">
					<c:out value="Kayıt yok"></c:out>
				</c:if>
				<c:if test="${not empty sinavlar}">


					<table class="table table-hover table-bordered">
						<thead style="background-color: #F2F5A9;">
							<tr>
								<th>Id</th>
								<th>Sınav Adı</th>
								<th>Kategori</th>
								<th>Sınav Yeri</th>
								<th>Gözetmen Adı</th>
								<th>Soru Sayısı</th> 
								<th>Düzenle</th>
								<th>Sil</th>
								<th>Göster</th>
							
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sinavlar}" var="s">
								<tr>
									<th><c:out value="${s.sinav_id}" /></th>
									<th><c:out value="${s.sinav_adi}" /></th>
									<th><c:out value="${s.kategori.kategori_ad}" /></th>
									<th><c:out value="${s.sinav_yeri}" /></th>
									<th><c:out value="${s.sinav_gozetmenAdi}" /></th>
									<th><c:out value="${fn:length(s.klasikSorular)}" /></th>
										
									
									
										<th><a href="editSinav?sinav_id=<c:out value='${s.sinav_id}'/>">Düzenle</a></th>
										<th><a
											href="deleteSinav?sinav_id=<c:out value='${s.sinav_id}'/>">Sil</a></th>
									
									
										<th><a href="sinavGetir?sinav_id=<c:out value='${s.sinav_id}'/>">Göster</a></th>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</c:if>
			</div>
		</div>
	


</body>
</html>
