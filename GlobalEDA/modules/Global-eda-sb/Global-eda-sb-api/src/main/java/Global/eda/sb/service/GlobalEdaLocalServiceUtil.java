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

package Global.eda.sb.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GlobalEda. This utility wraps
 * <code>Global.eda.sb.service.impl.GlobalEdaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GlobalEdaLocalService
 * @generated
 */
@ProviderType
public class GlobalEdaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Global.eda.sb.service.impl.GlobalEdaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the global eda to the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was added
	 */
	public static Global.eda.sb.model.GlobalEda addGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return getService().addGlobalEda(globalEda);
	}

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	public static Global.eda.sb.model.GlobalEda createGlobalEda(long fooId) {
		return getService().createGlobalEda(fooId);
	}

	/**
	 * Deletes the global eda from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was removed
	 */
	public static Global.eda.sb.model.GlobalEda deleteGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return getService().deleteGlobalEda(globalEda);
	}

	/**
	 * Deletes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	public static Global.eda.sb.model.GlobalEda deleteGlobalEda(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGlobalEda(fooId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Global.eda.sb.model.impl.GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Global.eda.sb.model.impl.GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Global.eda.sb.model.GlobalEda fetchGlobalEda(long fooId) {
		return getService().fetchGlobalEda(fooId);
	}

	/**
	 * Returns the global eda matching the UUID and group.
	 *
	 * @param uuid the global eda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static Global.eda.sb.model.GlobalEda fetchGlobalEdaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchGlobalEdaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static void getFields() {
		getService().getFields();
	}

	/**
	 * Returns the global eda with the primary key.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	public static Global.eda.sb.model.GlobalEda getGlobalEda(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGlobalEda(fooId);
	}

	/**
	 * Returns the global eda matching the UUID and group.
	 *
	 * @param uuid the global eda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching global eda
	 * @throws PortalException if a matching global eda could not be found
	 */
	public static Global.eda.sb.model.GlobalEda getGlobalEdaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGlobalEdaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the global edas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Global.eda.sb.model.impl.GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @return the range of global edas
	 */
	public static java.util.List<Global.eda.sb.model.GlobalEda> getGlobalEdas(
		int start, int end) {

		return getService().getGlobalEdas(start, end);
	}

	/**
	 * Returns all the global edas matching the UUID and company.
	 *
	 * @param uuid the UUID of the global edas
	 * @param companyId the primary key of the company
	 * @return the matching global edas, or an empty list if no matches were found
	 */
	public static java.util.List<Global.eda.sb.model.GlobalEda>
		getGlobalEdasByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getGlobalEdasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of global edas matching the UUID and company.
	 *
	 * @param uuid the UUID of the global edas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching global edas, or an empty list if no matches were found
	 */
	public static java.util.List<Global.eda.sb.model.GlobalEda>
		getGlobalEdasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Global.eda.sb.model.GlobalEda> orderByComparator) {

		return getService().getGlobalEdasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	public static int getGlobalEdasCount() {
		return getService().getGlobalEdasCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the global eda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was updated
	 */
	public static Global.eda.sb.model.GlobalEda updateGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return getService().updateGlobalEda(globalEda);
	}

	public static GlobalEdaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GlobalEdaLocalService, GlobalEdaLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GlobalEdaLocalService.class);

		ServiceTracker<GlobalEdaLocalService, GlobalEdaLocalService>
			serviceTracker =
				new ServiceTracker
					<GlobalEdaLocalService, GlobalEdaLocalService>(
						bundle.getBundleContext(), GlobalEdaLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}