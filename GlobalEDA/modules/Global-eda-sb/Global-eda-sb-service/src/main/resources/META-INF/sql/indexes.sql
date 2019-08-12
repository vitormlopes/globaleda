create index IX_B5A41F94 on EDA_GlobalEda (field2);
create index IX_DC1CB9C on EDA_GlobalEda (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9540891E on EDA_GlobalEda (uuid_[$COLUMN_LENGTH:75$], groupId);