
insert into tb_seller (seller_id, seller_name) values (1, 'Americanas');
insert into tb_seller (seller_id, seller_name) values (2, 'Riachuelo');
insert into tb_seller (seller_id, seller_name) values (3, 'Renner');

insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (1, 1, '1111 1111', 10.0, null, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (2, 1, '2222 2222', 11.35, null, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (3, 3, '3333 3333', 5.11, null, null);
insert into tb_payment (payment_id, seller_id, billing_code, original_value, amount_paid, payment_status) values (4, 2, '4444 4444', 18.02, null, null);

