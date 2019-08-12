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

package Global.eda.sb.model.impl;

import Global.eda.sb.model.GlobalEda;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing GlobalEda in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GlobalEdaCacheModel
	implements CacheModel<GlobalEda>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GlobalEdaCacheModel)) {
			return false;
		}

		GlobalEdaCacheModel globalEdaCacheModel = (GlobalEdaCacheModel)obj;

		if (fooId == globalEdaCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", field1=");
		sb.append(field1);
		sb.append(", field2=");
		sb.append(field2);
		sb.append(", field3=");
		sb.append(field3);
		sb.append(", field4=");
		sb.append(field4);
		sb.append(", field5=");
		sb.append(field5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GlobalEda toEntityModel() {
		GlobalEdaImpl globalEdaImpl = new GlobalEdaImpl();

		if (uuid == null) {
			globalEdaImpl.setUuid("");
		}
		else {
			globalEdaImpl.setUuid(uuid);
		}

		globalEdaImpl.setFooId(fooId);
		globalEdaImpl.setGroupId(groupId);
		globalEdaImpl.setCompanyId(companyId);
		globalEdaImpl.setUserId(userId);

		if (userName == null) {
			globalEdaImpl.setUserName("");
		}
		else {
			globalEdaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			globalEdaImpl.setCreateDate(null);
		}
		else {
			globalEdaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			globalEdaImpl.setModifiedDate(null);
		}
		else {
			globalEdaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (field1 == null) {
			globalEdaImpl.setField1("");
		}
		else {
			globalEdaImpl.setField1(field1);
		}

		globalEdaImpl.setField2(field2);
		globalEdaImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			globalEdaImpl.setField4(null);
		}
		else {
			globalEdaImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			globalEdaImpl.setField5("");
		}
		else {
			globalEdaImpl.setField5(field5);
		}

		globalEdaImpl.resetOriginalValues();

		return globalEdaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		field1 = objectInput.readUTF();

		field2 = objectInput.readBoolean();

		field3 = objectInput.readInt();
		field4 = objectInput.readLong();
		field5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (field1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field1);
		}

		objectOutput.writeBoolean(field2);

		objectOutput.writeInt(field3);
		objectOutput.writeLong(field4);

		if (field5 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field5);
		}
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;

}