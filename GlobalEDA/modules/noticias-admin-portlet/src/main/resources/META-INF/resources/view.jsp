<%@ include file="/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="noticias.sb.model.Noticia"%>

<aui:fieldset label="Noticias">
	<liferay-ui:search-container delta="10" searchContainer="${scNoticia}" deltaConfigurable="true" emptyResultsMessage="no-news-to-show">
		<liferay-ui:search-container-results results="${noticias}"/>
	    <liferay-ui:search-container-row className="noticias.sb.model.Noticia" keyProperty="noticiaId" modelVar="noticia" escapedModel="<%= true %>">
	       	<liferay-ui:search-container-column-text name="Titulo" value="${noticia.titulo}" align="center" />
	       	<liferay-ui:search-container-column-text name="Descricao" value="${noticia.descricao}" align="center" />
	       	<liferay-ui:search-container-column-text name="Imagem" href="${noticia.fileUrl}" value="CV Download" align="center"/>
			<liferay-ui:search-container-column-jsp path="/viewActions.jsp" align="center"/>
	    </liferay-ui:search-container-row>
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:fieldset>
