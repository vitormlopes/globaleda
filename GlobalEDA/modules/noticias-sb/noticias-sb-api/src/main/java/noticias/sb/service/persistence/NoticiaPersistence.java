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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import noticias.sb.exception.NoSuchNoticiaException;
import noticias.sb.model.Noticia;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the noticia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoticiaUtil
 * @generated
 */
@ProviderType
public interface NoticiaPersistence extends BasePersistence<Noticia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NoticiaUtil} to access the noticia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the noticias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching noticias
	 */
	public java.util.List<Noticia> findByUuid(String uuid);

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
	public java.util.List<Noticia> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Noticia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator);

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
	public java.util.List<Noticia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noticia
	 * @throws NoSuchNoticiaException if a matching noticia could not be found
	 */
	public Noticia findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noticia>
				orderByComparator)
		throws NoSuchNoticiaException;

	/**
	 * Returns the first noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noticia, or <code>null</code> if a matching noticia could not be found
	 */
	public Noticia fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator);

	/**
	 * Returns the last noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noticia
	 * @throws NoSuchNoticiaException if a matching noticia could not be found
	 */
	public Noticia findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noticia>
				orderByComparator)
		throws NoSuchNoticiaException;

	/**
	 * Returns the last noticia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noticia, or <code>null</code> if a matching noticia could not be found
	 */
	public Noticia fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator);

	/**
	 * Returns the noticias before and after the current noticia in the ordered set where uuid = &#63;.
	 *
	 * @param noticiaId the primary key of the current noticia
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noticia
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public Noticia[] findByUuid_PrevAndNext(
			long noticiaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noticia>
				orderByComparator)
		throws NoSuchNoticiaException;

	/**
	 * Removes all the noticias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of noticias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching noticias
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the noticia in the entity cache if it is enabled.
	 *
	 * @param noticia the noticia
	 */
	public void cacheResult(Noticia noticia);

	/**
	 * Caches the noticias in the entity cache if it is enabled.
	 *
	 * @param noticias the noticias
	 */
	public void cacheResult(java.util.List<Noticia> noticias);

	/**
	 * Creates a new noticia with the primary key. Does not add the noticia to the database.
	 *
	 * @param noticiaId the primary key for the new noticia
	 * @return the new noticia
	 */
	public Noticia create(long noticiaId);

	/**
	 * Removes the noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia that was removed
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public Noticia remove(long noticiaId) throws NoSuchNoticiaException;

	public Noticia updateImpl(Noticia noticia);

	/**
	 * Returns the noticia with the primary key or throws a <code>NoSuchNoticiaException</code> if it could not be found.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia
	 * @throws NoSuchNoticiaException if a noticia with the primary key could not be found
	 */
	public Noticia findByPrimaryKey(long noticiaId)
		throws NoSuchNoticiaException;

	/**
	 * Returns the noticia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia, or <code>null</code> if a noticia with the primary key could not be found
	 */
	public Noticia fetchByPrimaryKey(long noticiaId);

	/**
	 * Returns all the noticias.
	 *
	 * @return the noticias
	 */
	public java.util.List<Noticia> findAll();

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
	public java.util.List<Noticia> findAll(int start, int end);

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
	public java.util.List<Noticia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator);

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
	public java.util.List<Noticia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noticia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the noticias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of noticias.
	 *
	 * @return the number of noticias
	 */
	public int countAll();

}