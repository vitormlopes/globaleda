/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package Global.eda.sb.service.impl;

import Global.eda.sb.model.GlobalEda;
import Global.eda.sb.service.GlobalEdaLocalServiceUtil;
import Global.eda.sb.service.base.GlobalEdaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the global eda local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>Global.eda.sb.service.GlobalEdaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalEdaLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=Global.eda.sb.model.GlobalEda",
	service = AopService.class
)
public class GlobalEdaLocalServiceImpl extends GlobalEdaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>Global.eda.sb.service.GlobalEdaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>Global.eda.sb.service.GlobalEdaLocalServiceUtil</code>.
	 */
	public void getFields() {
		
		System.out.print("getFields");
	}
	
}