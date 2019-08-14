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

package noticias.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link NoticiaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoticiaLocalService
 * @generated
 */
@ProviderType
public class NoticiaLocalServiceWrapper
	implements NoticiaLocalService, ServiceWrapper<NoticiaLocalService> {

	public NoticiaLocalServiceWrapper(NoticiaLocalService noticiaLocalService) {
		_noticiaLocalService = noticiaLocalService;
	}

	/**
	 * Adds the noticia to the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was added
	 */
	@Override
	public noticias.sb.model.Noticia addNoticia(
		noticias.sb.model.Noticia noticia) {

		return _noticiaLocalService.addNoticia(noticia);
	}

	/**
	 * Creates a new noticia with the primary key. Does not add the noticia to the database.
	 *
	 * @param noticiaId the primary key for the new noticia
	 * @return the new noticia
	 */
	@Override
	public noticias.sb.model.Noticia createNoticia(long noticiaId) {
		return _noticiaLocalService.createNoticia(noticiaId);
	}

	/**
	 * Deletes the noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia that was removed
	 * @throws PortalException if a noticia with the primary key could not be found
	 */
	@Override
	public noticias.sb.model.Noticia deleteNoticia(long noticiaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noticiaLocalService.deleteNoticia(noticiaId);
	}

	/**
	 * Deletes the noticia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was removed
	 */
	@Override
	public noticias.sb.model.Noticia deleteNoticia(
		noticias.sb.model.Noticia noticia) {

		return _noticiaLocalService.deleteNoticia(noticia);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noticiaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _noticiaLocalService.dynamicQuery();
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

		return _noticiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>noticias.sb.model.impl.NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _noticiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>noticias.sb.model.impl.NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _noticiaLocalService.dynamicQuery(
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

		return _noticiaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _noticiaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public noticias.sb.model.Noticia fetchNoticia(long noticiaId) {
		return _noticiaLocalService.fetchNoticia(noticiaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _noticiaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _noticiaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the noticia with the primary key.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia
	 * @throws PortalException if a noticia with the primary key could not be found
	 */
	@Override
	public noticias.sb.model.Noticia getNoticia(long noticiaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noticiaLocalService.getNoticia(noticiaId);
	}

	/**
	 * Returns a range of all the noticias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>noticias.sb.model.impl.NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @return the range of noticias
	 */
	@Override
	public java.util.List<noticias.sb.model.Noticia> getNoticias(
		int start, int end) {

		return _noticiaLocalService.getNoticias(start, end);
	}

	/**
	 * Returns the number of noticias.
	 *
	 * @return the number of noticias
	 */
	@Override
	public int getNoticiasCount() {
		return _noticiaLocalService.getNoticiasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noticiaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noticiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the noticia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was updated
	 */
	@Override
	public noticias.sb.model.Noticia updateNoticia(
		noticias.sb.model.Noticia noticia) {

		return _noticiaLocalService.updateNoticia(noticia);
	}

	@Override
	public NoticiaLocalService getWrappedService() {
		return _noticiaLocalService;
	}

	@Override
	public void setWrappedService(NoticiaLocalService noticiaLocalService) {
		_noticiaLocalService = noticiaLocalService;
	}

	private NoticiaLocalService _noticiaLocalService;

}