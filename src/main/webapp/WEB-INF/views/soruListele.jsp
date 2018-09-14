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
<script src="resources/js/siklariGoster.js"></script>


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
						<a href="yeniSoru">SoruEkle</a>

					</div>
				</h3>
			</div>
			<div class="panel-body">
				<form class="form-inline" action="listeleSoru" method="post">

					<c:if test="${empty sessionScope.sinav}">
						<div class="form-group">
							<select class="form-control" id="kategori.kategori_id"
								name="kategori.kategori_id">
								<option value="0">-- kategori seçiniz --</option>
								<c:forEach items="${kategoriler}" var="kategori">
									<option value="${kategori.kategori_id}">${kategori.kategori_ad}</option>
								</c:forEach>
							</select>
						</div>
					</c:if>


					<div class="form-group">
						<select class="form-control" id="zorluk" name="zorluk">
							<option value="">-- zorluk seçiniz --</option>

							<option value="Kolay">Kolay</option>
							<option value="Orta">Orta</option>
							<option value="Zor">Zor</option>

						</select>
					</div>

					<button type="submit" class="btn btn-default">Filtrele</button>
				</form>

				<c:if test="${not empty sessionScope.sinav}">
					<span class="badge">Eklenen soru sayısı :<c:out
							value="${soruSayisi}" /></span>


					<form action="otoSinavOlustur" class="form-inline" method="post">

						<div class="form-group">
							<select class="form-control" id="zorluk" name="zorluk">
								<option value="">-- zorluk seçiniz --</option>

								<option value="kolay">Kolay</option>
								<option value="orta">Orta</option>
								<option value="zor">Zor</option>

							</select>
						</div>

						<input type="text" class="form-control" id="tamPuan"
							name="tamPuan" />

						<button type="submit" class="btn btn-primary btn-block">Otomatik
							Sınav Oluştur</button>

					</form>

				</c:if>


				<c:if test="${empty sorular}">
					<c:out value="Kayıt yok"></c:out>
				</c:if>
				<c:if test="${not empty sorular}">




					<table class="table table-hover table-bordered">
						<thead style="background-color: #F2F5A9;">
							<tr>
								<th>Soru</th>
								<th>Cevap</th>
								<th>Zorluk</th>
								<th>Puan</th>
								<th>Kategori</th>
								<th>Tip</th>
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
							<c:forEach items="${sorular}" var="s">
								<tr>

									<th><c:out value="${s.soru_kok}" /></th>
									<th><c:out value="${s.soru_dogru}" /></th>
									<th><c:out value="${s.zorluk}" /></th>
									<th><c:out value="${s.soru_puan}" /></th>
									<th><c:out value="${s.kategori.kategori_ad}" /></th>
									<th><c:out value="${s.tip.tip_adi}" /> <c:if
											test="${s.tip.tip_id==2}"> - <button
												onclick="siklariGoster(${s.soru_id});">Şıkları
												Göster</button>
											<div style="display: none;" id="${s.soru_id}">A)${s.soru_A}
												, B)${s.soru_B} , C)${s.soru_C} , D)${s.soru_D} ,
												E)${s.soru_E}</div>
										</c:if></th>

									<c:if test="${empty sessionScope.sinav}">
										<th><a
											href="duzenleSoru?soru_id=<c:out value='${s.soru_id}'/>">Düzenle</a></th>
										<th><a
											href="silSoru?soru_id=<c:out value='${s.soru_id}'/>">Sil</a></th>
									</c:if>
									<c:if test="${not empty sessionScope.sinav}">
										<th><a
											href="soruEkle?soru_id=<c:out value='${s.soru_id}'/>">Sınava
												Ekle</a></th>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</c:if>
				<c:if test="${not empty sessionScope.sinav and not empty soruSayisi}">
						<th><a class="btn btn-info" href="sinavOnIzle">Devam Et</a></th>
					</c:if>


			</div>
		</div>
	</div>


</body>
</html>
