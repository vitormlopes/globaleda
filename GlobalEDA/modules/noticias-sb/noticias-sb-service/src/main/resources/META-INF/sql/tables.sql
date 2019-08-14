create table EDA_Noticia (
	uuid_ VARCHAR(75) null,
	noticiaId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	titulo VARCHAR(75) null,
	descricao VARCHAR(75) null,
	documentId LONG,
	fileUrl VARCHAR(75) null
);