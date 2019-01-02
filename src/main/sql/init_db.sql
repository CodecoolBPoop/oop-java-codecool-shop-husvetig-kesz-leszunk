create table product
(
  id            bigserial not null
    constraint product_pkey
      primary key,
  name          text      not null,
  default_price integer   not null,
  description   text      not null,
  category_id   integer   not null
    constraint product___fk
      references product_category,
  supplier_id   integer   not null
    constraint product___fk_2
      references supplier
);

create table product_category
(
  id          bigserial not null
    constraint product_category_pkey
      primary key,
  name        text      not null,
  department  text      not null,
  description text      not null
);

create table supplier
(
  id          bigserial not null
    constraint supplier_pkey
      primary key,
  name        text      not null,
  description text      not null
);