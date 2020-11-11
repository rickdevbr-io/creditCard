CREATE sequence sq_student_stud;

create table tb_student_stud(
	id_student int8 NOT NULL,
	nr_registration_record int8 NOT NULL,
	st_name varchar(100) NOT NULL,
	st_nickname varchar(30) NOT NULL,
	dt_born date,
	st_identification varchar(11) NOT NULL,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_student_pkey PRIMARY KEY (id_student)
);