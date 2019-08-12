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

package Global.eda.sb.service.persistence.impl;

import Global.eda.sb.exception.NoSuchGlobalEdaException;
import Global.eda.sb.model.GlobalEda;
import Global.eda.sb.model.impl.GlobalEdaImpl;
import Global.eda.sb.model.impl.GlobalEdaModelImpl;
import Global.eda.sb.service.persistence.GlobalEdaPersistence;
import Global.eda.sb.service.persistence.impl.constants.EDAPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the global eda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GlobalEdaPersistence.class)
@ProviderType
public class GlobalEdaPersistenceImpl
	extends BasePersistenceImpl<GlobalEda> implements GlobalEdaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GlobalEdaUtil</code> to access the global eda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GlobalEdaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching global edas
	 */
	@Override
	public List<GlobalEda> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GlobalEda> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<GlobalEda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<GlobalEda> list = null;

		if (retrieveFromCache) {
			list = (List<GlobalEda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GlobalEda globalEda : list) {
					if (!uuid.equals(globalEda.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	@Override
	public GlobalEda findByUuid_First(
			String uuid, OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByUuid_First(uuid, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUuid_First(
		String uuid, OrderByComparator<GlobalEda> orderByComparator) {

		List<GlobalEda> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	@Override
	public GlobalEda findByUuid_Last(
			String uuid, OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByUuid_Last(uuid, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUuid_Last(
		String uuid, OrderByComparator<GlobalEda> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GlobalEda> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GlobalEda[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		uuid = Objects.toString(uuid, "");

		GlobalEda globalEda = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			GlobalEda[] array = new GlobalEdaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, globalEda, uuid, orderByComparator, true);

			array[1] = globalEda;

			array[2] = getByUuid_PrevAndNext(
				session, globalEda, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalEda getByUuid_PrevAndNext(
		Session session, GlobalEda globalEda, String uuid,
		OrderByComparator<GlobalEda> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOBALEDA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(globalEda)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GlobalEda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the global edas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GlobalEda globalEda :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(globalEda);
		}
	}

	/**
	 * Returns the number of global edas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching global edas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"globalEda.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(globalEda.uuid IS NULL OR globalEda.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	@Override
	public GlobalEda findByUUID_G(String uuid, long groupId)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByUUID_G(uuid, groupId);

		if (globalEda == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchGlobalEdaException(msg.toString());
		}

		return globalEda;
	}

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the global eda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof GlobalEda) {
			GlobalEda globalEda = (GlobalEda)result;

			if (!Objects.equals(uuid, globalEda.getUuid()) ||
				(groupId != globalEda.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<GlobalEda> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					GlobalEda globalEda = list.get(0);

					result = globalEda;

					cacheResult(globalEda);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GlobalEda)result;
		}
	}

	/**
	 * Removes the global eda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the global eda that was removed
	 */
	@Override
	public GlobalEda removeByUUID_G(String uuid, long groupId)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = findByUUID_G(uuid, groupId);

		return remove(globalEda);
	}

	/**
	 * Returns the number of global edas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching global edas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"globalEda.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(globalEda.uuid IS NULL OR globalEda.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"globalEda.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching global edas
	 */
	@Override
	public List<GlobalEda> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<GlobalEda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<GlobalEda> list = null;

		if (retrieveFromCache) {
			list = (List<GlobalEda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GlobalEda globalEda : list) {
					if (!uuid.equals(globalEda.getUuid()) ||
						(companyId != globalEda.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public GlobalEda findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the first global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GlobalEda> orderByComparator) {

		List<GlobalEda> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GlobalEda findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the last global eda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GlobalEda> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<GlobalEda> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GlobalEda[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		uuid = Objects.toString(uuid, "");

		GlobalEda globalEda = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			GlobalEda[] array = new GlobalEdaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, globalEda, uuid, companyId, orderByComparator, true);

			array[1] = globalEda;

			array[2] = getByUuid_C_PrevAndNext(
				session, globalEda, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalEda getByUuid_C_PrevAndNext(
		Session session, GlobalEda globalEda, String uuid, long companyId,
		OrderByComparator<GlobalEda> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GLOBALEDA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(globalEda)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GlobalEda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the global edas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (GlobalEda globalEda :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(globalEda);
		}
	}

	/**
	 * Returns the number of global edas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching global edas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOBALEDA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"globalEda.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(globalEda.uuid IS NULL OR globalEda.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"globalEda.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByField2;
	private FinderPath _finderPathWithoutPaginationFindByField2;
	private FinderPath _finderPathCountByField2;

	/**
	 * Returns all the global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching global edas
	 */
	@Override
	public List<GlobalEda> findByField2(boolean field2) {
		return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GlobalEda> findByField2(boolean field2, int start, int end) {
		return findByField2(field2, start, end, null);
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
	@Override
	public List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return findByField2(field2, start, end, orderByComparator, true);
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
	@Override
	public List<GlobalEda> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByField2;
			finderArgs = new Object[] {field2};
		}
		else {
			finderPath = _finderPathWithPaginationFindByField2;
			finderArgs = new Object[] {field2, start, end, orderByComparator};
		}

		List<GlobalEda> list = null;

		if (retrieveFromCache) {
			list = (List<GlobalEda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GlobalEda globalEda : list) {
					if ((field2 != globalEda.isField2())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GLOBALEDA_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				if (!pagination) {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	@Override
	public GlobalEda findByField2_First(
			boolean field2, OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByField2_First(field2, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the first global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByField2_First(
		boolean field2, OrderByComparator<GlobalEda> orderByComparator) {

		List<GlobalEda> list = findByField2(field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda
	 * @throws NoSuchGlobalEdaException if a matching global eda could not be found
	 */
	@Override
	public GlobalEda findByField2_Last(
			boolean field2, OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByField2_Last(field2, orderByComparator);

		if (globalEda != null) {
			return globalEda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append("}");

		throw new NoSuchGlobalEdaException(msg.toString());
	}

	/**
	 * Returns the last global eda in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchByField2_Last(
		boolean field2, OrderByComparator<GlobalEda> orderByComparator) {

		int count = countByField2(field2);

		if (count == 0) {
			return null;
		}

		List<GlobalEda> list = findByField2(
			field2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GlobalEda[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			OrderByComparator<GlobalEda> orderByComparator)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			GlobalEda[] array = new GlobalEdaImpl[3];

			array[0] = getByField2_PrevAndNext(
				session, globalEda, field2, orderByComparator, true);

			array[1] = globalEda;

			array[2] = getByField2_PrevAndNext(
				session, globalEda, field2, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalEda getByField2_PrevAndNext(
		Session session, GlobalEda globalEda, boolean field2,
		OrderByComparator<GlobalEda> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOBALEDA_WHERE);

		query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GlobalEdaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(field2);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(globalEda)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GlobalEda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the global edas where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	@Override
	public void removeByField2(boolean field2) {
		for (GlobalEda globalEda :
				findByField2(
					field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(globalEda);
		}
	}

	/**
	 * Returns the number of global edas where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching global edas
	 */
	@Override
	public int countByField2(boolean field2) {
		FinderPath finderPath = _finderPathCountByField2;

		Object[] finderArgs = new Object[] {field2};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOBALEDA_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 =
		"globalEda.field2 = ?";

	public GlobalEdaPersistenceImpl() {
		setModelClass(GlobalEda.class);

		setModelImplClass(GlobalEdaImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the global eda in the entity cache if it is enabled.
	 *
	 * @param globalEda the global eda
	 */
	@Override
	public void cacheResult(GlobalEda globalEda) {
		entityCache.putResult(
			entityCacheEnabled, GlobalEdaImpl.class, globalEda.getPrimaryKey(),
			globalEda);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {globalEda.getUuid(), globalEda.getGroupId()},
			globalEda);

		globalEda.resetOriginalValues();
	}

	/**
	 * Caches the global edas in the entity cache if it is enabled.
	 *
	 * @param globalEdas the global edas
	 */
	@Override
	public void cacheResult(List<GlobalEda> globalEdas) {
		for (GlobalEda globalEda : globalEdas) {
			if (entityCache.getResult(
					entityCacheEnabled, GlobalEdaImpl.class,
					globalEda.getPrimaryKey()) == null) {

				cacheResult(globalEda);
			}
			else {
				globalEda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all global edas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GlobalEdaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the global eda.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlobalEda globalEda) {
		entityCache.removeResult(
			entityCacheEnabled, GlobalEdaImpl.class, globalEda.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((GlobalEdaModelImpl)globalEda, true);
	}

	@Override
	public void clearCache(List<GlobalEda> globalEdas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GlobalEda globalEda : globalEdas) {
			entityCache.removeResult(
				entityCacheEnabled, GlobalEdaImpl.class,
				globalEda.getPrimaryKey());

			clearUniqueFindersCache((GlobalEdaModelImpl)globalEda, true);
		}
	}

	protected void cacheUniqueFindersCache(
		GlobalEdaModelImpl globalEdaModelImpl) {

		Object[] args = new Object[] {
			globalEdaModelImpl.getUuid(), globalEdaModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, globalEdaModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		GlobalEdaModelImpl globalEdaModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				globalEdaModelImpl.getUuid(), globalEdaModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((globalEdaModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				globalEdaModelImpl.getOriginalUuid(),
				globalEdaModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	@Override
	public GlobalEda create(long fooId) {
		GlobalEda globalEda = new GlobalEdaImpl();

		globalEda.setNew(true);
		globalEda.setPrimaryKey(fooId);

		String uuid = PortalUUIDUtil.generate();

		globalEda.setUuid(uuid);

		globalEda.setCompanyId(companyProvider.getCompanyId());

		return globalEda;
	}

	/**
	 * Removes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda remove(long fooId) throws NoSuchGlobalEdaException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda remove(Serializable primaryKey)
		throws NoSuchGlobalEdaException {

		Session session = null;

		try {
			session = openSession();

			GlobalEda globalEda = (GlobalEda)session.get(
				GlobalEdaImpl.class, primaryKey);

			if (globalEda == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlobalEdaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(globalEda);
		}
		catch (NoSuchGlobalEdaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GlobalEda removeImpl(GlobalEda globalEda) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(globalEda)) {
				globalEda = (GlobalEda)session.get(
					GlobalEdaImpl.class, globalEda.getPrimaryKeyObj());
			}

			if (globalEda != null) {
				session.delete(globalEda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (globalEda != null) {
			clearCache(globalEda);
		}

		return globalEda;
	}

	@Override
	public GlobalEda updateImpl(GlobalEda globalEda) {
		boolean isNew = globalEda.isNew();

		if (!(globalEda instanceof GlobalEdaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(globalEda.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(globalEda);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in globalEda proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GlobalEda implementation " +
					globalEda.getClass());
		}

		GlobalEdaModelImpl globalEdaModelImpl = (GlobalEdaModelImpl)globalEda;

		if (Validator.isNull(globalEda.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			globalEda.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (globalEda.getCreateDate() == null)) {
			if (serviceContext == null) {
				globalEda.setCreateDate(now);
			}
			else {
				globalEda.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!globalEdaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				globalEda.setModifiedDate(now);
			}
			else {
				globalEda.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (globalEda.isNew()) {
				session.save(globalEda);

				globalEda.setNew(false);
			}
			else {
				globalEda = (GlobalEda)session.merge(globalEda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {globalEdaModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				globalEdaModelImpl.getUuid(), globalEdaModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {globalEdaModelImpl.isField2()};

			finderCache.removeResult(_finderPathCountByField2, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField2, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((globalEdaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					globalEdaModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {globalEdaModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((globalEdaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					globalEdaModelImpl.getOriginalUuid(),
					globalEdaModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					globalEdaModelImpl.getUuid(),
					globalEdaModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((globalEdaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField2.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					globalEdaModelImpl.getOriginalField2()
				};

				finderCache.removeResult(_finderPathCountByField2, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField2, args);

				args = new Object[] {globalEdaModelImpl.isField2()};

				finderCache.removeResult(_finderPathCountByField2, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField2, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GlobalEdaImpl.class, globalEda.getPrimaryKey(),
			globalEda, false);

		clearUniqueFindersCache(globalEdaModelImpl, false);
		cacheUniqueFindersCache(globalEdaModelImpl);

		globalEda.resetOriginalValues();

		return globalEda;
	}

	/**
	 * Returns the global eda with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the global eda
	 * @return the global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlobalEdaException {

		GlobalEda globalEda = fetchByPrimaryKey(primaryKey);

		if (globalEda == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlobalEdaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return globalEda;
	}

	/**
	 * Returns the global eda with the primary key or throws a <code>NoSuchGlobalEdaException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws NoSuchGlobalEdaException if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda findByPrimaryKey(long fooId)
		throws NoSuchGlobalEdaException {

		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the global eda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda, or <code>null</code> if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns all the global edas.
	 *
	 * @return the global edas
	 */
	@Override
	public List<GlobalEda> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GlobalEda> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<GlobalEda> findAll(
		int start, int end, OrderByComparator<GlobalEda> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<GlobalEda> findAll(
		int start, int end, OrderByComparator<GlobalEda> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<GlobalEda> list = null;

		if (retrieveFromCache) {
			list = (List<GlobalEda>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GLOBALEDA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOBALEDA;

				if (pagination) {
					sql = sql.concat(GlobalEdaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GlobalEda>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the global edas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GlobalEda globalEda : findAll()) {
			remove(globalEda);
		}
	}

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GLOBALEDA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "fooId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GLOBALEDA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GlobalEdaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the global eda persistence.
	 */
	@Activate
	public void activate() {
		GlobalEdaModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GlobalEdaModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			GlobalEdaModelImpl.UUID_COLUMN_BITMASK |
			GlobalEdaModelImpl.FIELD1_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			GlobalEdaModelImpl.UUID_COLUMN_BITMASK |
			GlobalEdaModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			GlobalEdaModelImpl.UUID_COLUMN_BITMASK |
			GlobalEdaModelImpl.COMPANYID_COLUMN_BITMASK |
			GlobalEdaModelImpl.FIELD1_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByField2 = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField2 = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GlobalEdaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
			new String[] {Boolean.class.getName()},
			GlobalEdaModelImpl.FIELD2_COLUMN_BITMASK |
			GlobalEdaModelImpl.FIELD1_COLUMN_BITMASK);

		_finderPathCountByField2 = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GlobalEdaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = EDAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.Global.eda.sb.model.GlobalEda"),
			true);
	}

	@Override
	@Reference(
		target = EDAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EDAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GLOBALEDA =
		"SELECT globalEda FROM GlobalEda globalEda";

	private static final String _SQL_SELECT_GLOBALEDA_WHERE =
		"SELECT globalEda FROM GlobalEda globalEda WHERE ";

	private static final String _SQL_COUNT_GLOBALEDA =
		"SELECT COUNT(globalEda) FROM GlobalEda globalEda";

	private static final String _SQL_COUNT_GLOBALEDA_WHERE =
		"SELECT COUNT(globalEda) FROM GlobalEda globalEda WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "globalEda.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GlobalEda exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GlobalEda exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GlobalEdaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}