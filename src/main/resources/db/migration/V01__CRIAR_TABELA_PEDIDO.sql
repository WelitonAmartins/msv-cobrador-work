create table PEDIDO ( 
	ID SERIAL not null constraint PK_COD_PEDIDO primary key,
	COD_PEDIDO INTEGER, 
	DT_PEDIDO DATE not NULL,
	EMAIL VARCHAR(100) not NULL,
	VALOR NUMERIC(4,2) not null,
	TIPO INTEGER not null,
	STATUS VARCHAR(100) not null
)
	