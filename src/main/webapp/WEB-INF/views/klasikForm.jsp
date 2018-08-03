<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Klasik Soru Ekle</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>QuizMaker</h2>
		<p>Soru bankasına "KLASİK" tipte soru ekleyin.</p>



		<form:form id="KlasikKayitForm" action="kaydetKlasik" method="post"
			modelAttribute="klasik">
			
			<form:hidden path="k_id" value="${klasik.k_id}" />

			<div class="form-group">

				<form:label for="k_soru" path="k_soru">Soru:</form:label>
				<form:textarea class="form-control" rows="3" id="k_soru"
					path="k_soru"></form:textarea>
			</div>

			<div class="form-group">
				<form:label for="k_dogru" path="k_dogru">Doğru Cevap:</form:label>
				<form:input type="text" class="form-control" id="k_dogru"
					path="k_dogru" />
			</div>


			<div class="form-group">
				<form:label for="k_puan" path="k_puan">Puan</form:label>
				<form:input type="text" class="form-control" id="k_puan"
					path="k_puan" />
			</div>

			<div class="form-group">
				<form:label for="k_zorluk" path="k_zorluk">Zorluk derecesini seçin :</form:label>
				<form:select class="form-control" id="k_zorluk" path="k_zorluk">
					<option>Kolay</option>
					<option>Orta</option>
					<option>Zor</option>
				</form:select>
			</div>

			<div class="form-group">
				<form:label for="kategori" path="kategori">Kategori seçin :</form:label>
				<form:select class="form-control" id="kategoriId" name="kategoriId"
					path="kategori">
					<c:forEach items="${kategoriler}" var="kategori">
						<form:option value="${kategori.kategori_id}">${kategori.kategori_ad}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Ekle</button>
			<a href="listeleKlasik" class="btn btn-warning btn-block" role="button">İptal</a>
		</form:form>





	</div>


</body>
</html>
