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

package Global.eda.sb.service.persistence;

import Global.eda.sb.model.GlobalEda;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the global eda service. This utility wraps <code>Global.eda.sb.service.persistence.impl.GlobalEdaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalEdaPersistence
 * @generated
 */
@ProviderType
public class GlobalEdaUtil {

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
	public static void clearCache(GlobalEda globalEda) {
		getPersistence().clearCache(globalEda);
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
	public static Map<Serializable, GlobalEda> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GlobalEda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GlobalEda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GlobalEda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GlobalEda update(GlobalEda globalEda) {
		return getPersistence().update(globalEda);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GlobalEda update(
		GlobalEda globalEda, ServiceContext serviceContext) {

		return getPersistence().update(globalEda, serviceContext);
	}

	/**
	 * Returns all the global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching global edas
	 */
	public static List<GlobalEda> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the global edas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @return the range of matching global edas
	 */
	public static List<GlobalEda> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the global edas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the global edas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByUuid_First(
			String uuid, OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUuid_First(
		String uuid, OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByUuid_Last(
			String uuid, OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUuid_Last(
		String uuid, OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the global edas before and after the current global eda in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current global eda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public static GlobalEda[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_PrevAndNext(
			fooId, uuid, orderByComparator);
	}

	/**
	 * Removes all the global edas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching global edas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByUUID_G(String uuid, long groupId)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the global eda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the global eda that was removed
	 */
	public static GlobalEda removeByUUID_G(String uuid, long groupId)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of global edas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching global edas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching global edas
	 */
	public static List<GlobalEda> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @return the range of matching global edas
	 */
	public static List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the global edas before and after the current global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fooId the primary key of the current global eda
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public static GlobalEda[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fooId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the global edas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching global edas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching global edas
	 */
	public static List<GlobalEda> findByField2(boolean field2) {
		return getPersistence().findByField2(field2);
	}

	/**
	 * Returns a range of all the global edas where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @return the range of matching global edas
	 */
	public static List<GlobalEda> findByField2(
		boolean field2, int start, int end) {

		return getPersistence().findByField2(field2, start, end);
	}

	/**
	 * Returns an ordered range of all the global edas where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().findByField2(
			field2, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the global edas where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching global edas
	 */
	public static List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByField2(
			field2, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByField2_First(
			boolean field2, OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByField2_First(field2, orderByComparator);
	}

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByField2_First(
		boolean field2, OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByField2_First(field2, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public static GlobalEda findByField2_Last(
			boolean field2, OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByField2_Last(field2, orderByComparator);
	}

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public static GlobalEda fetchByField2_Last(
		boolean field2, OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().fetchByField2_Last(field2, orderByComparator);
	}

	/**
	 * Returns the global edas before and after the current global eda in the ordered set where field2 = &#63;.
	 *
	 * @param fooId the primary key of the current global eda
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public static GlobalEda[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			OrderByComparator<GlobalEda> orderByComparator)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByField2_PrevAndNext(
			fooId, field2, orderByComparator);
	}

	/**
	 * Removes all the global edas where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	public static void removeByField2(boolean field2) {
		getPersistence().removeByField2(field2);
	}

	/**
	 * Returns the number of global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching global edas
	 */
	public static int countByField2(boolean field2) {
		return getPersistence().countByField2(field2);
	}

	/**
	 * Caches the global eda in the entity cache if it is enabled.
	 *
	 * @param globalEda the global eda
	 */
	public static void cacheResult(GlobalEda globalEda) {
		getPersistence().cacheResult(globalEda);
	}

	/**
	 * Caches the global edas in the entity cache if it is enabled.
	 *
	 * @param globalEdas the global edas
	 */
	public static void cacheResult(List<GlobalEda> globalEdas) {
		getPersistence().cacheResult(globalEdas);
	}

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	public static GlobalEda create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	 * Removes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public static GlobalEda remove(long fooId)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().remove(fooId);
	}

	public static GlobalEda updateImpl(GlobalEda globalEda) {
		return getPersistence().updateImpl(globalEda);
	}

	/**
	 * Returns the global eda with the primary key or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public static GlobalEda findByPrimaryKey(long fooId)
		throws Global.eda.sb.exception.NoSuchGlobalEdaException {

		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	 * Returns the global eda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda, or <code>null</code> if a global eda with the primary key could not be found
	 */
	public static GlobalEda fetchByPrimaryKey(long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	/**
	 * Returns all the global edas.
	 *
	 * @return the global edas
	 */
	public static List<GlobalEda> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the global edas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @return the range of global edas
	 */
	public static List<GlobalEda> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the global edas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of global edas
	 */
	public static List<GlobalEda> findAll(
		int start, int end, OrderByComparator<GlobalEda> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the global edas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GlobalEdaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of global edas
	 * @param end the upper bound of the range of global edas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of global edas
	 */
	public static List<GlobalEda> findAll(
		int start, int end, OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the global edas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GlobalEdaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GlobalEdaPersistence, GlobalEdaPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GlobalEdaPersistence.class);

		ServiceTracker<GlobalEdaPersistence, GlobalEdaPersistence>
			serviceTracker =
				new ServiceTracker<GlobalEdaPersistence, GlobalEdaPersistence>(
					bundle.getBundleContext(), GlobalEdaPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}