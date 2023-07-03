INSERT INTO `pizza` (`price`, `description`, `img_url`, `name`) VALUES ('6.99', 'pizza molto buona', 'https://www.radiolinea.it/wp-content/uploads/2023/06/pizza.jpeg', 'Margherita');

INSERT INTO `pizza` (`price`, `description`, `img_url`, `name`) VALUES ( '7.99', 'pizza più buona', 'https://blog.giallozafferano.it/cucinaconmiasorella/wp-content/uploads/2019/05/Pizza-alla-boscaiola-bianca-or.jpg', 'Boscaiola');


INSERT INTO `discount` (`end_date`, `pizza_id`, `start_date`, `title`) VALUES ('2023-07-31', '1', '2023-06-28', 'Sconto Margherita');
INSERT INTO `discount` (`end_date`, `pizza_id`, `start_date`, `title`) VALUES ('2023-07-11','1', '2023-06-18', 'Super sconto Margherita');

INSERT INTO `ingredient` (`name`) VALUES ('Funghi');
INSERT INTO `ingredient` (`name`) VALUES ('Mozzarella');
INSERT INTO `ingredient` (`name`) VALUES ('Pomodoro');

INSERT INTO `pizza_ingredients` (`ingredient_id`, `pizza_id`) VALUES ('2', '1'), ('2', '2'),('3', '1');