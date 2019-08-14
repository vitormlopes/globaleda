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

package noticias.sb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Noticia}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Noticia
 * @generated
 */
@ProviderType
public class NoticiaWrapper
	extends BaseModelWrapper<Noticia>
	implements Noticia, ModelWrapper<Noticia> {

	public NoticiaWrapper(Noticia noticia) {
		super(noticia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("noticiaId", getNoticiaId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("titulo", getTitulo());
		attributes.put("descricao", getDescricao());
		attributes.put("documentId", getDocumentId());
		attributes.put("fileUrl", getFileUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long noticiaId = (Long)attributes.get("noticiaId");

		if (noticiaId != null) {
			setNoticiaId(noticiaId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String titulo = (String)attributes.get("titulo");

		if (titulo != null) {
			setTitulo(titulo);
		}

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String fileUrl = (String)attributes.get("fileUrl");

		if (fileUrl != null) {
			setFileUrl(fileUrl);
		}
	}

	/**
	 * Returns the create date of this noticia.
	 *
	 * @return the create date of this noticia
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the descricao of this noticia.
	 *
	 * @return the descricao of this noticia
	 */
	@Override
	public String getDescricao() {
		return model.getDescricao();
	}

	/**
	 * Returns the document ID of this noticia.
	 *
	 * @return the document ID of this noticia
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the file url of this noticia.
	 *
	 * @return the file url of this noticia
	 */
	@Override
	public String getFileUrl() {
		return model.getFileUrl();
	}

	/**
	 * Returns the modified date of this noticia.
	 *
	 * @return the modified date of this noticia
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the noticia ID of this noticia.
	 *
	 * @return the noticia ID of this noticia
	 */
	@Override
	public long getNoticiaId() {
		return model.getNoticiaId();
	}

	/**
	 * Returns the primary key of this noticia.
	 *
	 * @return the primary key of this noticia
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the titulo of this noticia.
	 *
	 * @return the titulo of this noticia
	 */
	@Override
	public String getTitulo() {
		return model.getTitulo();
	}

	/**
	 * Returns the user ID of this noticia.
	 *
	 * @return the user ID of this noticia
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this noticia.
	 *
	 * @return the user name of this noticia
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this noticia.
	 *
	 * @return the user uuid of this noticia
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this noticia.
	 *
	 * @return the uuid of this noticia
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this noticia.
	 *
	 * @param createDate the create date of this noticia
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the descricao of this noticia.
	 *
	 * @param descricao the descricao of this noticia
	 */
	@Override
	public void setDescricao(String descricao) {
		model.setDescricao(descricao);
	}

	/**
	 * Sets the document ID of this noticia.
	 *
	 * @param documentId the document ID of this noticia
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the file url of this noticia.
	 *
	 * @param fileUrl the file url of this noticia
	 */
	@Override
	public void setFileUrl(String fileUrl) {
		model.setFileUrl(fileUrl);
	}

	/**
	 * Sets the modified date of this noticia.
	 *
	 * @param modifiedDate the modified date of this noticia
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the noticia ID of this noticia.
	 *
	 * @param noticiaId the noticia ID of this noticia
	 */
	@Override
	public void setNoticiaId(long noticiaId) {
		model.setNoticiaId(noticiaId);
	}

	/**
	 * Sets the primary key of this noticia.
	 *
	 * @param primaryKey the primary key of this noticia
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the titulo of this noticia.
	 *
	 * @param titulo the titulo of this noticia
	 */
	@Override
	public void setTitulo(String titulo) {
		model.setTitulo(titulo);
	}

	/**
	 * Sets the user ID of this noticia.
	 *
	 * @param userId the user ID of this noticia
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this noticia.
	 *
	 * @param userName the user name of this noticia
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this noticia.
	 *
	 * @param userUuid the user uuid of this noticia
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this noticia.
	 *
	 * @param uuid the uuid of this noticia
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected NoticiaWrapper wrap(Noticia noticia) {
		return new NoticiaWrapper(noticia);
	}

}