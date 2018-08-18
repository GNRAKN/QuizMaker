<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Soru Ekle</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>QuizMaker</h2>
		<p>Soru bankasına soru ekleyin.</p>



		<form:form id="SoruKayitForm" action="kaydetSoru" method="post"
			modelAttribute="soru">

			<form:hidden path="soru_id" value="${soru.soru_id}" />

			<div class="form-group">

				<form:label for="soru_kok" path="soru_kok">Soru:</form:label>
				<form:textarea class="form-control" rows="3" id="soru_kok"
					path="soru_kok"></form:textarea>
			</div>

			<div>
				
				<div class="form-group">
					<form:label for="soru_A" path="soru_A">A :</form:label>
					<form:input type="text" class="form-control" id="soru_A"
						path="soru_A" />
				</div>
				<div class="form-group">
					<form:label for="soru_B" path="soru_B">B :</form:label>
					<form:input type="text" class="form-control" id="soru_B"
						path="soru_B" />
				</div>
				<div class="form-group">
					<form:label for="soru_C" path="soru_C">C :</form:label>
					<form:input type="text" class="form-control" id="soru_C"
						path="soru_C" />
				</div>
				<div class="form-group">
					<form:label for="soru_D" path="soru_D">D :</form:label>
					<form:input type="text" class="form-control" id="soru_D"
						path="soru_D" />
				</div>
			</div>
			<div class="form-group">
				<form:label for="soru_E" path="soru_E">E :</form:label>
				<form:input type="text" class="form-control" id="soru_E" path="soru_E" />
			</div>


			<div class="form-group">
				<form:label for="soru_dogru" path="soru_dogru">Doğru şık :</form:label>
				<form:select class="form-control" id="soru_dogru" path="soru_dogru">
					<option>A</option>
					<option>B</option>
					<option>C</option>
					<option>D</option>
					<option>E</option>
				</form:select>
			</div>
			
			<div class="form-group">
				<form:label for="soru_puan" path="soru_puan">Puan</form:label>
				<form:input type="text" class="form-control" id="soru_puan"
					path="soru_puan" />
			</div>

			<div class="form-group">
				<form:label for="zorluk" path="zorluk">Zorluk derecesini seçin :</form:label>
				<form:select class="form-control" id="zorluk" path="zorluk">
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
			<button type="submit" class="btn btn-primary btn-block">Kaydet</button>
			<a href="listeleSoru" class="btn btn-warning btn-block"
				role="button">İptal</a>
		</form:form>





	</div>


</body>
</html>
