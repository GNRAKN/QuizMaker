<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Klasik Soru Ekle</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- <script src="resources/js/bootstrap.min.js"></script> -->
</head>
<body>

	<div class="container">
		<h2>QuizMaker</h2>
		<p>Sınav oluşturun.</p>



		<form:form id="SinavForm" action="sinavOlustur" method="post"
			modelAttribute="sinav">
			
			<form:hidden path="sinav_id" value="${sinav.sinav_id}" />

			<div class="form-group">

				<form:label for="sinav_adi" path="sinav_adi">Sınav adı :</form:label>
				<form:input class="form-control" id="sinav_adi"
					path="sinav_adi"></form:input>
			</div>

			<div class="form-group">
				<form:label for="sinav_yeri" path="sinav_yeri">Sınav Yeri :</form:label>
				<form:input type="text" class="form-control" id="sinav_yeri"
					path="sinav_yeri" />
			</div>


			<div class="form-group">
				<form:label for="sinav_gozetmenAdi" path="sinav_gozetmenAdi">Gözetmen adı :</form:label>
				<form:input type="text" class="form-control" id="sinav_gozetmenAdi"
					path="sinav_gozetmenAdi" />
			</div>

			
			<div class="form-group">
				<form:label for="kategori" path="kategori">Kategori seçin :</form:label>
				<form:select class="form-control" id="kategori" name="kategori"
					path="kategori">
					<c:forEach items="${kategoriler}" var="kategori">
					<form:option value="${kategori.kategori_id}"><c:out value="${kategori.kategori_ad}"></c:out></form:option>
					
					</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Devam Et</button> 
			<a href="listeleKlasik" class="btn btn-warning btn-block" role="button">İptal</a>
		</form:form>





	</div>


</body>
</html>
