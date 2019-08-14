package noticias.edit.portlet.portlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import noticias.edit.portlet.constants.NoticiasEditPortletKeys;
import noticias.sb.model.Noticia;
import noticias.sb.service.NoticiaLocalServiceUtil;

/**
 * @author vitor
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Global EDA",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NoticiasEdit",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NoticiasEditPortletKeys.NOTICIASEDIT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NoticiasEditPortlet extends MVCPortlet {
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException  {
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(renderRequest);
	    String noticiaId =  PortalUtil.getOriginalServletRequest(r).getParameter("noticiaId");
		
		if (noticiaId != null && !"".equals(noticiaId)) {
		
			long noticiaIdLong = Long.parseLong(noticiaId);
	
			try {
				renderRequest.setAttribute("noticia", NoticiaLocalServiceUtil.getNoticia(noticiaIdLong));
			} catch (PortalException e) {
				super.doView(renderRequest, renderResponse);
			}
		}
		
		super.doView(renderRequest, renderResponse);
	
	}
	
	public void addNoticia(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		long noticiaId=CounterLocalServiceUtil.increment(Noticia.class.getName());
		Noticia noticia = NoticiaLocalServiceUtil.createNoticia(noticiaId);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId(); 
		User user = UserLocalServiceUtil.getUser(userId);
		
		String titulo = ParamUtil.getString(request, "titulo");
		String descricao = ParamUtil.getString(request, "descricao");
		
		noticia.setTitulo(titulo);
		noticia.setDescricao(descricao);
		noticia.setUserId(userId);
		noticia.setCreateDate(new Date());
	
		NoticiaLocalServiceUtil.addNoticia(noticia);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(NoticiasEditPortlet.class.getName(), uploadRequest);
		
		this.uploadFileEntity(serviceContext, uploadRequest);
	}

	private void uploadFileEntity(ServiceContext serviceContext, UploadPortletRequest request) throws PortalException, SystemException {

	    String filename = "";
	    String description = "File description";

	    try{

	        // serviceContext.scopeGroupId is the groupId of a site
	        long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	        
	        Folder f = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "Noticias");
	        long folderId = f.getFolderId();
	        
	        File file = request.getFile("file-to-upload");
	        filename = request.getFileName("file-to-upload");
	        String mimeType =  MimeTypesUtil.getContentType(file);

	        FileEntry entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
	                repositoryId, folderId, filename, 
	                mimeType, filename, description, "", 
	                file, serviceContext
	        );  


	    }catch(PortalException e){
	        //_log.error("An exception occured uploading file: " + e.getMessage());
	        //throw e;
	    }catch(SystemException e ){
	        //_log.error("An exception occured uploading file: " + e.getMessage());
	        //throw e;
	    }
	}
	
}