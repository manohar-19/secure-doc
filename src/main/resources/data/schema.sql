BEGIN;

--CREATE DATABASE IF NOT EXISTS docdatabase;

--CREATE TABLE IF NOT EXISTS test(
--    id SERIAL PRIMARY KEY,
--    name VARCHAR(255) NOT NULL
--);


CREATE INDEX IF NOT EXISTS index_users_email On users(email);
CREATE INDEX IF NOT EXISTS index_users_user_id On users(user_id);
CREATE INDEX IF NOT EXISTS index_confirmation_user_id On confirmations(user_id);
CREATE INDEX IF NOT EXISTS index_credentials_user_id On credentials(user_id);
CREATE INDEX IF NOT EXISTS index_user_roles_user_id On user_roles(user_id);
END;