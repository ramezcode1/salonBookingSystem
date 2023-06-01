INSERT INTO `barbers`
(`email`, `name`, `phone_number`)
VALUES
('jack@gmail.com', 'Jackson', '5141112222'),
('luc@gmail.com', 'Lucas', '5141112222'),
('oli@gmail.com', 'Oliver', '5141112222'),
('theok@gmail.com', 'Theo', '5141112222');

INSERT INTO `services`
(`duration`, `name`, `price`)
VALUES
(30, "Men's Haircut", 50),
(30, "Beard Trimming", 20),
(30, "Men's Colouration", 30),
(30, "Blow-dry / Brushing", 20),
(30, "Highlights", 50);

INSERT INTO `service_provider`
(`service_id`, `barber_id`)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(4, 3),
(4, 4),
(5, 1),
(5, 3);