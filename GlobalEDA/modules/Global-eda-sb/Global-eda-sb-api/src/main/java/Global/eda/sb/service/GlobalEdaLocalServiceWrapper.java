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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link GlobalEdaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GlobalEdaLocalService
 * @generated
 */
@ProviderType
public class GlobalEdaLocalServiceWrapper
	implements GlobalEdaLocalService, ServiceWrapper<GlobalEdaLocalService> {

	public GlobalEdaLocalServiceWrapper(
		GlobalEdaLocalService globalEdaLocalService) {

		_globalEdaLocalService = globalEdaLocalService;
	}

	/**
	 * Adds the global eda to the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was added
	 */
	@Override
	public Global.eda.sb.model.GlobalEda addGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return _globalEdaLocalService.addGlobalEda(globalEda);
	}

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	@Override
	public Global.eda.sb.model.GlobalEda createGlobalEda(long fooId) {
		return _globalEdaLocalService.createGlobalEda(fooId);
	}

	/**
	 * Deletes the global eda from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was removed
	 */
	@Override
	public Global.eda.sb.model.GlobalEda deleteGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return _globalEdaLocalService.deleteGlobalEda(globalEda);
	}

	/**
	 * Deletes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	@Override
	public Global.eda.sb.model.GlobalEda deleteGlobalEda(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalEdaLocalService.deleteGlobalEda(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalEdaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _globalEdaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _globalEdaLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _globalEdaLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _globalEdaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _globalEdaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _globalEdaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Global.eda.sb.model.GlobalEda fetchGlobalEda(long fooId) {
		return _globalEdaLocalService.fetchGlobalEda(fooId);
	}

	/**
	 * Returns the global eda matching the UUID and group.
	 *
	 * @param uuid the global eda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public Global.eda.sb.model.GlobalEda fetchGlobalEdaByUuidAndGroupId(
		String uuid, long groupId) {

		return _globalEdaLocalService.fetchGlobalEdaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _globalEdaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _globalEdaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public void getFields() {
		_globalEdaLocalService.getFields();
	}

	/**
	 * Returns the global eda with the primary key.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	@Override
	public Global.eda.sb.model.GlobalEda getGlobalEda(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalEdaLocalService.getGlobalEda(fooId);
	}

	/**
	 * Returns the global eda matching the UUID and group.
	 *
	 * @param uuid the global eda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching global eda
	 * @throws PortalException if a matching global eda could not be found
	 */
	@Override
	public Global.eda.sb.model.GlobalEda getGlobalEdaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalEdaLocalService.getGlobalEdaByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<Global.eda.sb.model.GlobalEda> getGlobalEdas(
		int start, int end) {

		return _globalEdaLocalService.getGlobalEdas(start, end);
	}

	/**
	 * Returns all the global edas matching the UUID and company.
	 *
	 * @param uuid the UUID of the global edas
	 * @param companyId the primary key of the company
	 * @return the matching global edas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<Global.eda.sb.model.GlobalEda>
		getGlobalEdasByUuidAndCompanyId(String uuid, long companyId) {

		return _globalEdaLocalService.getGlobalEdasByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<Global.eda.sb.model.GlobalEda>
		getGlobalEdasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Global.eda.sb.model.GlobalEda> orderByComparator) {

		return _globalEdaLocalService.getGlobalEdasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	@Override
	public int getGlobalEdasCount() {
		return _globalEdaLocalService.getGlobalEdasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _globalEdaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _globalEdaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalEdaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the global eda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was updated
	 */
	@Override
	public Global.eda.sb.model.GlobalEda updateGlobalEda(
		Global.eda.sb.model.GlobalEda globalEda) {

		return _globalEdaLocalService.updateGlobalEda(globalEda);
	}

	@Override
	public GlobalEdaLocalService getWrappedService() {
		return _globalEdaLocalService;
	}

	@Override
	public void setWrappedService(GlobalEdaLocalService globalEdaLocalService) {
		_globalEdaLocalService = globalEdaLocalService;
	}

	private GlobalEdaLocalService _globalEdaLocalService;

}