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

package noticias.sb.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import noticias.sb.model.Noticia;
import noticias.sb.service.NoticiaLocalService;
import noticias.sb.service.persistence.NoticiaPersistence;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the noticia local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link noticias.sb.service.impl.NoticiaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see noticias.sb.service.impl.NoticiaLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class NoticiaLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements NoticiaLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>NoticiaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>noticias.sb.service.NoticiaLocalServiceUtil</code>.
	 */

	/**
	 * Adds the noticia to the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Noticia addNoticia(Noticia noticia) {
		noticia.setNew(true);

		return noticiaPersistence.update(noticia);
	}

	/**
	 * Creates a new noticia with the primary key. Does not add the noticia to the database.
	 *
	 * @param noticiaId the primary key for the new noticia
	 * @return the new noticia
	 */
	@Override
	@Transactional(enabled = false)
	public Noticia createNoticia(long noticiaId) {
		return noticiaPersistence.create(noticiaId);
	}

	/**
	 * Deletes the noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia that was removed
	 * @throws PortalException if a noticia with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Noticia deleteNoticia(long noticiaId) throws PortalException {
		return noticiaPersistence.remove(noticiaId);
	}

	/**
	 * Deletes the noticia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Noticia deleteNoticia(Noticia noticia) {
		return noticiaPersistence.remove(noticia);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Noticia.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return noticiaPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return noticiaPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return noticiaPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return noticiaPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return noticiaPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Noticia fetchNoticia(long noticiaId) {
		return noticiaPersistence.fetchByPrimaryKey(noticiaId);
	}

	/**
	 * Returns the noticia with the primary key.
	 *
	 * @param noticiaId the primary key of the noticia
	 * @return the noticia
	 * @throws PortalException if a noticia with the primary key could not be found
	 */
	@Override
	public Noticia getNoticia(long noticiaId) throws PortalException {
		return noticiaPersistence.findByPrimaryKey(noticiaId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(noticiaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Noticia.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("noticiaId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			noticiaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Noticia.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("noticiaId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(noticiaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Noticia.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("noticiaId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return noticiaLocalService.deleteNoticia((Noticia)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return noticiaPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Noticia> getNoticias(int start, int end) {
		return noticiaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of noticias.
	 *
	 * @return the number of noticias
	 */
	@Override
	public int getNoticiasCount() {
		return noticiaPersistence.countAll();
	}

	/**
	 * Updates the noticia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param noticia the noticia
	 * @return the noticia that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Noticia updateNoticia(Noticia noticia) {
		return noticiaPersistence.update(noticia);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			NoticiaLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		noticiaLocalService = (NoticiaLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return NoticiaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Noticia.class;
	}

	protected String getModelClassName() {
		return Noticia.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = noticiaPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected NoticiaLocalService noticiaLocalService;

	@Reference
	protected NoticiaPersistence noticiaPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}