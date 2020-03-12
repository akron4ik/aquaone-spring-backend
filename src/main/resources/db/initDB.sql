DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS category;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  surname          VARCHAR                         ,
  organization     VARCHAR                         ,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  phone            VARCHAR                 NOT NULL,
  address          VARCHAR                 NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL


);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE

);
CREATE TABLE category (
  id INTEGER NOT NULL PRIMARY KEY ,
  name VARCHAR NOT NULL
);

CREATE TABLE products (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  categoryId  INTEGER   NOT NULL,
  name        VARCHAR   NOT NULL,
  description TEXT      NOT NULL,
  price       INTEGER   NOT NULL,
  image       VARCHAR   NOT NULL,
  FOREIGN KEY (categoryId) REFERENCES category(id)
);

CREATE TABLE cart (
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date TIMESTAMP DEFAULT now() NOT NULL,
  phone VARCHAR NOT NULL,
  surname VARCHAR NOT NULL,
  price INTEGER NOT NULL,
  comment VARCHAR
);

