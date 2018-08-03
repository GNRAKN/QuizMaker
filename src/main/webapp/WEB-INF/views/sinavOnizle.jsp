<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Sınav Önizleme</title>
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

			<div class="panel-body">


				<c:if test="${empty sessionScope.sinav.klasikSorular}">
					<c:out value="Sınav için hiç soru eklemediniz !"></c:out>
				</c:if>
				<c:if test="${not empty sessionScope.sinav.klasikSorular}">

					<form:form id="sinavOnizle" action="sinavKaydet" method="post"
						modelAttribute="sinavAttribute">


						<div class="form-group">

							<label for="sinav_adi" >Sınav adı :</label>
							<form:input class="form-control" id="sinav_adi" path="sinav_adi" value="${sessionScope.sinav.sinav_adi}"></form:input>
						</div>

						<div class="form-group">
							<form:label for="sinav_yeri" path="sinav_yeri">Sınav Yeri :</form:label>
							<form:input type="text" class="form-control" id="sinav_yeri"
								path="sinav_yeri" value="${sessionScope.sinav.sinav_yeri}" />
						</div>


						<div class="form-group">
							<form:label for="sinav_gozetmenAdi" path="sinav_gozetmenAdi">Gözetmen adı :</form:label>
							<form:input type="text" class="form-control"
								id="sinav_gozetmenAdi" path="sinav_gozetmenAdi"
								value="${sessionScope.sinav.sinav_gozetmenAdi}" />
						</div>


						<div class="form-group">
							<label for="usr">Kategori:</label>
							<form:input type="text"
								value="${sessionScope.sinav.kategori.kategori_ad}"
								class="form-control" id="kategori"
								path="kategori" disabled="true"/>
						</div>

						<button type="submit" class="btn btn-primary btn-block">Kaydet</button>
						<a href="listeleKlasik" class="btn btn-warning btn-block"
							role="button">İptal</a>
					</form:form>




					<table class="table table-hover table-bordered">
						<thead style="background-color: #F2F5A9;">
							<tr>
								<th>Soru</th>
								<th>Cevap</th>
								<th>Zorluk</th>
								<th>Puan</th>
								<th>Sil</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.sinav.klasikSorular}" var="s">

								<tr>

									<th><c:out value="${s.value.k_soru}" /></th>
									<th><c:out value="${s.value.k_dogru}" /></th>
									<th><c:out value="${s.value.k_zorluk}" /></th>
									<th><c:out value="${s.value.k_puan}" /></th>

									<th><a href="soruKaldir?k_id=<c:out value="${s.key}"/>">Sil</a></th>


								</tr>
							</c:forEach>
						</tbody>
					</table>

				</c:if>
			</div>
		</div>
	</div>


</body>
</html>
