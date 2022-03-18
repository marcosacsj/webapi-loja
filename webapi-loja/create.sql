CREATE TABLE IF NOT EXISTS public.tb_app
(
    id uuid NOT NULL,
    app_category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    app_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    app_price double precision NOT NULL,
    CONSTRAINT tb_app_pkey PRIMARY KEY (id),
    CONSTRAINT uk_3k1aiaksc8e5kinh3otg7bf9r UNIQUE (app_name)
)
