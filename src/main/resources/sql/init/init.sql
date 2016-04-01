-- Table: public.mile_1402260089

-- DROP TABLE public.mile_1402260089;
CREATE TABLE public.mile_1402260089
(
  id integer NOT NULL,
  data bigint,
  tick bigint NOT NULL,
  "time" double precision NOT NULL,
  CONSTRAINT mile_1402260089_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.mile_1402260089
  OWNER TO postgres;
