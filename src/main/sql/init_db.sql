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

INSERT INTO supplier (id, name, description)
values (1, 'Nubian-Design-Collective', 'Digital content and services'),
       (2, 'Serv-O-Droids', 'Droids');

INSERT INTO product_category(id, name, department, description)
values (1, 'Robotics', 'Hardware', 'Robotics'),
       (2, 'Spaceship', 'Hardware', 'Spaceships and spaceship parts'),
       (3, 'Weapon', 'Weapon', 'Weapons and stuff' );

INSERT INTO product (id, name, default_price, description, category_id, supplier_id)
values (1, 'S-5 heavy blaster pistol', 1499.9, 'A versatile weapon with a heavy wooden gripstock and twin scopes for sighting and rangefinding', 3, 1),
       (2, 'Bionic Arm', 2490.9, 'An affordable, advanced and intuitive bionic arm. Adjustable finger bone crack sound effect. Grab it fast.', 1, 1),
       (3, 'Custom Build Podracer', 5990, 'A one-man cockpit that pulled along by two engines. Capable of achieving speeds over 900 kilometers per hour, sometimes fails at start.', 2, 2);




"S-5 heavy blaster pistol", 1499.9f, "USD", "A versatile weapon with a heavy wooden gripstock and twin scopes for sighting and rangefinding. ", weapon, amazon));
productDataStore.add(new Product("Bionic Arm", 2490.9f, "USD", "An affordable, advanced and intuitive bionic arm. Adjustable finger bone crack sound effect. Grab it fast.", robotics, lenovo));
productDataStore.add(new Product("Custom Build Podracer", 5990, "USD", "A one-man cockpit that pulled along by two engines. Capable of achieving speeds over 900 kilometers per hour, sometimes fails at start.", spaceShipPart, amazon));
productDataStore.add(new Product("Spaceship Engine", 11990, "USD", "Spaceship engine at it's finest. Good condition, fall in price.", spaceShipPart, amazon));
productDataStore.add(new Product("T-14 hyperdrive generator", 8990, "USD", "A propulsion system that allows a starship to reach lightspeed.", spaceShipPart, amazon));
productDataStore.add(new Product("Pit Droid", 2990, "USD", "Cheap and durable repair droids. Tap their 'nose' to fold into compact form. ", robotics, lenovo));