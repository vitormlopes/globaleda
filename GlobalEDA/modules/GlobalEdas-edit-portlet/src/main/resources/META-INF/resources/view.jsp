<%@ include file="/init.jsp" %>

<%@page import="java.util.List"%>

<p>
	<b><liferay-ui:message key="globaledasedit.caption"/></b>
</p>

<liferay-ui:success key="candidateAdded" message="Thank you!"/>
<liferay-ui:error key="required-fields" message="Please fill in all the required fields."/>
<portlet:actionURL name="addCandidate" var="addCandidateURL"></portlet:actionURL>

<section>
	<div class="col-md-12" id="form-apply">
	
	
		<div class="col-md-10 col-md-offset-1 text-center padding">
			<h1 class="padding">Apply to join our team</h1>
		</div>
		
		<div class="row">
			<form action="<%=addCandidateURL%>" id="formglobaleda" enctype="multipart/form-data" method="post" name="fm" class="form-inline apply">
		
				<div class="col-md-12">
					<div class="col-md-6">
                                <label class="animateInput">
                                    <aui:input id="fname" name="fname"></aui:input>
                                </label>
                            </div>
				</div>

				<div class="col-md-12"> 
					<button type="submit" style="width:100%;" class="btn btn-default btn-fadein btn-apply">Submit</button>
				</div>
				
			</form>
			
		</div>
	</div>
</section>



