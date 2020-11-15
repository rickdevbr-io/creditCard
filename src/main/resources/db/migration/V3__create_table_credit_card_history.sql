CREATE sequence sq_credit_card_history_cchi;

create table tb_credit_card_history_cchi(
	id_credit_card_history int8 NOT NULL,
	nr_card_number int8 NOT NULL,
	db_amount_paid numeric(15,2) NOT NULL ,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_credit_card_history_pkey PRIMARY KEY (id_credit_card_history)
);