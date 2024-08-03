-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
    id SERIAL NOT NULL,
    "name" varchar NULL,
    age int4 NULL,
    gender bit(1) NULL,
    CONSTRAINT student_pkey PRIMARY KEY (id)
);