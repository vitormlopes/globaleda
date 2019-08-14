<%@ include file="/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="noticias.sb.model.Noticia"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>


<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Noticia noticia = (Noticia) row.getObject();
	String url = "/edit-noticia?noticiaId=" + String.valueOf(noticia.getNoticiaId());
	
%>
   
<liferay-ui:icon image="view" message="View" url="<%=url%>"/>