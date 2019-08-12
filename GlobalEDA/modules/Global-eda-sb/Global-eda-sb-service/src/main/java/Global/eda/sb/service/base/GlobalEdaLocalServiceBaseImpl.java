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

package Global.eda.sb.service.base;

import Global.eda.sb.model.GlobalEda;
import Global.eda.sb.service.GlobalEdaLocalService;
import Global.eda.sb.service.persistence.GlobalEdaPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the global eda local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link Global.eda.sb.service.impl.GlobalEdaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Global.eda.sb.service.impl.GlobalEdaLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class GlobalEdaLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements GlobalEdaLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>GlobalEdaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>Global.eda.sb.service.GlobalEdaLocalServiceUtil</code>.
	 */

	/**
	 * Adds the global eda to the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GlobalEda addGlobalEda(GlobalEda globalEda) {
		globalEda.setNew(true);

		return globalEdaPersistence.update(globalEda);
	}

	/**
	 * Creates a new global eda with the primary key. Does not add the global eda to the database.
	 *
	 * @param fooId the primary key for the new global eda
	 * @return the new global eda
	 */
	@Override
	@Transactional(enabled = false)
	public GlobalEda createGlobalEda(long fooId) {
		return globalEdaPersistence.create(fooId);
	}

	/**
	 * Deletes the global eda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda that was removed
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GlobalEda deleteGlobalEda(long fooId) throws PortalException {
		return globalEdaPersistence.remove(fooId);
	}

	/**
	 * Deletes the global eda from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GlobalEda deleteGlobalEda(GlobalEda globalEda) {
		return globalEdaPersistence.remove(globalEda);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			GlobalEda.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return globalEdaPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return globalEdaPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return globalEdaPersistence.findWithDynamicQuery(
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
		return globalEdaPersistence.countWithDynamicQuery(dynamicQuery);
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

		return globalEdaPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public GlobalEda fetchGlobalEda(long fooId) {
		return globalEdaPersistence.fetchByPrimaryKey(fooId);
	}

	/**
	 * Returns the global eda matching the UUID and group.
	 *
	 * @param uuid the global eda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching global eda, or <code>null</code> if a matching global eda could not be found
	 */
	@Override
	public GlobalEda fetchGlobalEdaByUuidAndGroupId(String uuid, long groupId) {
		return globalEdaPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the global eda with the primary key.
	 *
	 * @param fooId the primary key of the global eda
	 * @return the global eda
	 * @throws PortalException if a global eda with the primary key could not be found
	 */
	@Override
	public GlobalEda getGlobalEda(long fooId) throws PortalException {
		return globalEdaPersistence.findByPrimaryKey(fooId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(globalEdaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(GlobalEda.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("fooId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			globalEdaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(GlobalEda.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("fooId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(globalEdaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(GlobalEda.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("fooId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<GlobalEda>() {

				@Override
				public void performAction(GlobalEda globalEda)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, globalEda);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(GlobalEda.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return globalEdaLocalService.deleteGlobalEda((GlobalEda)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return globalEdaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the global edas matching the UUID and company.
	 *
	 * @param uuid the UUID of the global edas
	 * @param companyId the primary key of the company
	 * @return the matching global edas, or an empty list if no matches were found
	 */
	@Override
	public List<GlobalEda> getGlobalEdasByUuidAndCompanyId(
		String uuid, long companyId) {

		return globalEdaPersistence.findByUuid_C(uuid, companyId);
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
	public List<GlobalEda> getGlobalEdasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GlobalEda> orderByComparator) {

		return globalEdaPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public GlobalEda getGlobalEdaByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return globalEdaPersistence.findByUUID_G(uuid, groupId);
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
	public List<GlobalEda> getGlobalEdas(int start, int end) {
		return globalEdaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of global edas.
	 *
	 * @return the number of global edas
	 */
	@Override
	public int getGlobalEdasCount() {
		return globalEdaPersistence.countAll();
	}

	/**
	 * Updates the global eda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param globalEda the global eda
	 * @return the global eda that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GlobalEda updateGlobalEda(GlobalEda globalEda) {
		return globalEdaPersistence.update(globalEda);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			GlobalEdaLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		globalEdaLocalService = (GlobalEdaLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return GlobalEdaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return GlobalEda.class;
	}

	protected String getModelClassName() {
		return GlobalEda.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = globalEdaPersistence.getDataSource();

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

	protected GlobalEdaLocalService globalEdaLocalService;

	@Reference
	protected GlobalEdaPersistence globalEdaPersistence;

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

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}