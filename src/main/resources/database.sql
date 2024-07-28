-- Inserting initial data
INSERT INTO ACCOUNT (credit_card_number, account_number) VALUES ('1234123412341234', 'AC12345');
INSERT INTO ACCOUNT (credit_card_number, account_number) VALUES ('2345234523452345', 'AC23456');

INSERT INTO BENEFICIARY (account_id, name, allocation_percentage) VALUES (1, 'Annabelle', 50.0);
INSERT INTO BENEFICIARY (account_id, name, allocation_percentage) VALUES (1, 'Corgan', 50.0);

INSERT INTO RESTAURANT (merchant_number, benefit_percentage) VALUES ('1234567890', 8.0);
INSERT INTO RESTAURANT (merchant_number, benefit_percentage) VALUES ('0234567891', 10.0);