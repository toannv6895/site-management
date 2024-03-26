CREATE SEQUENCE IF NOT EXISTS site_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE sites
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255),
    groups   VARCHAR(255),
    address   VARCHAR(255),
    city      VARCHAR(255),
    province  VARCHAR(255),
    country   VARCHAR(255),
    latitude  DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    CONSTRAINT pk_sites PRIMARY KEY (id)
);