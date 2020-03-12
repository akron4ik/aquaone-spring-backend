DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM cart;
DELETE FROM category;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, surname, email, password, phone, address) VALUES
  ('User', 'User', 'user@yandex.ru', '{noop}password', '8(985)123-4567', 'Moscow, Amurskay st, 48 - 52'),
  ('Admin', 'Admin' , 'admin@gmail.com', '{noop}admin', '+7(916)123-7654', 'Voronezh, Lenin street, 1, 22'),
  ('User2', 'User2', 'user@mail.ru', '{noop}password1', '8(985)123-0000', 'Moscow, Amurskay st, 48 - 52');


INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001),
  ('ROLE_USER', 100002);

INSERT INTO category (id, name) VALUES
(1, 'Вода'),
(2, 'Посуда'),
(3, 'Кулеры'),
(4, 'Всё');

INSERT INTO products (categoryId, name, description, price, image)
VALUES (1,'Вода 19 литров', 'Природная вода', 300, '/img/main/kash19.jpg'),
       (1,'Вода 5 литра', 'Минеральная вода', 150, '/img/main/kash5.jpg'),
       (1,'Вода 1.5 литра', 'Газированная вода', 90, '/img/main/kash15.jpg'),
       (1,'Вода 1.5 литра', 'Минеральная вода', 80, '/img/main/kash15.jpg'),
       (1,'Вода 0.5 литра', 'Газированная вода', 50, '/img/main/kash05.jpg'),
       (1,'Вода 0.5 литра', 'Минеральная вода', 40,'/img/main/kash05.jpg'),
       (2, 'Стаканчики', 'Пластиковые', 200, '/img/main/stakan.jpeg'),
       (2, 'Вилки', 'Пластиковые', 150, '/img/main/vilki.jpg'),
       (2, 'Тарелки', 'Пластиковые', 250, '/img/main/tarelki.jpg'),
       (2, 'Ложки', 'Для кофе', 150, '/img/main/ложки.jpg'),
       (3, 'Кулер для воды LC-AEL-301bd', 'Кулер с большим холодильником на 50л и дисплеем', 38050, '/img/main/cooler1.jpg'),
       (3, 'Кулер для воды LC-AEL-180c LCD', 'Оснащен 16-ти литровым шкафчиком и монитором', 12100, '/img/main/cooler2.jpg'),
       (3, 'Кулер для воды LC-AEL-812a', 'Кулер для воды с нижней загрузкой бутыли', 36750, '/img/main/cooler3.jpg');

INSERT INTO cart (date, phone, surname, price, comment) VALUES
  ('2019-12-01 10:30:00', '1234567', 'Ivanov', 3000, 'Test data'),
  ('2019-12-02 11:30:00', '1234567', 'Ivanov', 5000, 'Test data'),
  ('2019-12-03 20:30:00', '1234567', 'Ivanov', 4400, 'Test data'),
  ('2019-12-05 21:40:00', '1234567', 'Petrov', 1000, 'Test data'),
  ('2019-12-01 11:40:00', '1234567', 'Petrov', 1800, 'Test data'),
  ('2019-12-06 16:35:00', '1234567', 'Petrov', 1800, 'Test data');

