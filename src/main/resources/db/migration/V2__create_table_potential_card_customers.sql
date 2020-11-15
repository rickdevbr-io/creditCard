CREATE sequence sq_potential_card_customers_pccu;

create table tb_potential_card_customers_pccu(
	id_potential_card_customers int8 NOT NULL,
	nr_registration_record int8,
	st_client_name varchar(100) NOT NULL,
	nr_card_number int8 NOT NULL,
	db_maximum_spend numeric(15,2) NOT NULL ,
	db_minimum_spend numeric(15,2) NOT NULL,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_potential_card_customers_pkey PRIMARY KEY (id_potential_card_customers)
);