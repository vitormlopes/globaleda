<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="globaledaadmin.caption"/></b>
	
	<%@page import="java.util.List"%>
	<%@page import="Global.eda.sb.model.GlobalEda"%>

	<aui:fieldset label="GlobalEdas">
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-globaledas-to-show">
			<liferay-ui:search-container-results results="${globalEdas}"/>
		    <liferay-ui:search-container-row className="Global.eda.sb.model.GlobalEda" keyProperty="fooId" modelVar="globalEdas" escapedModel="<%= true %>">
		       	<liferay-ui:search-container-column-text name="Name" value="${globalEdas.field1}" align="center" />
		       	<liferay-ui:search-container-column-text name="email" value="${globalEdas.field2}" align="center" />
		       	<liferay-ui:search-container-column-text name="phone" value="${globalEdas.field2}" align="center"/>
		       	<liferay-ui:search-container-column-text name="position" value="${globalEdas.field2}" align="center"/>
		    </liferay-ui:search-container-row>
		    <liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:fieldset>
	
</p>