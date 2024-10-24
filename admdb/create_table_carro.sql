USE teste_api_db;

GO

CREATE TABLE carro (
	id bigint primary key identity(1,1) NOT NULL,
	descricao VARCHAR(255) DEFAULT NULL,
	latitude VARCHAR(255) DEFAULT NULL,
	longitude VARCHAR(255) DEFAULT NULL,
	nome VARCHAR(255) DEFAULT NULL,
	tipo VARCHAR(255) DEFAULT NULL,
	url_foto VARCHAR(255) DEFAULT NULL,
	url_video VARCHAR(255) DEFAULT NULL
);