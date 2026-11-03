CREATE TABLE users (
                       id              UUID                        PRIMARY KEY DEFAULT gen_random_uuid(),
                       tenant_id       UUID                        NOT NULL REFERENCES tenants (id),
                       username        VARCHAR(50)                 NOT NULL UNIQUE,
                       password_hash   VARCHAR(100)                NOT NULL,
                       role            VARCHAR(30)                 NOT NULL DEFAULT 'OWNER',
                       created_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       disabled_at     TIMESTAMP WITH TIME ZONE
);

CREATE INDEX idx_users_tenant_id ON users (tenant_id);