package globaleda.admin.portlet.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import Global.eda.sb.model.GlobalEda;
import Global.eda.sb.service.GlobalEdaLocalServiceUtil;
import globaleda.admin.portlet.constants.GlobaledaAdminPortletKeys;

/**
 * @author vitor
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=GlobalEDA",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GlobaledaAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GlobaledaAdminPortletKeys.GLOBALEDAADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GlobaledaAdminPortlet extends MVCPortlet {
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException  {
		
		//ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<GlobalEda> globalEdas = GlobalEdaLocalServiceUtil.getGlobalEdas(0, GlobalEdaLocalServiceUtil.getGlobalEdasCount());

		renderRequest.setAttribute("globalEdas", globalEdas);
		
		super.doView(renderRequest, renderResponse);
		
	}
	
}