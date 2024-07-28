CREATE TABLE ACCOUNT (
                         id BIGINT PRIMARY KEY,
                         credit_card_number VARCHAR(255)
);

CREATE TABLE BENEFICIARY (
                             id BIGINT PRIMARY KEY,
                             name VARCHAR(255),
                             allocation_percentage DOUBLE,
                             account_id BIGINT,
                             FOREIGN KEY (account_id) REFERENCES ACCOUNT(id)
);

CREATE TABLE RESTAURANT (
                            id BIGINT PRIMARY KEY,
                            merchant_number VARCHAR(255),
                            benefit_percentage DOUBLE
);
