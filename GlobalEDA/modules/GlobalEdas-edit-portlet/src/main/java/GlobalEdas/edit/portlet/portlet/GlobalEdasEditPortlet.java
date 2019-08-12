package GlobalEdas.edit.portlet.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import Global.eda.sb.model.GlobalEda;
import Global.eda.sb.service.GlobalEdaLocalServiceUtil;
import GlobalEdas.edit.portlet.constants.GlobalEdasEditPortletKeys;

/**
 * @author vitor
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=GlobalEDA",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GlobalEdasEdit",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GlobalEdasEditPortletKeys.GLOBALEDASEDIT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GlobalEdasEditPortlet extends MVCPortlet {
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException  {
			
		super.doView(renderRequest, renderResponse);
	}
	
	
	public void addCandidate(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		//long userId = themeDisplay.getUserId(); 
		//long groupId = themeDisplay.getScopeGroupId(); 
		//long repositoryId = themeDisplay.getScopeGroupId();
		
		//UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		//File uploadedFile = uploadRequest.getFile("fileupload");
		
		//DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "Candidates CV");
		//long fileEntryTypeId = dlFolder.getDefaultFileEntryTypeId();
		//ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
		
		try {
			
			/*
			InputStream is = new FileInputStream( uploadedFile );
			
			String mimeType = MimeTypesUtil.getContentType(uploadedFile);
			Date date = new Date();
			
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
						getAdminId(), 
						groupId, 
						repositoryId, 
						dlFolder.getFolderId(), 
						uploadedFile.getName(), 
						mimeType, 
						"CV_" + uploadRequest.getParameter("fname") + uploadRequest.getParameter("lname") + "_" + date.getTime(), 
						"", 
						"", 
						fileEntryTypeId, null, uploadedFile, is, uploadedFile.length(), serviceContext);
			
			//Change mode of Draft to Approved 
			DLFileEntryLocalServiceUtil.updateFileEntry(
						userId, 
						dlFileEntry.getFileEntryId(), 
						uploadedFile.getName(), 
						MimeTypesUtil.getContentType(uploadedFile), 
						"CV_" + uploadRequest.getParameter("fname") + uploadRequest.getParameter("lname") + "_" + date.getTime(), 
						"", 
						"Draft to save", 
						true, 
						dlFileEntry.getFileEntryTypeId(), 
						null, 
						uploadedFile,
						null, 
						uploadedFile.length(), 
						serviceContext);
			
			//DLFileEntryLocalServiceUtil.updateStatus(userId, fileVersionId, WorkflowConstants.STATUS_APPROVED, serviceContext, workflowContext)
			*/
			//LOG.info("Save Candidate");
			
			long globalEdaId=CounterLocalServiceUtil.increment(GlobalEda.class.getName());
			GlobalEda globalEda = GlobalEdaLocalServiceUtil.createGlobalEda(globalEdaId);
			
			String value = ParamUtil.getString(request, "fname");
			
			globalEda.setField1(value);
			globalEda.setField3(2);
		
			
			GlobalEdaLocalServiceUtil.addGlobalEda(globalEda);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		SessionMessages.add(request, "hideSuccessMessage");
	}
		
}