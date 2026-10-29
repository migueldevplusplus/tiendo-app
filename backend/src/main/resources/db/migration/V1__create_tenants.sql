CREATE TABLE tenants (
    id              UUID                        PRIMARY KEY DEFAULT gen_random_uuid(),
    name            VARCHAR(50)                 NOT NULL,
    phone_number    VARCHAR(20)                 NOT NULL,
    slug            VARCHAR(50)                 NOT NULL UNIQUE,
    address         VARCHAR(255),
    logo_url        VARCHAR(255),
    created_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    disabled_at     TIMESTAMP WITH TIME ZONE
);