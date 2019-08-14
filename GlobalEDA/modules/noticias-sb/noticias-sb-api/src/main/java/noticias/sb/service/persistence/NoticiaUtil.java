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

package noticias.sb.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import noticias.sb.model.Noticia;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the noticia service. This utility wraps <code>noticias.sb.service.persistence.impl.NoticiaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoticiaPersistence
 * @generated
 */
@ProviderType
public class NoticiaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Noticia noticia) {
		getPersistence().clearCache(noticia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Noticia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Noticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Noticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Noticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Noticia> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Noticia update(Noticia noticia) {
		return getPersistence().update(noticia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Noticia update(
		Noticia noticia, ServiceContext serviceContext) {

		return getPersistence().update(noticia, serviceContext);
	}

	/**
	 * Returns all the noticias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching noticias
	 */
	public static List<Noticia> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the noticias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @return the range of matching noticias
	 */
	public static List<Noticia> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the noticias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching noticias
	 */
	public static List<Noticia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Noticia> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the noticias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching noticias
	 */
	public static List<Noticia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Noticia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noticia
	 * @throws NoSuchNoticiaException if a matching noticia could not be found
	 */
	public static Noticia findByUuid_First(
			String uuid, OrderByComparator<Noticia> orderByComparator)
		throws noticias.sb.exception.NoSuchNoticiaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noticia, or <code>null</code> if a matching noticia could not be found
	 */
	public static Noticia fetchByUuid_First(
		String uuid, OrderByComparator<Noticia> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noticia
	 * @throws NoSuchNoticiaException if a matching noticia could not be found
	 */
	public static Noticia findByUuid_Last(
			String uuid, OrderByComparator<Noticia> orderByComparator)
		throws noticias.sb.exception.NoSuchNoticiaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noticia, or <code>null</code> if a matching noticia could not be found
	 */
	public static Noticia fetchByUuid_Last(
		String uuid, OrderByComparator<Noticia> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the noticias before and after the current noticia in the ordered set where uuid = &#63;.
	 *
	 * @param noticiaId the primary key of the current noticia
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noticia
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public static Noticia[] findByUuid_PrevAndNext(
			long noticiaId, String uuid,
			OrderByComparator<Noticia> orderByComparator)
		throws noticias.sb.exception.NoSuchNoticiaException {

		return getPersistence().findByUuid_PrevAndNext(
			noticiaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the noticias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of noticias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching noticias
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the noticia in the entity cache if it is enabled.
	 *
	 * @param noticia the noticia
	 */
	public static void cacheResult(Noticia noticia) {
		getPersistence().cacheResult(noticia);
	}

	/**
	 * Caches the noticias in the entity cache if it is enabled.
	 *
	 * @param noticias the noticias
	 */
	public static void cacheResult(List<Noticia> noticias) {
		getPersistence().cacheResult(noticias);
	}

	/**
	 * Creates a new noticia with the primary key. Does not add the noticia to the database.
	 *
	 * @param noticiaId the primary key for the new noticia
	 * @return the new noticia
	 */
	public static Noticia create(long noticiaId) {
		return getPersistence().create(noticiaId);
	}

	/**
	 * Removes the noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia that was removed
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public static Noticia remove(long noticiaId)
		throws noticias.sb.exception.NoSuchNoticiaException {

		return getPersistence().remove(noticiaId);
	}

	public static Noticia updateImpl(Noticia noticia) {
		return getPersistence().updateImpl(noticia);
	}

	/**
	 * Returns the noticia with the primary key or throws a <code>NoSuchNoticiaException</code> if it could not be found.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public static Noticia findByPrimaryKey(long noticiaId)
		throws noticias.sb.exception.NoSuchNoticiaException {

		return getPersistence().findByPrimaryKey(noticiaId);
	}

	/**
	 * Returns the noticia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia, or <code>null</code> if a noticia with the primary key could not be found
	 */
	public static Noticia fetchByPrimaryKey(long noticiaId) {
		return getPersistence().fetchByPrimaryKey(noticiaId);
	}

	/**
	 * Returns all the noticias.
	 *
	 * @return the noticias
	 */
	public static List<Noticia> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the noticias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @return the range of noticias
	 */
	public static List<Noticia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the noticias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of noticias
	 */
	public static List<Noticia> findAll(
		int start, int end, OrderByComparator<Noticia> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the noticias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NoticiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of noticias
	 * @param end the upper bound of the range of noticias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of noticias
	 */
	public static List<Noticia> findAll(
		int start, int end, OrderByComparator<Noticia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the noticias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of noticias.
	 *
	 * @return the number of noticias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NoticiaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NoticiaPersistence, NoticiaPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NoticiaPersistence.class);

		ServiceTracker<NoticiaPersistence, NoticiaPersistence> serviceTracker =
			new ServiceTracker<NoticiaPersistence, NoticiaPersistence>(
				bundle.getBundleContext(), NoticiaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}