create table tb_seller (
    seller_id int not null,
    seller_name varchar(100) not null,
    primary key (seller_id)
);

create table tb_payment (
    payment_id int not null,
    seller_id int not null,
    billing_code varchar(50) not null,
    original_value number not null,
    amount_paid number not null,
    payment_status varchar(50) null,
    primary key (payment_id)
);
