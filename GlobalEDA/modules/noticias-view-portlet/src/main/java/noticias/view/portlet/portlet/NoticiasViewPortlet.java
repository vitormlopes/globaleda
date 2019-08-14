package noticias.view.portlet.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;

import noticias.sb.model.Noticia;
import noticias.sb.service.NoticiaLocalServiceUtil;
import noticias.view.portlet.constants.NoticiasViewPortletKeys;

/**
 * @author vitor
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Global EDA",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NoticiasView",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NoticiasViewPortletKeys.NOTICIASVIEW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NoticiasViewPortlet extends MVCPortlet {
	
public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException  {
		
		List<Noticia> noticias = NoticiaLocalServiceUtil.getNoticias(0, NoticiaLocalServiceUtil.getNoticiasCount());
		
		renderRequest.setAttribute("noticias", noticias);
		
		super.doView(renderRequest, renderResponse);
	
	}
	
}