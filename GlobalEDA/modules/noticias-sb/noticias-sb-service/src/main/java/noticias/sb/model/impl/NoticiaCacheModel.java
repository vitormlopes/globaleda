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

package noticias.sb.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import noticias.sb.model.Noticia;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Noticia in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NoticiaCacheModel implements CacheModel<Noticia>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoticiaCacheModel)) {
			return false;
		}

		NoticiaCacheModel noticiaCacheModel = (NoticiaCacheModel)obj;

		if (noticiaId == noticiaCacheModel.noticiaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, noticiaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", noticiaId=");
		sb.append(noticiaId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", titulo=");
		sb.append(titulo);
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", fileUrl=");
		sb.append(fileUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Noticia toEntityModel() {
		NoticiaImpl noticiaImpl = new NoticiaImpl();

		if (uuid == null) {
			noticiaImpl.setUuid("");
		}
		else {
			noticiaImpl.setUuid(uuid);
		}

		noticiaImpl.setNoticiaId(noticiaId);
		noticiaImpl.setUserId(userId);

		if (userName == null) {
			noticiaImpl.setUserName("");
		}
		else {
			noticiaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			noticiaImpl.setCreateDate(null);
		}
		else {
			noticiaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			noticiaImpl.setModifiedDate(null);
		}
		else {
			noticiaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (titulo == null) {
			noticiaImpl.setTitulo("");
		}
		else {
			noticiaImpl.setTitulo(titulo);
		}

		if (descricao == null) {
			noticiaImpl.setDescricao("");
		}
		else {
			noticiaImpl.setDescricao(descricao);
		}

		noticiaImpl.setDocumentId(documentId);

		if (fileUrl == null) {
			noticiaImpl.setFileUrl("");
		}
		else {
			noticiaImpl.setFileUrl(fileUrl);
		}

		noticiaImpl.resetOriginalValues();

		return noticiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		noticiaId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		titulo = objectInput.readUTF();
		descricao = objectInput.readUTF();

		documentId = objectInput.readLong();
		fileUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(noticiaId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (titulo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titulo);
		}

		if (descricao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descricao);
		}

		objectOutput.writeLong(documentId);

		if (fileUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUrl);
		}
	}

	public String uuid;
	public long noticiaId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String titulo;
	public String descricao;
	public long documentId;
	public String fileUrl;

}