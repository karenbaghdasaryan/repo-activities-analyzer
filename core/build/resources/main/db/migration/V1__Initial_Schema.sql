CREATE TABLE IF NOT EXISTS account (
	id                BIGSERIAL       PRIMARY KEY,
	uid               VARCHAR(128)    NOT NULL UNIQUE,
	first_name        VARCHAR(64)     DEFAULT NULL,
	last_name         VARCHAR(64)     DEFAULT NULL,
	username          VARCHAR(64)     DEFAULT NULL,
	email             VARCHAR(64)     DEFAULT NULL,
	password          VARCHAR(256),
	created_at        TIMESTAMP       DEFAULT now(),
	updated_at        TIMESTAMP       DEFAULT now()
);

CREATE TABLE IF NOT EXISTS bookmark (
	id                BIGSERIAL       PRIMARY KEY,
	uid               VARCHAR(128)    NOT NULL UNIQUE,
	repo_full_name    VARCHAR(64)     DEFAULT NULL,
	created_at        TIMESTAMP       DEFAULT now(),
	updated_at        TIMESTAMP       DEFAULT now()
);

CREATE TABLE IF NOT EXISTS account_bookmark (
	id               BIGSERIAL PRIMARY KEY,
	account          BIGINT NOT NULL REFERENCES account (id) ON DELETE CASCADE,
	bookmark         BIGINT NOT NULL REFERENCES bookmark (id) ON DELETE CASCADE,
	created_at       TIMESTAMP    DEFAULT now(),
	updated_at       TIMESTAMP    DEFAULT now()
);