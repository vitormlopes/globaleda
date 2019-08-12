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

import Global.eda.sb.exception.NoSuchGlobalEdaException;
import Global.eda.sb.model.GlobalEda;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the global eda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalEdaUtil
 * @generated
 */
@ProviderType
public interface GlobalEdaPersistence extends BasePersistence<GlobalEda> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlobalEdaUtil} to access the global eda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching global edas
	 */
	public java.util.List<GlobalEda> findByUuid(String uuid);

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
	public java.util.List<GlobalEda> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

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
	public java.util.List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

	/**
	 * Returns the global edas before and after the current global eda in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current global eda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public GlobalEda[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Removes all the global edas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching global edas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByUUID_G(String uuid, long groupId)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the global eda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the global eda that was removed
	 */
	public GlobalEda removeByUUID_G(String uuid, long groupId)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the number of global edas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching global edas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching global edas
	 */
	public java.util.List<GlobalEda> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

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
	public java.util.List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

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
	public GlobalEda[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Removes all the global edas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching global edas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching global edas
	 */
	public java.util.List<GlobalEda> findByField2(boolean field2);

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
	public java.util.List<GlobalEda> findByField2(
		boolean field2, int start, int end);

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
	public java.util.List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

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
	public java.util.List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByField2_First(
			boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByField2_First(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	public GlobalEda findByField2_Last(
			boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	public GlobalEda fetchByField2_Last(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

	/**
	 * Returns the global edas before and after the current global eda in the ordered set where field2 = &#63;.
	 *
	 * @param fooId the primary key of the current global eda
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public GlobalEda[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
				orderByComparator)
		throws NoSuchGlobalEdaException;

	/**
	 * Removes all the global edas where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	public void removeByField2(boolean field2);

	/**
	 * Returns the number of global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching global edas
	 */
	public int countByField2(boolean field2);

	/**
	 * Caches the global eda in the entity cache if it is enabled.
	 *
	 * @param globalEda the global eda
	 */
	public void cacheResult(GlobalEda globalEda);

	/**
	 * Caches the global edas in the entity cache if it is enabled.
	 *
	 * @param globalEdas the global edas
	 */
	public void cacheResult(java.util.List<GlobalEda> globalEdas);

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	public GlobalEda create(long fooId);

	/**
	 * Removes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public GlobalEda remove(long fooId) throws NoSuchGlobalEdaException;

	public GlobalEda updateImpl(GlobalEda globalEda);

	/**
	 * Returns the global eda with the primary key or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	public GlobalEda findByPrimaryKey(long fooId)
		throws NoSuchGlobalEdaException;

	/**
	 * Returns the global eda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda, or <code>null</code> if a global eda with the primary key could not be found
	 */
	public GlobalEda fetchByPrimaryKey(long fooId);

	/**
	 * Returns all the global edas.
	 *
	 * @return the global edas
	 */
	public java.util.List<GlobalEda> findAll();

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
	public java.util.List<GlobalEda> findAll(int start, int end);

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
	public java.util.List<GlobalEda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator);

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
	public java.util.List<GlobalEda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalEda>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the global edas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	public int countAll();

}