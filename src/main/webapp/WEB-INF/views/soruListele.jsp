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

	<div class="container">
		<div class="panel panel-default">
			<div class="panel panel-heading  col-md-12">
				<div class="col-md-12">
					<h2 style="float: left;">Soru Bankası</h2>
					<h2>
						<a style="float: right;" class="btn btn-info" href="yeniSoru">Soru
							Ekle</a>
					</h2>
				</div>


			</div>

		</div>


		<div class="panel-body">

			<div>


				<form action="listeleSoru" method="post">

					<c:if test="${empty sessionScope.sinav}">

						<select class="btn btn-primary dropdown-toggle"
							id="kategori.kategori_id" name="kategori.kategori_id">
							<option value="0">-- kategori seçiniz --</option>
							<c:forEach items="${kategoriler}" var="kategori">
								<option value="${kategori.kategori_id}">${kategori.kategori_ad}</option>
							</c:forEach>
						</select>

					</c:if>



					<!-- <div class="form-group">
						<select class="form-control" id="tip" name="tip.tip_id">
							<option value="">-- tip seçiniz --</option>

							<option value="klasik">Klasik</option>
							<option value="dogruyanlis">Doğru-Yanlış</option>
							<option value="coktansecmeli">Çoktan Seçmeli</option>

						</select>
					</div> -->


					<select class="btn btn-primary dropdown-toggle" id="zorluk"
						name="zorluk">
						<option value="">-- zorluk seçiniz --</option>

						<option value="Kolay">Kolay</option>
						<option value="Orta">Orta</option>
						<option value="Zor">Zor</option>

					</select>


					<button type="submit" class="btn btn-default">Filtrele</button>
				</form>


			</div>

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

					<input type="text" class="form-control" id="tamPuan" name="tamPuan" />

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
						<c:forEach items="${sorular}" var="s" varStatus="e">
							<tr>

								<td><c:out value="${s.soru_kok}" /> <c:if
										test="${s.tip.tip_id==2}"> - <u><a
											class="btn btn-info btn-xs" data-toggle="modal"
											data-target="#myModal${e.index}">Şıkları Göster</a></u>
									</c:if></td>
								<td><c:out value="${s.soru_dogru}" /></td>
								<td><c:out value="${s.zorluk}" /></td>
								<td><c:out value="${s.soru_puan}" /></td>
								<td><c:out value="${s.kategori.kategori_ad}" /></td>
								<td><c:out value="${s.tip.tip_adi}" /></td>
								<c:if test="${empty sessionScope.sinav}">
									<td><a class="btn btn-success btn-xs"
										href="duzenleSoru?soru_id=<c:out value='${s.soru_id}'/>">Düzenle</a></td>
									<td><a class="btn btn-danger btn-xs"
										href="silSoru?soru_id=<c:out value='${s.soru_id}'/>">Sil</a></td>
								</c:if>
								<c:if test="${not empty sessionScope.sinav}">
									<td><a
										href="soruEkle?soru_id=<c:out value='${s.soru_id}'/>">Sınava
											Ekle</a></td>
								</c:if>


								<c:if test="${s.tip.tip_id==2}">

									<div class="modal" id="myModal${e.index}" role="dialog">
										<div class="modal-dialog">


											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title">${i.urun.urun_adi}</h4>
												</div>
												<div class="modal-body">

													<p>Soru : : ${s.soru_kok}</p>
													<hr>
													<p>A)${s.soru_A}</p>
													<p>B)${s.soru_B}</p>
													<p>C)${s.soru_C}</p>
													<p>D)${s.soru_D}</p>
													<p>E)${s.soru_E}</p>





												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Kapat</button>

												</div>
											</div>

										</div>
									</div>
								</c:if>
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
