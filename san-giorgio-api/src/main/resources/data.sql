
insert into tb_seller (seller_id, seller_name) values (1, 'Americanas');
insert into tb_seller (seller_id, seller_name) values (2, 'Riachuelo');
insert into tb_seller (seller_id, seller_name) values (3, 'Renner');

insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (1, 1, 'BOLETO', 10.0, 8.0, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (2, 1, 'PIX', 11.35, 9.85, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (3, 3, 'BOLETO', 5.11, 6.85, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (4, 2, 'BOLETO', 18.02, 18.02, null);

