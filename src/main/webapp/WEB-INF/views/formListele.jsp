<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
			<div class="panel-body">
				<form class="form-inline" action="listeleKlasik" method="post">
					
						<div class="form-group">
							<select class="form-control" id="kategori.kategori_id"
								name="kategori.kategori_id">
								<option value="0">-- kategori seçiniz --</option>
								<c:forEach items="${kategoriler}" var="kategori">
									<option value="${kategori.kategori_id}">${kategori.kategori_ad}</option>
								</c:forEach>
							</select>
						</div>
					
					
					<div class="form-group">
						<select class="form-control" id="k_zorluk" name="k_zorluk">
							<option value="">-- zorluk seçiniz --</option>

							<option value="kolay">Kolay</option>
							<option value="orta">Orta</option>
							<option value="zor">Zor</option>

						</select>
					</div>

					<button type="submit" class="btn btn-default">Filtrele</button>
				</form>

				<c:if test="${not empty sessionScope.sinav}">
					<span class="badge">Eklenen soru sayısı :<c:out
							value="${soruSayisi}" /></span>
				</c:if>


				<c:if test="${empty klasikSorular}">
					<c:out value="Kayıt yok"></c:out>
				</c:if>
				<c:if test="${not empty klasikSorular}">











					<table class="table table-hover table-bordered">
						<thead style="background-color: #F2F5A9;">
							<tr>
								<th>Id</th>
								<th>Soru</th>
								<th>Cevap</th>
								<th>Zorluk</th>
								<th>Puan</th>
								<th>Kategori Id</th>
								<c:if test="${empty sessionScope.sinav}">
									<th>Düzenle</th>
									<th>Sil</th>
								</c:if>
								<c:if test="${not empty sessionScope.sinav}">
									<th>Ekle</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${klasikSorular}" var="ks">
								<tr>
									<th><c:out value="${ks.k_id}" /></th>
									<th><c:out value="${ks.k_soru}" /></th>
									<th><c:out value="${ks.k_dogru}" /></th>
									<th><c:out value="${ks.k_zorluk}" /></th>
									<th><c:out value="${ks.k_puan}" /></th>
									<th><c:out value="${ks.kategori.kategori_ad}" /></th>


									<c:if test="${empty sessionScope.sinav}">
										<th><a href="editKlasik?k_id=<c:out value='${ks.k_id}'/>">Düzenle</a></th>
										<th><a
											href="deleteKlasik?k_id=<c:out value='${ks.k_id}'/>">Sil</a></th>
									</c:if>
									<c:if test="${not empty sessionScope.sinav}">
										<th><a href="soruEkle?k_id=<c:out value='${ks.k_id}'/>">Sınava
												Ekle</a></th>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${not empty sessionScope.sinav}">
						<th><a class="btn btn-info" href="sinavOnIzle">Devam Et</a></th>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>


</body>
</html>
