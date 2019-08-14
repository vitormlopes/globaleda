package noticias.admin.portlet.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import noticias.admin.portlet.constants.NoticiasAdminPortletKeys;
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
		"javax.portlet.display-name=NoticiasAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NoticiasAdminPortletKeys.NOTICIASADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NoticiasAdminPortlet extends MVCPortlet {
	
private static Log LOG = LogFactoryUtil.getLog(NoticiasAdminPortlet.class);
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException  {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<Noticia> noticias = NoticiaLocalServiceUtil.getNoticias(0, NoticiaLocalServiceUtil.getNoticiasCount());
		List<Noticia> subList = new ArrayList<Noticia>();
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		SearchContainer<Noticia> searchContainer = new SearchContainer<Noticia>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, iteratorURL, null, StringPool.BLANK);
		
		subList = ListUtil.subList(noticias, searchContainer.getStart(), searchContainer.getEnd());
		
		for (Noticia noticia : subList) {
			
			String fileUrl = "";
			
			try {
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(noticia.getDocumentId());
				DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "Noticias");
				
				fileUrl = "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dlFolder.getFolderId() + StringPool.SLASH + dlFileEntry.getFileName() +  StringPool.SLASH + dlFileEntry.getUuid();
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			noticia.setFileUrl(fileUrl);
			
		}
		
		renderRequest.setAttribute("scNoticia", searchContainer);
		renderRequest.setAttribute("noticias", subList);
		
		super.doView(renderRequest, renderResponse);
		
	}
	
}