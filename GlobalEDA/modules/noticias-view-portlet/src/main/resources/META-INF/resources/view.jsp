<%@ include file="/init.jsp" %>

<div class="container">
  	<div class="row">
		<c:forEach var="noticia" items="${noticias}">
			
			<div class="col-sm-4">
				<img style="width:40px; height:40px;" src="/documents/20123/34503/IMG_20190411_212144.jpg"></img>
				<h1>${noticia.titulo}</h1>
				<p>${noticia.descricao}</p>
			</div>
		</c:forEach >
	</div>
</div>


