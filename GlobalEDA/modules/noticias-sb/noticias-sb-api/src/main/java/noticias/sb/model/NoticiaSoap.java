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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link noticias.sb.service.http.NoticiaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NoticiaSoap implements Serializable {

	public static NoticiaSoap toSoapModel(Noticia model) {
		NoticiaSoap soapModel = new NoticiaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNoticiaId(model.getNoticiaId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitulo(model.getTitulo());
		soapModel.setDescricao(model.getDescricao());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setFileUrl(model.getFileUrl());

		return soapModel;
	}

	public static NoticiaSoap[] toSoapModels(Noticia[] models) {
		NoticiaSoap[] soapModels = new NoticiaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NoticiaSoap[][] toSoapModels(Noticia[][] models) {
		NoticiaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NoticiaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NoticiaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NoticiaSoap[] toSoapModels(List<Noticia> models) {
		List<NoticiaSoap> soapModels = new ArrayList<NoticiaSoap>(
			models.size());

		for (Noticia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NoticiaSoap[soapModels.size()]);
	}

	public NoticiaSoap() {
	}

	public long getPrimaryKey() {
		return _noticiaId;
	}

	public void setPrimaryKey(long pk) {
		setNoticiaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNoticiaId() {
		return _noticiaId;
	}

	public void setNoticiaId(long noticiaId) {
		_noticiaId = noticiaId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitulo() {
		return _titulo;
	}

	public void setTitulo(String titulo) {
		_titulo = titulo;
	}

	public String getDescricao() {
		return _descricao;
	}

	public void setDescricao(String descricao) {
		_descricao = descricao;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public String getFileUrl() {
		return _fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		_fileUrl = fileUrl;
	}

	private String _uuid;
	private long _noticiaId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _titulo;
	private String _descricao;
	private long _documentId;
	private String _fileUrl;

}