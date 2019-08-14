<%@ include file="/init.jsp" %>

<portlet:actionURL name="addNoticia" var="addNoticiaURL"></portlet:actionURL>

<aui:form name="visitorForm" id="fm" method="post" action="<%= addNoticiaURL %>">
	<aui:fieldset>
		
		<aui:input label="titulo" name="titulo" value="${noticia.titulo}" />
		<aui:input label="descricao" name="descricao" value="${noticia.descricao}" />
		<aui:input label="noticiaId" name="noticiaId" value="${noticia.noticiaId}" />
		<aui:input type="file" name="file-to-upload"/>
		
	</aui:fieldset>
	
	<aui:button-row>
		 <aui:button type="submit" value="save"/>
	</aui:button-row>
	
</aui:form>